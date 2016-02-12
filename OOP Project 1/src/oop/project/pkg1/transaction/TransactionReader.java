/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.project.pkg1.transaction;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import Catalog.Product;

/**
 *
 * @author Tai
 */
public class TransactionReader {
    /*
    private static ArrayList<Customer> customerList;
    private static String path = "C:\\Users\\Tai\\Documents\\NetBeansProjects\\668-868-POST1-master\\668-868-POST1-master\\src\\transactions.txt";
    private static BufferedReader bufferedReader;
    /*
    * Reads transaction.txt which is a formatted file that contains
    * customer transaction information for QA testing.
    * Once the item has been verified, it adds that item
    * to the customer object.
    * @return	true	operation succeeded
    * @return	false	operation ended in error
    */
    
    /*
    public static boolean viewTransactions() {
        try { 
            bufferedReader = new BufferedReader(new FileReader(path));
            customerList = new ArrayList<Customer>();
        } catch (FileNotFoundException exception) {
            System.out.println(exception);
            return false;
        }
        Customer newCustomer;
	String line = " ";
        // Split each line into tokens delimited by one or more spaces '[ ]+'
	while (line != null) {
            try {
                line = bufferedReader.readLine();
                String name = line;
		newCustomer = new Customer(name);
		line = bufferedReader.readLine();
		while (!line.contains("CREDIT") && !line.contains("CHECK") && !line.contains("CASH") && !line.equals("")) {
                    String[] array = line.split("[ ]+");
                    //ProductRecorded product = new ProductRecorded(array[0], Integer.parseInt(array[1]));
                    Product product = new Product(array[0], Integer.parseInt(array[1]));
                    newCustomer.addItem(product);
                    line = bufferedReader.readLine();
		}
		String[] array = line.split("[ ]+");
                if (array[0].equals("CREDIT")) {
                    newCustomer.addPayment(new Payment(array[1]));
		} else if (array[0].equals("CHECK")) {
                    newCustomer.addPayment(new Payment(array[1]));
		} else if (array[0].equals("CASH")) {
                    newCustomer.addPayment(new Payment(array[1]));
		}
		customerList.add(newCustomer);
		line = bufferedReader.readLine();
            } catch (Exception exception) {
                System.out.println(exception);
		break;
            }
        }
        return true;
    }       
    */
}
