/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.project.pkg1;


import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author mac
 */
public class OOPProject1 {

    /**
     * Main driver program
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {

        // TODO code application logic here
        System.out.println("Initializing Store System");
        
        //Just for testing
        Store currentStore = new Store("Walmart");
        
        //This will initialize the store's "Server"
        currentStore.runStore();
    }


}
