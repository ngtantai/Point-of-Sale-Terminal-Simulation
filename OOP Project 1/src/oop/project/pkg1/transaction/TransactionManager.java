/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.project.pkg1.transaction;

import Catalog.Product;
import Post.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author mac
 */
public class TransactionManager {

    private ArrayList<Transaction> transactions;
    private static BufferedReader bufferedReader;

    private final Post currentPost;

    public TransactionManager(Post _post) {
        this.currentPost = _post;
    }

    public ArrayList<Transaction> getTransactions() {
        transactions = new ArrayList<Transaction>();
        ArrayList<Product> products;
        Product currentProduct;
        Customer customer;
        Payment payment;
        String[] upcLine;
        String[] paymentInfo;

        try {
            bufferedReader = new BufferedReader(new FileReader("transactions.txt"));

        } catch (FileNotFoundException exception) {
            System.out.println(exception);

        }
        String line = " ";
        while (line != null) {
            try {
                products = new ArrayList<Product>();
                line = bufferedReader.readLine();
                customer = new Customer(line);
                line = bufferedReader.readLine();
                while (!line.contains("CREDIT") && !line.contains("CHECK") && !line.contains("CASH") && !line.equals("")) {
                    upcLine = line.split("[ ]+");
                    //ProductRecorded product = new ProductRecorded(array[0], Integer.parseInt(array[1]));
                    //Product product = new Product(array[0], Integer.parseInt(array[1]));
                    if (upcLine.length == 1) {
                        currentProduct = new Product(upcLine[0], 1);
                    } else {
                        currentProduct = new Product(upcLine[0], Integer.parseInt(upcLine[1]));
                    }

                    products.add(currentProduct);
                    line = bufferedReader.readLine();
                }
                paymentInfo = line.split("[ ]+");
                switch (paymentInfo[0]) {
                    case "CREDIT":
                        payment = new Payment(Payment.CREDIT, Payment.calculateTotal(products), Integer.parseInt(paymentInfo[1]));
                        break;
                    case "CHECK":
                        payment = new Payment(Payment.CHECK, Double.parseDouble(paymentInfo[1]));
                        break;
                    default:
                        payment = new Payment(Payment.CASH, Double.parseDouble(paymentInfo[1]));
                        break;
                }

                transactions.add(new Transaction(customer, payment, products));
                line = bufferedReader.readLine();
            } catch (Exception exception) {
                System.out.println(exception);
                break;
            }
        }

        return transactions;
    }
}
