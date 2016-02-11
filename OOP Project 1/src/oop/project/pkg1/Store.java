/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.project.pkg1;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import Catalog.*; // Imports catalog package

import oop.project.pkg1.transaction.TransactionManager;
/**
 *
 * @author mac
 */
public class Store {

    public String storeName;
    private int option;
    private String path;
    public Post currentPost;
    private TransactionManager transactionManager;
    private Stock catalog; // catalog instance
    
    public Store(String name , String path){
    

 
        //Initialize stuff here needs to read in data and what not
        this.storeName = name;
        this.path = path;
        transactionManager = new TransactionManager(this);
        //First check and see if this store has already been created
        catalog = new Stock(); // creates an object of the Stock class
        catalog.loadCatalog(); // loads catalog of products in memory
        
       

    }

    public void runStore() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n\n\n***STORE MENU***");
            System.out.println("Options : (Enter a number)");
            System.out.println("1: Exit");
            System.out.println("2: Start Post");
            System.out.println("3: Product Manager");
            System.out.println("4: Transaction Manager");

            option = sc.nextInt();
            if (option == 1) {
                //Exit the system
                System.out.println("Goodbye!");
                break;
            } else if (option == 2) {
                //Initialize the post
                currentPost = new Post(this);
                currentPost.runPost();
                //won't need the same object again, okay to get rid of it
                currentPost = null;

            } else if(option == 3){
                
                catalogManager();
                
            }else{
                System.out.println("Invalid Option");
            }
        }
    }

    public void test() {
        System.out.println("test");
    }

    public static void createStore(String option) {
        //Create directory and files
    }
    
    public String getPath(){
        
        return this.path;
    }
    
    public void catalogManager(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("\n\n\n***CATALOG MANAGER***");
            System.out.println("Options : (Enter a number)");
            System.out.println("1: Exit");
            System.out.println("2: View Catalog");
            System.out.println("3: Add Item");
            
            option = sc.nextInt();
            
            if(option == 1){
                //Exit the system
                System.out.println("--Returning To Store Main Menu--");
                break;
            }else if(option == 2){
                viewCatalog();
                //Output the catalog
            }else if(option == 3){
                
                //Add Item Wizard
                
            }else{
                System.out.println("Invalid Option");
            }
        }
    }
    
    private void pressAnyKeyToContinue() {
        System.out.println("Press ENTER to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }
    
    public void viewCatalog(){
        catalog.viewCatalog();
        pressAnyKeyToContinue();
    }
   
    
}
