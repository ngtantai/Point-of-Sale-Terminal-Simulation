/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.project.pkg1.transaction;

import oop.project.pkg1.Store;

/**
 *
 * @author mac
 */
//trial
public class TransactionManager {
    private Store parentStore;
    private String path;
    
    public TransactionManager(Store _parentStore){
        this.parentStore = _parentStore;
        this.path = this.parentStore.getPath();
    }
    
    public void makeTransaction(){
        
    }
    
    public void viewTransaction(){
        
    }
    
}
