package se.kth.iv1350.deppos.model;

public class ConsoleRevenueObserver extends RevenueObserver {
    protected double totalIncome = 0;


    /**
     * Adds the price of the sale to the total income.
     * 
     * @param priceOfTheSaleThatWasJustMade The price of the sale that was just made.
     */
    @Override
    protected void calculateTotalIncome(double priceOfTheSaleThatWasJustMade) {
        totalIncome += priceOfTheSaleThatWasJustMade;
    }

    /**
     * Prints the total amount of money earned since the program started.
     * 
     * @throws Exception If an error occurs.
     */
    @Override
    protected void doShowTotalIncome() throws Exception {
        System.out.println("New total income: " + totalIncome);
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
