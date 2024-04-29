package se.kth.iv1350.deppos.integration;

import se.kth.iv1350.deppos.model.Item;
import se.kth.iv1350.deppos.model.dto.SaleDTO;

public class DiscountHandler {
    private double currentStoreDiscount;
    private int[] vipCustomerIDs;
    private double vipDiscount;
    private double[][] itemDiscounts;
    private double discount;

    /**
     * Starts an new instance of DiscountHandler.
     * 
     */
    public DiscountHandler() {
        //Mockdata, will eventually be imported from an external source.
        this.currentStoreDiscount = 0.05;
        this.vipCustomerIDs = new int[]{1};
        this.vipDiscount = 0.1;
        this.itemDiscounts = new double[][]{{0,0.1}};
    }

    /**
     * Retrives the discount for the customer of a specific sale by communication
     * with the discount database.
     * 
     * @param customerID The customer identifier so that the right discount is
     *                   fetched.
     * @param saleDTO    The sale information that is needed to determine the right
     *                   discount for the items in the sale.
     * 
     * @return The discount amount for the sale.
     */
    public double getDiscount(int customerID, SaleDTO saleDTO) {
        double totalSalePrice = saleDTO.getTotalPrice();

        //Checks each item for a discount.
        for(Item item : saleDTO.getItems()) {
            discount += getItemDiscount(item);
        }

        //If the customer is a vip and the vip discount is larger than the current store discount, use the vip discount.
        discount += (totalSalePrice - discount) * (vipDiscount > currentStoreDiscount && isVipCustomer(customerID) ? vipDiscount : currentStoreDiscount);

        return discount;
    }

    /**
     * Retrives the discount for an item.
     * 
     * @param itemID
     * @param quantity
     * 
     * @return The discount for the item.
     * 
     */
    private double getItemDiscount(Item item) {
        double itemDiscount = 0.0;

        for(int i = 0; i < itemDiscounts.length; i++) {
            if(item.getItemDTO().getItemID() == itemDiscounts[i][0]) {
                itemDiscount = item.getTotalPrice() * itemDiscounts[i][1];
            }
        }

        return itemDiscount;
    }

    /**
     * Checks if a customer is a vipCustomer.
     * 
     * @param customerID
     * 
     * @return If the customer is a vipCustomer or not.
     */
    private boolean isVipCustomer(int customerID) {
        for(int id : vipCustomerIDs) {
            if(id == customerID) {
                return true;
            }
        }
        return false;
    }
}
