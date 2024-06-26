package se.kth.iv1350.deppos.integration.exceptions;

/**
 * Thrown when an item is not found in the inventory catalog.
 */
public class ItemNotFoundException extends Exception {
    /**
     * Creates a new instance with the specified error message.
     * 
     * @param message The error message.
     */
    public ItemNotFoundException(String message) {
        super(message);
    }
}
