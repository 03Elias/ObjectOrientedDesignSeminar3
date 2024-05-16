package se.kth.iv1350.deppos.integration;

import java.util.HashMap;
import java.util.Map;

import se.kth.iv1350.deppos.model.CustomerDiscount;
import se.kth.iv1350.deppos.model.ItemDiscount;
import se.kth.iv1350.deppos.model.StoreDiscount;
import se.kth.iv1350.deppos.model.dto.ItemDTO;
import se.kth.iv1350.deppos.model.dto.SaleDTO;

public class DiscountHandler { // TO ASK: Should this class also implement the interface?
                               // (that would mean changing getDiscount() to calculateDiscount)
    // Mockdata
    private int discountStrategyNr = 1;
    private double discount = 0.0;

    /**
     * Starts an new instance of DiscountHandler.
     * 
     */
    public DiscountHandler() {

    }

    /**
     * Retrives the discount for the customer of a specific sale by communicating
     * with the discount database.
     * 
     * @param customerID The customer identifier so that the right discount is
     *                   fetched.
     * @param saleDTO    The sale information that is needed to determine the right
     *                   discount for the items in the sale.
     * 
     * @return The discount amount for the sale.
     */
    public double getDiscount(SaleDTO saleDTO, int customerID) {

        if (discountStrategyNr == 1) {
            CustomerDiscount customerDiscount = new CustomerDiscount();
            discount = customerDiscount.calculateDiscount(saleDTO, customerID);
        } else if (discountStrategyNr == 2) {
            ItemDiscount itemDiscount = new ItemDiscount();
            discount = itemDiscount.calculateDiscount(saleDTO, customerID);
        } else {
            StoreDiscount storeDiscount = new StoreDiscount();
            discount = storeDiscount.calculateDiscount(saleDTO, customerID);
        }

        return discount;
    }

}
