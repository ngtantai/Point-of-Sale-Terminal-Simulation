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
public class Store {
    public String storeName;
    private int option;
    public Post currentPost;
    
    public Store(String name){
        //Initialize stuff here needs to read in data and what not
        
        this.storeName = name;
        System.out.println("Welcome");
        Scanner sc = new Scanner(System.in);
        
        while(true){
            System.out.println("Options : (Enter a number)\n1:Exit \n2:Start Post");
            option = sc.nextInt();
            if(option == 1){
                //Exit the system
                System.out.println("Goodbye!");
                break;
            }else if(option == 2){
                //Initialize the post
                this.initializePost();
                
            }else{
                System.out.println("Invalid Option");
            }
        }
        
    }
    
    public void test(){
        System.out.println("test");
    }
    
    private void initializePost(){
        //Initialize a new post
        currentPost = new Post(this);
        
        //When done, get rid of it
        currentPost = null;
    }
    
}
