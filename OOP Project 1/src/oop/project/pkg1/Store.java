/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.project.pkg1;
import java.io.File;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 *
 * @author mac
 */
public class Store {
    public String storeName;
    private int option;
    public Post currentPost;
    
    public Store(String name){
        //Initialize stuff here needs to read in data and what not
        this.storeName = name;
        //First check and see if this store has already been created
        
        
        
        System.out.println("Welcome");
        
        
        
        
        
        
    }
    
    
    
    
    public void runStore(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("***STORE MENU***");
            System.out.println("Options : (Enter a number)");
            System.out.println("1: Exit");
            System.out.println("2: Start Post");
            System.out.println("3: Product Manager");
            System.out.println("4: Transaction Manager");
            
            option = sc.nextInt();
            if(option == 1){
                //Exit the system
                System.out.println("Goodbye!");
                break;
            }else if(option == 2){
                //Initialize the post
                currentPost = new Post(this);
                currentPost.runPost();
                //won't need the same object again, okay to get rid of it
                currentPost = null;
                
            }else{
                System.out.println("Invalid Option");
            }
        }
    }
    
    public void test(){
        System.out.println("test");
    }
    

    public static void createStore(String option){
        //Create directory and files
    }
    
   
    
}
