package se.kth.iv1350.deppos.view;

import se.kth.iv1350.deppos.view.RevenueObserver;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TotalRevenueFileOutput extends RevenueObserver {
    private String filename = "revenue.txt";

    /**
     * Writes the total amount of money to the file.
     */
    @Override
    public void doShowTotalIncome() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            writer.printf("[%s] Total Revenue: %.2f%n", timestamp, totalIncome);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     /**
     * Handles any errors that might occur.
     * 
     * @param e The exception that occurred.
     */
    @Override
    protected void handleErrors(Exception e) {
        System.err.println("An error has occurred in FileOutput: " + e.getMessage());
    }
}
