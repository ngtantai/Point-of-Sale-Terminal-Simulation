package oop.project.pkg1.transaction;

import Catalog.Product;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Jose Ortiz Costa
 * @Description: This class contains all the methods and properties of a invoice
 * This class takes an object of the Transaction class as argument and prints a
 * formatted invoice on the screen
 * @see Transaction class
 * @see SalesLog class
 * @see Payment class
 */
public class Invoice {

    private Transaction transaction;
    private double subtotal;
    private double total;
    private double tendered;
    private double returned;
    static double TAXES = 4.50;
    ArrayList<Product> products;

    /**
     * Constructor
     */
    public Invoice() {

    }

    /**
     * Constructor
     *
     * @param _transaction Transaction Object
     */
    public Invoice(Transaction _transaction) {
        this.transaction = _transaction;
        this.products = _transaction.getProducts();
        setTotal(this.transaction.getPayment().getAmount());
        setAmountTendered(1000.50);
        setAmountReturned(this.tendered - this.total);

    }

    // Setters
    public void setSubTotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public void setAmountTendered(double tendered) {
        this.tendered = tendered;
    }

    public void setAmountReturned(double returned) {
        this.returned = returned;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    // Getters
    public double getSubTotal() {
        // subtotal without taxes included
        // this.subtotal = transaction.getQuantity() * transaction.getPrice();
        return this.subtotal;
    }

    public double getAmountTendered() {
        return this.tendered;
    }

    public double getAmountReturned() {

        return this.returned;
    }

    public Date getInvoiceDate() {
        return new Date();
    }

    public double getTotal() {
        // compute total amount including taxes
        return this.total;
    }

    // prints a single invoice into the salesLog db
    public void printInvoice() {
        this.toString();

    }

    /**
     * Saves a single invoice in the salesLog
     *
     * @param salesLogFile
     */
    public void saveInSalesLog(String salesLogFile) {
        try {
            FileWriter writer = new FileWriter(salesLogFile, true);
            writer.write(this.toString());
            writer.close();
        } catch (IOException err) {
            System.out.println("Error: This transaction couldn't be saved in the log \n"
                    + "Detailed Error: " + err.getMessage());

        }
    }

    /**
     * Read all the invoices from the salesLog
     *
     * @param salesLogFile
     */
    public void readAllInvoices(String salesLogFile) {
        try {
            FileInputStream fis = new FileInputStream(salesLogFile);
            //Construct BufferedReader from InputStreamReader
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException err) {
            System.out.println("Error: " + err.getMessage());
        }
    }

    /**
     *
     * @return a string representing the invoice formatted
     */
    @Override
    public String toString() {
        int i;

        String invoicePart1, invoicePart2 = "", invoicePart3, formattedPart1,
                formattedPart2, formattedPart3, separator, tenderedStr;
        formattedPart1 = "%-20s %-15s%n";
        formattedPart2 = "%-20s %-30s %8.2f%n";

        invoicePart1 = String.format(formattedPart1, "Store1", getInvoiceDate())
                + String.format(formattedPart1, transaction.getCustomer().getName(), "");

        for (i = 0; i < products.size(); i++) {
            invoicePart2 += String.format(formattedPart2, products.get(i).getDescription(),
                    products.get(i).getQuantity() + " @ "
                    + products.get(i).getPrice(),
                    products.get(i).getQuantity()
                    * products.get(i).getPrice());
        }

        separator = "-----------------------------------------------------------\n";
        if (transaction.getPayment().getType().equals("CREDIT")
                || transaction.getPayment().getType().equals("CHECK")) {
            tenderedStr = "Paid by " + transaction.getPayment().getType();
            setAmountTendered(getTotal());

        } else {
            tenderedStr = "Amount Tendered ";
        }

        invoicePart3 = String.format(formattedPart2, "Total", "", getTotal())
                + String.format(formattedPart2, tenderedStr, "", getAmountTendered())
                + String.format("Amount returned", "", getAmountReturned());

        return invoicePart1 + invoicePart2 + separator + invoicePart3 + "\n\n";

    }

}
