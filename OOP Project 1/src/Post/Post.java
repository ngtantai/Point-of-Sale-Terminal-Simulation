/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Post;

import oop.project.pkg1.Store;
import oop.project.pkg1.transaction.*;



/**
 *
 * @author mac
 */
public final class Post{
    private Store parentStore;
    private String option;
    private TransactionManager transactionManager;
    

    public Post(Store _parentStore) {
        //Reference to the store it belongs
        this.parentStore = _parentStore;
        this.transactionManager = new TransactionManager(this);
        System.out.println("Post Initialized!");
        
        
        
 
    }
    
    public void runPost(){
        //this.transactionManager.getTransactions();
        System.out.println("should be reading transactions here");
    }
    
 
    
}
