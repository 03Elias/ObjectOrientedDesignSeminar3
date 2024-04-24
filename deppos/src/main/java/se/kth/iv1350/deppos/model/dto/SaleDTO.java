package se.kth.iv1350.deppos.model.dto;

import java.time.LocalTime;

import se.kth.iv1350.deppos.model.Item;

public class SaleDTO {

    private LocalTime saleTime;
    private double totalPrice;
    private double totalVAT;
    private Item[] items;
    private double totalDiscount;

    /**
     * Constructor that creates a new instance of a SaleDTO (Sale Data Transfer
     * Object) which contains all the necessary information for the sale.
     * 
     * @param totalPrice    The total price of the sale.
     * @param timeOfSale    The time of sale.
     * @param totalVAT      The total VAT.
     * @param items         The total items in the SaleDTO.
     * @param totalDiscount The total discount for this current sale.
     */
    public SaleDTO(double totalPrice, LocalTime saleTime, double totalVAT, Item[] items, double totalDiscount) {
        this.totalPrice = totalPrice;
        this.saleTime = saleTime;
        this.totalVAT = totalVAT;
        this.items = items;
        this.totalDiscount = totalDiscount;
    }

    /**
     * Gets the sale time for the current sale.
     * 
     * @return The time the current sale was taken place is returned.
     */
    public LocalTime getSaleTime() {
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
     * @return The items in the current sale is returned as an item array.
     */
    public Item[] getItems() {
        return items;
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
    public double getTotalVAT() {
        return totalVAT;
    }
}
