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
public final class Post{
    private Store parentStore;
    private String option;
    

    public Post(Store _parentStore) {
        //Reference to the store it belongs
        this.parentStore = _parentStore;
        System.out.println("Post Initialized!");
        
 
    }
    
    public void runPost(){
        Scanner sc = new Scanner(System.in);
        int optionNumber;
        while(true){
            System.out.println("\n\n\n***POST TERMINAL***");
            System.out.println("Enter name to begin transaction, or \"exit\"");
            System.out.println("type CATALOG to view items");
            option = sc.nextLine();
            
            if (option.equals("exit")) {
                break;
            } else if (option.equals("CATALOG")){
                this.parentStore.viewCatalog();
            }

        }
    }
    
 
    
}
