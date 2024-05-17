package se.kth.iv1350.deppos.integration;

import se.kth.iv1350.deppos.model.DiscountStrategyInterface;
import se.kth.iv1350.deppos.model.dto.SaleDTO;

public class CustomerDiscount implements DiscountStrategyInterface {
    private final int[] customerIds = new int[]{1};
    private final double customerDiscount= 0.10;
     /**
     * Returnes the total price after discounts based on the store discount.    
     * @param saleDTO The sale information that contains the total price.
     * @param customerID The customer identifier so that the right discount is fetched.
     * @return totalSalePrice * (1.0 - storeDiscount) Is the total price after discounts.
     */
    @Override
    public double calculateDiscount(SaleDTO saleDTO, int customerID) {
        if (isCustomer(customerID)) {
            double totalSalePrice = saleDTO.getTotalPrice();
            return totalSalePrice * customerDiscount;
        }
        
        return 0.0;
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


