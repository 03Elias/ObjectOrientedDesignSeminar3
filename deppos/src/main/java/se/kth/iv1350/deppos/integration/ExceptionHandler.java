package se.kth.iv1350.deppos.integration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import se.kth.iv1350.deppos.integration.exceptions.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ExceptionHandler {   
    private FileWriter fileWriter;
    private PrintWriter printWriter;
    private String system;

    /**
     * Constructor for ExceptionHandler
     * 
     * @param system the name of the external system
     */
    public ExceptionHandler(String system){
        try {
            fileWriter = new FileWriter("errorLog.txt", true);
            printWriter = new PrintWriter(fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.system = system;
    }
    
    /**
     * Handles an exception that occurs when there is no connection to the external system.
     * 
     * @throws ExternalExternalConnectException
     */
    public void handleConnectionError() throws ExternalConnectionException {
        ExternalConnectionException ExternalConnectException = new ExternalConnectionException("No connection to the external " + this.system + " system.");
        logException(ExternalConnectException);

        throw ExternalConnectException;
    }


    /**
     * Handles an exception that occurs when there is no such ID
     * 
     * @throws ItemNotFoundException
     */
    public void handleNoSuchElementError() throws ItemNotFoundException{
        ItemNotFoundException itemNotFoundException = new ItemNotFoundException("No such ID");
        logException(itemNotFoundException);

        throw itemNotFoundException;
    }

    /**
     * Logs the exception to the errorLog.txt
     * 
     * @param exception the exception
     */
    private void logException(Exception exception) {
        LocalDateTime timeStamp = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        printWriter.println("[" + formatter.format(timeStamp) + "] " + exception.getMessage());
        exception.printStackTrace(printWriter);
        printWriter.print("\n\n\n");
        printWriter.flush();
    }
}