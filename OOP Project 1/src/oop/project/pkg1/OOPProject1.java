/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.project.pkg1;
import java.util.Scanner;
/**
 *
 * @author mac
 */
public class OOPProject1 {
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Initializing Store");
        System.out.println("Please Enter your Store Name");
        String storeName = sc.next();
        Store currentStore = new Store(storeName);
        
    }
    
}

