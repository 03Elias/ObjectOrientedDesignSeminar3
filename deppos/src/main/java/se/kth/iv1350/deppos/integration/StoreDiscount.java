package se.kth.iv1350.deppos.integration;

import se.kth.iv1350.deppos.model.DiscountStrategyInterface;
import se.kth.iv1350.deppos.model.dto.SaleDTO;

public class StoreDiscount implements DiscountStrategyInterface {
    private final double storeDiscount = 0.10;

    /**
     * Returnes the total price after discounts based on the store discount.    
     * @param saleDTO The sale information that contains the total price.
     * @param customerID The customer identifier so that the right discount is fetched (here it is not used).
     * @return totalSalePrice * (1.0 - storeDiscount) Is the total price after discounts.
     */
    @Override
    public double calculateDiscount(SaleDTO saleDTO, int customerID) {
        double totalSalePrice = saleDTO.getTotalPrice();
        return totalSalePrice * (1.0 - storeDiscount);
    }
}

