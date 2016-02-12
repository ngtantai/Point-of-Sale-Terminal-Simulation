/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Post;

import java.util.ArrayList;
import oop.project.pkg1.Store;
import oop.project.pkg1.transaction.*;



/**
 *
 * @author mac
 */
public final class Post{
    private Store parentStore;
    private TransactionManager transactionManager;
    

    public Post(Store _parentStore) {
        //Reference to the store it belongs
        this.parentStore = _parentStore;
        this.transactionManager = new TransactionManager(this);
        System.out.println("Initializing Post");
        
        
        
        
 
    }
    
    public void runPost(){
        System.out.println("Post Running");
        

        //For now just get an array of transactions and process them (Replace with gui later)
        ArrayList<Transaction> transactions = this.transactionManager.getTransactions();
       
        //Now we loop through each transaction and communicate with the "Store Server" To check if the transactions go through
        for (Transaction transaction : transactions) {
            
            //Check for transaction
            this.parentStore.verifyTransaction(transaction);
            
            //Test Output
            System.out.println(transaction.getTimeStamp());
            
            //If it is approved, then print an invoice
            

        }

    }
    
 
    
}
