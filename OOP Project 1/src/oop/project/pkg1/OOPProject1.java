/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.project.pkg1;

import java.util.Scanner;
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
        String option;
        String path = "./stores/";

        // TODO code application logic here
        System.out.println("Initializing Store System");
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("***SYSTEM CONTROL***");
            System.out.println("Enter Store name to load/create store, or \"exit\"");
            option = sc.nextLine();
            if (option.equals("exit")) {
                break;
            } else if (Files.isDirectory(Paths.get("./stores/" + option))) {

                Store currentStore = new Store(option , path);
                currentStore.runStore();

            } else {
               
               while (true) {
                    System.out.println("***SYSTEM CONTROL***");
                    System.out.println("Store Data not found. Would you like to create a new store? (yes/no)");
                    option = sc.nextLine();
                    if (option.equals("yes") || option.equals("y")) {
                       
                        Store.createStore(option);
                        Store currentStore = new Store(option , path);
                        currentStore.runStore();
                        
                        break;
                    } else if (option.equals("no") || option.equals("n")) {
                        break;
                    } else {
                        System.out.println("Invalid Entry, Try Again");
                    }
                }
            }
        }

    }

}
