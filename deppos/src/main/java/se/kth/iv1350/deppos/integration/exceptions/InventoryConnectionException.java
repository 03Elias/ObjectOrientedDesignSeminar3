package se.kth.iv1350.deppos.integration.exceptions;

/**
 * Thrown when there is a connection error to the inventory system.
 */
public class InventoryConnectionException extends Exception {
    /**
     * Creates a new instance with the specified error message.
     * 
     * @param message The error message.
     */
    public InventoryConnectionException(String message) {
        super(message);
    }

    /**
     * Creates a new instance with the specified error message and cause.
     * 
     * @param message The error message.
     * @param cause The cause of the exception.
     */
    public InventoryConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
