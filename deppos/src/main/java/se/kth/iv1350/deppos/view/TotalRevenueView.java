package se.kth.iv1350.deppos.view;

import se.kth.iv1350.deppos.model.ConsoleRevenueObserver;

public class TotalRevenueView extends ConsoleRevenueObserver {
    // Is it okay that this view is empty? All methods to make it work is already in the superclasses.
    // The only code that could be in this method is
    // System.out.println("TotalRevenueView shows: " + totalIncome);

    //This has been implemented to specify that it's the TotalRevenueView that 

    @Override
    public void doShowTotalIncome() throws Exception {
        System.out.println("TotalRevenueView shows: " + totalIncome);
    }
}