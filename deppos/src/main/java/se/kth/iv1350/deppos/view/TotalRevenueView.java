package se.kth.iv1350.deppos.view;

import se.kth.iv1350.deppos.view.RevenueObserver;

public class TotalRevenueView extends RevenueObserver {

    /**
     * Prints the total amount of money earned since the program started.
     * 
     * @throws Exception If an error occurs.
     */
    @Override
    protected void doShowTotalIncome() throws Exception {
        System.out.println("TotalRevenueView shows: " + totalIncome);
    }

    /**
     * Handles any errors that might occur.
     * 
     * @param e The exception that occurred.
     */
    @Override
    protected void handleErrors(Exception e) {
        System.err.println("An error has occurred: " + e.getMessage());
    }
}
