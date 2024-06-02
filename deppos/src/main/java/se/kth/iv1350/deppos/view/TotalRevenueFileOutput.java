package se.kth.iv1350.deppos.view;

//import se.kth.iv1350.deppos.model.RevenueObserver;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import se.kth.iv1350.deppos.model.ConsoleRevenueObserver;

public class TotalRevenueFileOutput extends ConsoleRevenueObserver{
    private String filename = "revenue.txt";
    
    /**
     * Writes the total amount of money to the file.
     * @param totalAmountOfMoney The total amount of money to be written to the file.
     */
    @Override
    public void update(double totalAmountOfMoney) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, false))) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            writer.printf("[%s] Total Revenue: %.2f%n", timestamp, totalAmountOfMoney);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

  
}
