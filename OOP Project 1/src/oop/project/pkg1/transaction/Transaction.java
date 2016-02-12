/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.project.pkg1.transaction;

import Catalog.Product;
import Catalog.Stock;
import java.util.ArrayList;


/**
 *
 * @author mac
 */
public class Transaction {
    public Customer customer;
    public Payment payment;
    private String upc;
    private double total;
    
    public Transaction (Customer customer)
    {
        this.customer = customer;
        setPayment(new Payment(98.00, "CHECK"));
        
    }
    public void setPayment(Payment payment)
    {
        this.payment = payment;
    }
    
    public void setCostumer (Customer customer)
    {
        this.customer = customer;
    }
    public Payment getPayment()
    {
        
        return this.payment;
    }
    
    public Customer getCustomer ()
    {
        return this.customer;
    }
   
    
    public ArrayList <Product> getProducts ()
    {
        // get upc from transaction 
        // 
        Stock catalog = new Stock("products.txt");
        catalog.loadCatalog();
        ArrayList <Product> products = new ArrayList<>();
        //******* just for testing  delete later***************
        // get products by a given upc
        Product product1 = catalog.getProduct("1111"); 
        Product product2 = catalog.getProduct("1112");
        Product product3 = catalog.getProduct("1113");
        product1.setQuantity(1);
        product2.setQuantity(2);
        product3.setQuantity(2);
        // Logic here
        // data for testing
        products.add(product1);
        products.add(product2);
        products.add(product3);
        
        //************** end testing *****************
        return products;
    }
    
    
}
