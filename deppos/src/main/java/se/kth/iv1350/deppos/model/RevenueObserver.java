package se.kth.iv1350.deppos.model;

public abstract class RevenueObserver {
    // This is the method defined in the observer interface.
    public void update(double priceOfTheSaleThatWasJustMade) {
        calculateTotalIncome(priceOfTheSaleThatWasJustMade); // Calculate the total amount paid since the program
                                                             // started.
        showTotalIncome();
    }

    protected abstract void calculateTotalIncome(double priceOfTheSaleThatWasJustMade);

    private void showTotalIncome() {
        try {
            doShowTotalIncome();
        } catch (Exception e) {
            handleErrors(e);
        }
    }

    protected abstract void doShowTotalIncome() throws Exception;

    protected abstract void handleErrors(Exception e);
}