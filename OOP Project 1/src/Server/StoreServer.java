package Server;

import Transactions.Transaction;
import Transactions.Invoice;
import Post.*;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import Catalog.*; // Imports catalog package
import PaymentVerifier.*;
import RMI.ServerInterface;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


/**
 *
 * @author Brian Parra
 * This is supposed to be an instance of a store server. Pretend that when you instantiate it you can tell it which port to listen to and 
 * what not. There can be multiple StoreServers if you have multiple server racks at your store. Posts will connect to available StoreServers;
 * 
 * 
 */
public class StoreServer extends UnicastRemoteObject implements ServerInterface{
    
    private PaymentVerifier paymentVerifier;
    public String storeName;
    public Post currentPost;
    private final String CATALOG_DATABASE = "products.txt";
    private Stock catalog; // catalog instance

    
    /**
     * Initializes a StoreServer. This would be the part of the program that sits on the store's servers and listens for POSTs's requests.
     * @param name the name of the store
     */
    public StoreServer(String name) throws RemoteException{
        super();
        //Initialize stuff here needs to read in data and what not
        this.storeName = name;

        //First check and see if this store has already been created
        catalog = new Stock(CATALOG_DATABASE); // creates an object of the Stock class
        catalog.loadCatalog(); // loads catalog of products in memory

        paymentVerifier = new PaymentVerifier();

        //For now directly make a post and run it
        //currentPost = new Post(this);
        //currentPost.runPost();

    }

 
    
    @Override 
    public Stock getCatalog() throws RemoteException{
        
      
            return this.catalog;
        
    }
    
    @Override
    public String getRemoteStoreName() throws RemoteException{
        
        return this.storeName;
        
    }
  


   
    
    /**
     * This takes a transaction, verifies it, then makes an invoice and logs it before sending it back to the client POST
     * @param transaction transaction to verify
     * @return Invoice with all calculated values and status
     * @throws java.rmi.RemoteException
     */
    @Override 
    public boolean verifyTransaction(Transaction transaction) throws RemoteException{
        boolean isValid;
        /*
        Invoice invoice = new Invoice(transaction , this.storeName);
       
        //Do some basic checking like random chance that check/credit card is bad or fake bills
        if(!paymentVerifier.verify(invoice)){
           
            invoice.setValid(false);
            return false;
        }
        //invoice.saveInSalesLog();
        */
        return true;
    }
    
    /**
     * Get the Store's name
     * @return Store's name
     */
    public String getName(){
        return this.storeName;
    }
    

    
    public static void main(String args[]) {
        /*
	     * The main method register the server
	     * and start running the server
         */
        try {
            StoreServer storeServer = new StoreServer("Walmart");
            //g.addServerSecurity();
            Registry reg = LocateRegistry.createRegistry(19667);
            reg.rebind("Store", storeServer);
            //g.registerServer();
            System.out.println("Server has been registered Succesfully now run the client");
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
