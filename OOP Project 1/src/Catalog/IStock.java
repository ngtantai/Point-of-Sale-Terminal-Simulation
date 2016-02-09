package Catalog;

import java.util.ArrayList;

/**
 *
 * @author Jose Ortiz Costa
 * 
 */
public interface IStock {

    // returns list of products in catalog
    public ArrayList<Product> getProductsFromStock(); 
    // returns a product from a catalog
    public Product getProduct(String upc);

}
