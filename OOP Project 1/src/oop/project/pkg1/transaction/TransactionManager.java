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
import java.io.BufferedReader;
import java.util.ArrayList;


public class TransactionManager {
    private static ArrayList<Customer> customerList;
    private Store store;
    public TransactionManager (Store _store)
    {
        this.store = _store;
    }
    public static ArrayList<Customer> getTransactions() {
		if (customerList == null) {
			TransactionReader.viewTransactions();
		}

		return customerList;
	}  
}
