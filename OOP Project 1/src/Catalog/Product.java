package Catalog;

/**
 * 
 * @author      Jose Ortiz Costa
 * Description: This class represents a product from a catalog
 *              with its properties ( UPC, description and price )
 * Date:        02/09/2016
 * Modified:    02/09/2016
 * USAGE:       
 * 
 */
public class Product {

    private String upc;
    private String desc;
    private double price;
    static final int UPC_STARS = 0;
    static final int UPC_ENDS = 4;
    static final int DESC_STARS = 9;
    static final int DESC_ENDS = 28;
    static final int PRICE_STARS = 34;
    static final int PRICE_ENDS = 41;

    public Product() {

    }

    public Product(String upc, String description, double price) {
        this.upc = upc;
        this.desc = description;
        this.price = price;
    }

    public void setUPC(String upc) {
        this.upc = upc;
    }

    public void setDescription(String description) {
        this.desc = description;
    }

    public void setPrice(double price) {
        this.price = price;
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
    
    /**
      Print description of product
    */
    public String viewProductInfo ()
    {
        return this.upc + "          ";
    }

}
