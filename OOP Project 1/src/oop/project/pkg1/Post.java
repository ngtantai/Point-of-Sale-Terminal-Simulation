/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.project.pkg1;

/**
 *
 * @author mac
 */
public class Post{
    private Store parentStore;

    public Post(Store _parentStore) {
        //Reference to the store it belongs
        this.parentStore = _parentStore;
        System.out.println("Post Initialized!");
    }
    
}
