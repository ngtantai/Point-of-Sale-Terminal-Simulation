/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.project.pkg1.transaction;

import Post.*;
import java.io.BufferedReader;
import java.util.ArrayList;


/**
 *
 * @author mac
 */


public class TransactionManager {
    private static ArrayList<Customer> customerList;
    private Post currentPost;
    
    public TransactionManager (Post _post){
        this.currentPost = _post;
    }
    
    public static ArrayList<Customer> getTransactions() {
		if (customerList == null) {
			TransactionReader.viewTransactions();
		}

		return customerList;
	}  
}
