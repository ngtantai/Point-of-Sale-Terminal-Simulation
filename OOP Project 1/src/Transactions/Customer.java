/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transactions;

import java.util.ArrayList;
import java.util.Iterator;
import Catalog.Product;

/**
 *
 * @author Tai
 */
public class Customer {
        private ArrayList<Product> itemList = new ArrayList<>(); // items recorded from transaction.txt file
	private Payment payment; // customer can make payment
        private String name; // customer has name


	public Customer(String name) {
		this.name = name;
	}
        	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Customer(String name, ArrayList<Product> items, Payment payment) {
		this.name = name;
		this.itemList = items;
		this.payment = payment;
	}

	public void addItem(Product item) {
		itemList.add(item);
	}
	
	public void addPayment(Payment payment) {
		this.payment = payment;
	}

	public ArrayList<Product> getAllRecordedItems() {
		return itemList;
	}

	public Payment getPayment() {
		return payment;
	}
        
}
