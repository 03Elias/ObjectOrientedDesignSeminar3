package se.kth.iv1350.deppos.model.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import se.kth.iv1350.deppos.model.Item;

public class SaleDTO {

    private LocalDateTime saleTime;
    private double totalPrice;
    private double totalVat;
    private Map<Integer, ItemDTO> itemMap;
    private Map<Integer, Integer> itemQuantityMap;
    private Map<Integer, Double> itemPriceMap;
    private double totalDiscount;

    /**
     * Constructor that creates a new instance of a SaleDTO (Sale Data Transfer
     * Object) which contains all the necessary information for the sale.
     * 
     * @param totalPrice    The total price at the end of the sale.
     * @param totalVat      The total VAT at the end of the sale.
     * @param timeOfSale    The time of sale.
     * @param items         The total items in the SaleDTO.
     * @param totalDiscount The total discount for this current sale.
     */
    public SaleDTO(double totalPrice, double totalVat, LocalDateTime saleTime, ArrayList<Item> items, double totalDiscount) {
        this.totalPrice = totalPrice;
        this.saleTime = saleTime;
        this.totalVat = totalVat;
        this.totalDiscount = totalDiscount;
        this.itemMap = new HashMap<>();
        this.itemQuantityMap = new HashMap<>();
        this.itemPriceMap = new HashMap<>();

        if(items != null) {
            for(Item item : items) {
                ItemDTO itemDTO = item.getItemDTO();
                itemMap.put(itemDTO.getItemId(), itemDTO);
                itemQuantityMap.put(itemDTO.getItemId(), item.getQuantity());
                itemPriceMap.put(itemDTO.getItemId(), itemDTO.getItemPrice());
            }
        }
    }

    /**
     * Gets the sale time for the current sale.
     * 
     * @return The time the current sale was taken place is returned.
     */
    public LocalDateTime getSaleTime() {
        return saleTime;
    }

    /**
     * Gets the total price of the current sale.
     * 
     * @return The total price of the current sale is returned.
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Gets the items in the current sale.
     * 
     * @return The items in the current sale is returned.
     */
    public Map<Integer, ItemDTO> getItemMap() {
        return itemMap;
    }

    /**
     * Gets the quantities of the items in the current sale.
     * 
     * @return The quantities of the items in the current sale is returned as an
     */
    public Map<Integer, Integer> getItemQuantityMap() {
        return itemQuantityMap;
    }

    /**
     * Gets the prices of the items in the current sale.
     * 
     * @return The prices of the items in the current sale is returned as a Map
     */
    public Map<Integer, Double> getItemPriceMap() {
        return itemPriceMap;
    }

    /**
     * Gets the total discount of the current sale.
     * 
     * @return Gives the total discount of the current sale.
     */
    public double getTotalDiscount() {
        return totalDiscount;
    }

    /**
     * Gets the total value added tax (VAT) of the current sale.
     * 
     * @return Gives the VAT of the current sale.
     */
    public double getTotalVat() {
        return totalVat;
    }
}
