package Catalog;

import java.text.DecimalFormat;

/**
 *
 * @author Jose Ortiz Costa
 * @Description: This class represents a product from a catalog with its
 * properties ( UPC, description and price ) 
 * @Date: 02/09/2016 Date: 02/09/2016
 * @Modified: 02/09/2016 
 * @USAGE: Product product = new Product ("0001", "product
 * description", 1234.89); or Product product = new Product (); and set all the
 * properties with the setters.
 *
 */
public class Product implements Comparable<Product> {

    // private instance variables
    private String upc;
    private String desc;
    private double price;
    private int quantity;
    private DecimalFormat formatter;
    private StringBuilder productBuilder;
    // static variables
    static final int UPC_STARS = 0;
    static final int UPC_ENDS = 4;
    static final int DESC_STARS = 9;
    static final int DESC_ENDS = 28;
    static final int PRICE_STARS = 34;
    static final int PRICE_ENDS = 41;

    /**
     * Constructor
     */
    public Product() {

    }

    /**
     * Constructor
     *
     * @param upc
     * @param description
     * @param price
     */
    public Product(String upc, String description, double price) {
        this.upc = upc;
        this.desc = description;
        this.price = price;
        formatter = new DecimalFormat("#0000.00");
    }

    /**
     * Constructor
     *
     * @param upc
     * @param quantity
     */
    public Product(String upc, int quantity) {
        this.upc = upc;
        this.quantity = quantity;
        formatter = new DecimalFormat("#0000.00");
    }
    
    

    //setters
    public void setUPC(String upc) {
        this.upc = upc;
    }

    public void setDescription(String description) {
        this.desc = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUPC() {
        return this.upc;
    }

    public String getDescription() {
        return this.desc;
    }

  
    public double getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    /**
     * Initialize a StringBuilder of size 45 to allocate products attributes
     */
    private void initProductBuilder() {
        this.productBuilder = new StringBuilder();
        int i = 0;
        for (i = 0; i < 45; i++) {
            productBuilder.append(" ");
        }
    }

    /**
     * Gets the productbuilder ready to format a product
     *
     * @return a StringBuilder object representing the product builder
     */
    public StringBuilder getProductBuilder() {
        this.initProductBuilder();
        return this.productBuilder;
    }

    /**
     * Prepare a product attribute to be formatted for adding to txt file
     *
     * @param productAttribute
     * @param startIndex
     * @param endIndex
     */
    private void stringBuilderAttribute(String productAttribute, int startIndex, int endIndex) {

        this.productBuilder.replace(startIndex, endIndex, productAttribute);
    }

    /**
     * Format a product, so it can be added to the txt file.
     *
     * @param product Product Object
     */
    public void stringBuilderProduct(boolean outputMode) {

        if (!outputMode) {
            stringBuilderAttribute(this.getUPC(), Product.UPC_STARS, Product.UPC_ENDS);
            stringBuilderAttribute(this.getDescription(), Product.DESC_STARS, Product.DESC_ENDS);
            stringBuilderAttribute(formatter.format(this.getPrice()), Product.PRICE_STARS, Product.PRICE_ENDS);
        } else {
            int descriptionStarts = 0,
                    descriptionEnds = Product.DESC_ENDS - Product.DESC_STARS,
                    priceStarts = descriptionStarts + descriptionEnds + 1,
                    priceEnds = priceStarts + (Product.PRICE_ENDS - Product.PRICE_STARS),
                    upcStarts = priceEnds + 1,
                    upcEnds = productBuilder.capacity() - 1;

            stringBuilderAttribute(this.getDescription(), descriptionStarts, descriptionEnds);
            stringBuilderAttribute(String.valueOf(this.getPrice()), priceStarts, priceEnds);
            stringBuilderAttribute(this.getUPC(), upcStarts, upcEnds);
        }

    }

    /**
     * Compares to Products by description
     *
     * @param compareProduct Product object to be compared
     * @return the object which lexically is smaller.
     */
    @Override
    public int compareTo(Product compareProduct) {
        return this.getDescription().compareTo(compareProduct.getDescription());
    }

    /**
     *
     * @return a String representing a product string ready to be outputted from
     * the transaction file
     */
    public String productReaderToString() {
        this.initProductBuilder();
        this.stringBuilderProduct(true);
        return productBuilder.toString();
    }

    /**
     *
     * @return a product string ready to be written in the transaction file
     */
    public String productWritterToString() {
        this.initProductBuilder();
        this.stringBuilderProduct(false);
        return productBuilder.toString();
    }

}
