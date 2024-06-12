package se.kth.iv1350.deppos.view;

public abstract class RevenueObserver {
    protected double totalIncome = 0.0;

    /**
     * Adds the price of the sale to the total income.
     * @param priceOfTheSaleThatWasJustMade The price of the sale that was just made.
     */
    public void update(double priceOfTheSaleThatWasJustMade) {
        calculateTotalIncome(priceOfTheSaleThatWasJustMade); 
        showTotalIncome();
    }

    //protected abstract void calculateTotalIncome(double priceOfTheSaleThatWasJustMade);

    /**
     * Prints the total amount of money earned since the program started.
     */
    private void showTotalIncome() {
        try {
            doShowTotalIncome();
        } catch (Exception e) {
            handleErrors(e);
        }
    }

    protected abstract void doShowTotalIncome() throws Exception;

    protected abstract void handleErrors(Exception e);

    private void calculateTotalIncome(double priceOfTheSaleThatWasJustMade) {
        totalIncome += priceOfTheSaleThatWasJustMade;
    }
}