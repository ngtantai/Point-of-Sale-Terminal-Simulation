package oop.project.pkg1.transaction;

import java.math.BigDecimal;

/**
 * Record an Item UPC and quantity for that Item.
 *
 */
public class ProductRecorded {

	private String UPC;
	private int quantity;

	public ProductRecorded(String UPC, int quantity) {
            this.UPC = UPC;
            this.quantity = quantity;
	}      

	public String getUPC() {
            return UPC;
	}

	public int getQuantity() {
            return quantity;
	}

	public void setUPC(String uPC) {
            UPC = uPC;
	}

	public void setQuantity(int quantity) {
            this.quantity = quantity;
	}
        
}
