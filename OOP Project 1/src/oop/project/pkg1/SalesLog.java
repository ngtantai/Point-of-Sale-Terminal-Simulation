package oop.project.pkg1;

import Catalog.Product;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import oop.project.pkg1.transaction.Invoice;
import oop.project.pkg1.transaction.Transaction;

/**
 *
 * @author Jose Ortiz Costa Description: This class contains two static methods
 * one of them writes a invoice to a salesLog database, and the other one prints
 * all the invoices from the salesLog database.
 * @see Invoice class
 * @see Transaction class
 *
 */
public class SalesLog  {

    static final String DEFAULT_SALESLOG_FILE = "salesLog.txt";
    
    /**
     * Writes a invoice in a salesLog database 
     * @param transaction transaction to make the invoice
     * @param logFile     salesLog file to write the invoice
     */
    public static void writeInvoice(Transaction transaction, String logFile) {
        new Invoice(transaction).saveInSalesLog(logFile);

    }
    /**
     * Prints all the sales recorded in a salesLog file.
     * @param logFile 
     */
    public static void printInvoices(String logFile) {
        new Invoice().readAllInvoices(logFile);
    }

}
