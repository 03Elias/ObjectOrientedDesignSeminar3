package se.kth.iv1350.deppos.integration;

import se.kth.iv1350.deppos.model.Item;
import se.kth.iv1350.deppos.model.dto.SaleDTO;

public class DiscountHandler {
    //Mockdata, will eventually be imported from an external source.
    private double currentStoreDiscount = 0.05;;
    private int[] customerIDs = new int[]{1};
    private double customerDiscount = 0.1;
    private double[][] itemDiscounts = new double[][]{{0,0.1}};

    /**
     * Starts an new instance of DiscountHandler.
     * 
     */
    public DiscountHandler() {
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
        double discount = 0.0;
        double totalSalePrice = saleDTO.getTotalPrice();
    
        // Calculate the total discount for items
        for (Item item : saleDTO.getItems()) {
            discount += getItemDiscount(item);
        }
    
        // Calculate the customer discount
        discount += (totalSalePrice - discount) * (customerDiscount > currentStoreDiscount && isCustomer(customerID) ? customerDiscount : currentStoreDiscount);
    
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
    private boolean isCustomer(int customerID) {
        for(int id : customerIDs) {
            if(id == customerID) {
                return true;
            }
        }
        return false;
    }
}
