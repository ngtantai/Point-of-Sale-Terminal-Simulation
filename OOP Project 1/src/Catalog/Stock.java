package Catalog;
/**
 * @author: Jose Ortiz Costa
 * Desfription: This class contains methods to work with the catalog of a store
 */
import java.util.ArrayList;
import java.io.*;

public class Stock implements IStock {

    private ArrayList<Product> products; // list of products
    private File catalog = new File("products.txt"); // catalog file
    private String store = null; // store
    /**
     * Constructor: no arguments
     */
    public Stock() {
        this.products = new ArrayList<>();
        loadCatalog();
    }
    /**
     * Contructor
     * @param storeName name of the store
     * @param catalogFileName  catalog file
     */
    public Stock(String storeName, String catalogFileName) {
        this.store = storeName;
        this.catalog = new File(catalogFileName);
        this.products = new ArrayList<>();
        loadCatalog(); // loads catalog and its products in memory
    }
    /**
     * Constructor
     * @param products list of products
     */
    public Stock(ArrayList<Product> products) {

        this.products = products;

    }
    /**
     * Loads catalog of products in memory
     */
    private void loadCatalog() {
        try {
            FileInputStream fis = new FileInputStream(catalog);
            //Construct BufferedReader from InputStreamReader
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line = null;
            while ((line = br.readLine()) != null) {
                Product product = formatProductOutput(line);
                products.add(product);
            }
            br.close();
        } catch (IOException err) {
            System.out.println("Error: " + err.getMessage());
        }

    }
    /**
     * 
     * @return a catalog with all its products
     */
    public ArrayList<Product> getProductsFromStock() {
        return products;
    }
    
    /**
     * Format the string line representing a product from the catalog
     *        and convert it to a Product object
     * @param line string line representing a product in the catalog
     * @return a Product object representing the product in the catalog
     */
    private Product formatProductOutput(String line) {
        Product product = new Product();
        String upc, description;
        double price;
        upc = line.substring(Product.UPC_STARS, Product.UPC_ENDS);
        description = line.substring(Product.DESC_STARS, Product.DESC_ENDS);
        price = Double.parseDouble(line.substring(Product.PRICE_STARS, Product.PRICE_ENDS));
        product.setUPC(upc);
        product.setDescription(description);
        product.setPrice(price);
        return product;

    }
    /**
     * Adds a product to the catalog
     * @param product product object to be added
     * @return true if the product was succesfully added
     *         otherwise, returns false.
     */
    public boolean addProductToStock(Product product) {
        // Add a product to the catalog.
        // Needs to be implemented
        return false;
    }
    
    /**
     * Checks if a given product by upc is in the catalog
     * @param upc product upc
     * @return true if the product is in the catalog. Otherwise, returns false
     */
    public boolean isProductInStock(String upc) {
        if (!products.isEmpty()) {
            for (Product product : products) {
                if (product.getUPC().equals(upc)) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Gets a product given its upc
     * @param upc product upc
     * @return the Product object related to the upc given
     */
    public Product getProduct(String upc) {
        Product product = new Product();
        if (isProductInStock(upc)) {
            for (Product prod : products) {
                if (prod.getUPC().equals(upc)) {
                    product = prod;
                }
            }
        }
        return product;
    }
    /**
     * Prints the whole catalog of products
     */
    public void printCatalog() {
        try {
            FileInputStream fis = new FileInputStream(catalog);
            //Construct BufferedReader from InputStreamReader
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String product = null;
            while ((product = br.readLine()) != null) {
                System.out.println(product);
            }
            br.close();
        } catch (IOException err) {
            System.out.println("Error: " + err.getMessage());
        }
    }

}
