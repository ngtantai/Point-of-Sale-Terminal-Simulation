/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.project.pkg1;

import Post.*;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import Catalog.*; // Imports catalog package
import PaymentVerifier.*;
import oop.project.pkg1.transaction.*;


/**
 *
 * @author mac
 */
public class Store {

    private PaymentVerifier paymentVerifier;
    public String storeName;
    
    public Post currentPost;
    private final String CATALOG_DATABASE = "products.txt";
    private Stock catalog; // catalog instance

    public Store(String name) {

        //Initialize stuff here needs to read in data and what not
        this.storeName = name;

        //First check and see if this store has already been created
        catalog = new Stock(CATALOG_DATABASE); // creates an object of the Stock class
        catalog.loadCatalog(); // loads catalog of products in memory

        paymentVerifier = new PaymentVerifier();

        //For now directly make a post and run it
        currentPost = new Post(this);
        currentPost.runPost();

    }

    public void runStore() {

    }
    
    public Stock getCatalog(){
        return this.catalog;
    }

    public void test() {
        System.out.println("test");
    }

    public void viewCatalog() {
        catalog.viewCatalog();

    }
    
    public Invoice verifyTransaction(Transaction transaction){
        Invoice invoice = new Invoice(transaction , this);
        
        //Do some basic checking like random chance that check/credit card is bad or fake bills
        if(!paymentVerifier.verify(invoice)){
           
            invoice.setValid(false);
        }
        invoice.saveInSalesLog();
        return invoice;
    }
    
    public String getName(){
        return this.storeName;
    }

}
