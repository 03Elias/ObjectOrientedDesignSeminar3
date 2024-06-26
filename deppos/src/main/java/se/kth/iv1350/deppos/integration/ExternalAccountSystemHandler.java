package se.kth.iv1350.deppos.integration;

import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.deppos.model.dto.SaleDTO;
import se.kth.iv1350.deppos.view.RevenueObserver;

public class ExternalAccountSystemHandler {
    private int totalAmountOfMoney;
    private List<RevenueObserver> observers = new ArrayList<>();

    /**
     * A constructor that creates/starts an instance of the External Account System
     * Handler that communicates
     * with the External Account System.
     */
    public ExternalAccountSystemHandler() {
        double totalAmountOfMoney = 0;
    }

    /**
     * updates the external account system after a sale has occured and notifies the observers.
     * 
     * @param saleInfo The sale information that contains the total price, costs,
     *                 etc that is needed to update the account.
     */
    public void updateExternalAccountSystem(SaleDTO saleInfo) {
        double totalRevenueOfLastSale = saleInfo.getTotalPrice() - saleInfo.getTotalDiscount();
        totalAmountOfMoney += totalRevenueOfLastSale;
        notifyObservers(totalRevenueOfLastSale);
    }

    /**
     * Retrives the total amount of money in the account.
     * 
     * @return The total amount of money in the account.
     */
    public double getTotalAmountOfMoney() {
        return totalAmountOfMoney;
    }

    /**
     * Adds an observer to the list of observers.
     * 
     * @param observer The observer to be added.
     */
    public void addObserver(RevenueObserver observer) {
        observers.add(observer);
    }

    /**
     * Removes an observer from the list of observers.
     * 
     * @param observer The observer to be removed.
     */
    public void removeObserver(RevenueObserver observer) {
        observers.remove(observer);
    }

    /**
     * Notifies all observers in the list of observers.
     * 
     * @param observer The observer to be notified.
     */
    private void notifyObservers(double totalRevenueOfLastSale) {
        for (RevenueObserver observer : observers) {
            observer.update(totalRevenueOfLastSale);
        }
    }
}