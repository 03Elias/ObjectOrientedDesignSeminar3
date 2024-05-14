package se.kth.iv1350.deppos.integration.exceptions;

/**
 * Thrown when there is a connection error to the inventory system.
 */
public class ExternalConnectionException extends Exception {

    /**
     * Creates a new instance with the specified error message.
     * 
     * @param message The error message.
     */
    public ExternalConnectionException(String message) {
        super(message);
    }
}