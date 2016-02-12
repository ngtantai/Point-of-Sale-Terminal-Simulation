/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Post;

import Transactions.TransactionManager;
import Transactions.Transaction;
import Transactions.Invoice;
import Catalog.Product;
import Catalog.Stock;
import java.util.ArrayList;
import Server.Store;



/**
 *
 * @author mac
 */
public final class Post{
    private Store parentStore;
    private TransactionManager transactionManager;
    private Stock catalog; // its own copy of the catalog for display purposes
    private Invoice invoice;
    

    public Post(Store _parentStore) {
        //Reference to the store it belongs
        this.parentStore = _parentStore;
        this.transactionManager = new TransactionManager(this);
        this.catalog = this.parentStore.getCatalog();
        System.out.println("Initializing Post");
        
        
        
        
 
    }
    
    public void runPost(){
        System.out.println("***Post Running***\n\n\n");
        

        //For now just get an array of transactions and process them (Replace with gui later)
        ArrayList<Transaction> transactions = this.transactionManager.getTransactions();
       
        //Now we loop through each transaction and communicate with the "Store Server" To check if the transactions go through
        for (Transaction transaction : transactions) {
            
            //Check for transaction
            invoice = this.parentStore.verifyTransaction(transaction);
            invoice.printInvoice();
        }

    }
    
    public Product generateProductByUPC(String _upc){
        return new Product(this.catalog.getProduct(_upc));
    }
    
 
    
}
