package Transactions;

import Catalog.Product;
import Catalog.Stock;
import java.time.LocalDateTime;
import java.util.ArrayList;




/**
 *@description This is the transaction class it handles the details for performing a transaction at a store
 * 
 * @author Brian Parra
 * @param Customer The customer associate with the transaction
 * @param Payment The payment object
 * @param timeStamp The time of the transaction
 * @param total The total cost of the transaction
 * @param amountPaid The total amount paid. This can be different from the total
 * @param products Arraylist of products purchased
 * @param valid Boolean describing if this transaction is valid or not
 * 
 */
public class Transaction {
    public Customer customer;
    public Payment payment;
    public LocalDateTime timeStamp;
    public double total =0.0;
    public double amountPaid = 0.0;
    public ArrayList<Product> products;
    public boolean valid = true;
    
    public Transaction (Customer _customer, Payment _payment,  ArrayList<Product> _products )
    {
       
        this.customer = _customer;
        this.payment = _payment;
        this.products = _products;
        this.timeStamp = LocalDateTime.now();
        this.total = Payment.calculateTotal(this.products);
        this.amountPaid = this.payment.getAmount();
        
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
    
    public boolean isValid(){
        return this.valid;
    }
    
    public void setValid(boolean _valid){
        this.valid = _valid;
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
    
    public String getCustomerName(){
        return this.customer.getName();
    }
    
    public double getAmountPaid(){
        return this.amountPaid;
    }
    
    public String getPaymentTypeString(){
        String paymentType = "";
        if(this.isCashTransaction()){
           paymentType = "CASH"; 
        }else if(this.isCheckTransaction()){
            paymentType = "CHECK";
        }else if(this.isCreditTransaction()){
            paymentType = "CREDIT";
        }
        return paymentType;
    }
   
    
    public ArrayList <Product> getProducts ()
    {

        return this.products;
    }
    
    
}
