package se.kth.iv1350.deppos.integration;

import java.net.ConnectException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ExceptionHandler {   
    private FileWriter fileWriter;
    private PrintWriter printWriter;
    private String system;

    public ExceptionHandler(String system){
        try {
            fileWriter = new FileWriter("errorLog.txt", true);
            printWriter = new PrintWriter(fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.system = system;
    }
    
    public void handleConnectionError() throws ConnectException {
        //System.out.println("No connection to the external " + this.system + " system.");

        ConnectException connectException = new ConnectException("No connection to the external " + this.system + " system.");
        logException(connectException);

        throw connectException;
    }


    
    public void handleNoSuchElementError() throws NoSuchElementException{
        //System.out.println("No connection to the external " + this.system + " system.");

        NoSuchElementException noSuchElementException = new NoSuchElementException("No such ID");
        logException(noSuchElementException);

        throw noSuchElementException;
    }

    public void handleNullPointerError() throws NullPointerException{
        //System.out.println("No connection to the external " + this.system + " system.");

        NullPointerException nullPointerException = new NullPointerException("ItemInfo can not be null/empty");
        logException(nullPointerException);

        throw nullPointerException;
    }

    private void logException(Exception exception) {
        LocalDateTime timeStamp = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        printWriter.println("[" + formatter.format(timeStamp) + "] " + exception.getMessage());
        exception.printStackTrace(printWriter);
        printWriter.print("\n\n\n");
        printWriter.flush();
    }
}