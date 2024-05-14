package se.kth.iv1350.deppos.view;

import se.kth.iv1350.deppos.model.RevenueObserver;

public class TotalRevenueView implements RevenueObserver {
    @Override
    public void update(double totalAmountOfMoney) {
        System.out.println("Total Revenue: " + totalAmountOfMoney);
    }
}