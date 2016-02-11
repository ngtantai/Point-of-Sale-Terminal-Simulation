/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.project.pkg1.transaction;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Tai
 */
public class Customer {
        private ArrayList<ProductRecorded> itemList = new ArrayList<ProductRecorded>(); // items recorded from transaction.txt file
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

	public Customer(String name, ArrayList<ProductRecorded> items, Payment payment) {
		this.name = name;
		this.itemList = items;
		this.payment = payment;
	}

	public void addItem(ProductRecorded item) {
		itemList.add(item);
	}
	
	public void addPayment(Payment payment) {
		this.payment = payment;
	}

	public ArrayList<ProductRecorded> getAllRecordedItems() {
		return itemList;
	}

	public Payment getPayment() {
		return payment;
	}
        
}
