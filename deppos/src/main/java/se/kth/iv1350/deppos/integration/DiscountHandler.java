package se.kth.iv1350.deppos.integration;

import java.util.HashMap;
import java.util.Map;

import se.kth.iv1350.deppos.model.dto.ItemDTO;
import se.kth.iv1350.deppos.model.dto.SaleDTO;

public class DiscountHandler {
    //Mockdata, will eventually be imported from an external source.
    private double currentStoreDiscount;
    private int[] customerIds;
    private double customerDiscount;
    private Map<Integer, Double> itemDiscounts = new HashMap<>();


    /**
     * Starts an new instance of DiscountHandler.
     * 
     */
    public DiscountHandler() {
        currentStoreDiscount = 0.05;
        customerIds = new int[]{1};
        customerDiscount = 0.1;
        itemDiscounts.put(0, 0.1);
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
    public double getDiscount(int customerID, SaleDTO saleDTO) {
        double discount = 0.0;
        double totalSalePrice = saleDTO.getTotalPrice();
    
        // Calculate the total discount for items
        for (ItemDTO itemDTO : saleDTO.getItemMap().values()) {
            int quantity = saleDTO.getItemQuantityMap().get(itemDTO.getItemId());
            discount += getItemDiscount(itemDTO) * quantity;
        }
    
        // Calculate the customer discount
        discount += (totalSalePrice - discount) * (customerDiscount > currentStoreDiscount && isCustomer(customerID) ? customerDiscount : currentStoreDiscount);
    
        return discount;
    }
    

    /**
     * Retrives the discount for an item.
     * 
     * @param itemDTO The DTO of the item that is needed to determine the discount.
     * 
     * @return The discount for the item.
     * 
     */
    private double getItemDiscount(ItemDTO itemDTO) {
        double itemDiscount = 0.0;
    
        if (itemDiscounts.containsKey(itemDTO.getItemId())) {
            double discountRate = itemDiscounts.get(itemDTO.getItemId());
            itemDiscount = itemDTO.getItemPrice() * discountRate;
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
        for(int id : customerIds) {
            if(id == customerID) {
                return true;
            }
        }
        return false;
    }
}
