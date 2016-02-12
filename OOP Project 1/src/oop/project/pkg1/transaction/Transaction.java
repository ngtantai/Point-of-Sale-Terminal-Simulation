/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.project.pkg1.transaction;

import Catalog.Product;
import Catalog.Stock;
import java.time.LocalDateTime;
import java.util.ArrayList;


/**
 *
 * @author mac
 */
public class Transaction {
    public Customer customer;
    public Payment payment;
    private LocalDateTime timeStamp;
    private double total;
    private ArrayList<Product> products;
    
    public Transaction (Customer _customer, Payment _payment,  ArrayList<Product> _products )
    {
        //this.customer = customer;
        this.customer = _customer;
        this.payment = _payment;
        this.total = Payment.calculateTotal(products);
        this.products = _products;
        this.timeStamp = LocalDateTime.now();
        
    }
    
    public double getTotal(){
        return this.total;
    }
    
    public LocalDateTime getTimeStamp(){
        return this.timeStamp;
    }
    
    public void setPayment(Payment payment)
    {
        this.payment = payment;
    }
    
    public boolean isCashTransaction(){
        return this.payment.getType() == Payment.CASH;
    }
    
    public boolean isCreditTransaction(){
        return this.payment.getType() == Payment.CREDIT;
    }
    
    public boolean isCheckTransaction(){
        return this.payment.getType() == Payment.CHECK;
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

        return this.products;
    }
    
    
}
