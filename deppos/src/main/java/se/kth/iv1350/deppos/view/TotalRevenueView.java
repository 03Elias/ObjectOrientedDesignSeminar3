package se.kth.iv1350.deppos.view;

import se.kth.iv1350.deppos.model.ConsoleRevenueObserver;

public class TotalRevenueView extends ConsoleRevenueObserver {
  

    
    @Override
    public void doShowTotalIncome() throws Exception {
        System.out.println("TotalRevenueView shows: " + totalIncome);
    }
}