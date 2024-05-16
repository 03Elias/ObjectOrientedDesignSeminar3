package se.kth.iv1350.deppos.model;

import java.util.HashMap;
import java.util.Map;

import se.kth.iv1350.deppos.integration.DiscountHandler;
import se.kth.iv1350.deppos.model.dto.ItemDTO;
import se.kth.iv1350.deppos.model.dto.SaleDTO;

public class ItemDiscount implements DiscountStrategyInterface {
    private Map<Integer, Double> itemDiscounts = new HashMap<>();
    double itemDiscount = 0.05;

   

    @Override
    public double calculateDiscount(SaleDTO saleDTO,  int customerID) {
        double discount = 0.0;
        for (ItemDTO itemDTO : saleDTO.getItemMap().values()) {
            int quantity = saleDTO.getItemQuantityMap().get(itemDTO.getItemId());
            discount += getItemDiscount(itemDTO) * quantity;
        }
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
       
        if (itemDiscounts.containsKey(itemDTO.getItemId())) {
            double discountRate = itemDiscounts.get(itemDTO.getItemId());
            itemDiscount = itemDTO.getItemPrice() * discountRate;
        }

        return itemDiscount;
    }
}
