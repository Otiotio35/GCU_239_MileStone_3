package inventory;

import salable.Salable;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
/**
 * Represents the manager responsible for handling the inventory of products.
 */

public class InventoryManager {
    private Map<String, Salable> products;
    /**
     * Constructor for the InventoryManager class.
     */

    public InventoryManager() {
        this.products = new HashMap<>();
    }

    /**
     * Initializes the product inventory.
     */
    public void initializeInventory() {
       
    }
    /**
     * Adds a product to the inventory.
     * @param product The product to be added.
     */
    public void addProduct(Salable product) {
        products.put(product.getName().toLowerCase(), product);
    }
    /**
     * Removes a specified quantity of a given product from the inventory.
     *
     * @param product  The product to be removed from the inventory.
     * @param quantity The number of units of the specified product to remove.
     */
    public void removeProduct(Salable product, int quantity) {
        products.remove(product.getName().toLowerCase());
    }

    
    /**
     * Returns the complete list of products in the inventory.
     * @return List of products.
     */
    public List<Salable> getInventory() {
        return new ArrayList<>(products.values());
    }
    /**
     * Retrieves a specific product from the inventory by its name.
     * @param name The name of the product.
     * @return The product if found; otherwise null.
     */
    public Salable getProduct(String name) {
        return products.get(name.toLowerCase());
    }
    /**
     * Makes a purchase of a specified quantity of a product.
     * @param name The name of the product.
     * @param quantity The quantity of the product to be purchased.
     * @return true if the purchase was successful; otherwise false.
     */
    public boolean purchaseProduct(String name, int quantity) {
        Salable product = getProduct(name);
        if (product != null && product.getQuantity() >= quantity) {
            product.setQuantity(product.getQuantity() - quantity);
            return true;
        }
        return false;
    }
   
    /**
     * Cancels the purchase of a specified quantity of a product.
     * @param name The name of the product.
     * @param quantity The quantity of the product whose purchase is to be canceled.
     * @return true if the cancellation was successful; otherwise false.
     */
    public boolean cancelPurchase(String name, int quantity) {
        Salable product = getProduct(name);
        if (product != null) {
            product.setQuantity(product.getQuantity() + quantity);
            return true;
        }
        return false;
    }
    /**
     * Displays the current inventory of products.
     */
    public void displayInventory() {
        System.out.println("Current Inventory:");
        System.out.printf("%-15s %-30s %-10s %-8s%n", "Name", "Description", "Price", "Quantity");
        for (Salable product : products.values()) {
            System.out.printf("%-15s %-30s $%-9.2f %-8d%n", product.getName(), product.getDescription(),
                    product.getPrice(), product.getQuantity());
        }
    }
}

