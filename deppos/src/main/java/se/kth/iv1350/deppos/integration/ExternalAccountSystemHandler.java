package se.kth.iv1350.deppos.integration;

import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.deppos.model.RevenueObserver;
import se.kth.iv1350.deppos.model.dto.SaleDTO;

public class ExternalAccountSystemHandler {
    private int totalAmountOfMoney;
    private List<RevenueObserver> observers = new ArrayList<>();

    /**
     * A constructor that creates/starts an instance of the External Account System
     * Handler that communicates
     * with the External Account System.
     */
    public ExternalAccountSystemHandler() {
        totalAmountOfMoney = 0;
    }

    /**
     * updates the external account system after a sale has occured.
     * 
     * @param saleInfo The sale information that contains the total price, costs,
     *                 etc that is needed to update the account.
     */
    public void updateExternalAccountSystem(SaleDTO saleInfo) {
        totalAmountOfMoney += saleInfo.getTotalPrice() - saleInfo.getTotalDiscount();
        notifyObservers();
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
    private void notifyObservers() {
        for (RevenueObserver observer : observers) {
            observer.update(totalAmountOfMoney);
        }
    }
}