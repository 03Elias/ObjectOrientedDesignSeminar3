package se.kth.iv1350.deppos.model.dto;

import java.time.LocalTime;
import java.util.ArrayList;

import se.kth.iv1350.deppos.model.Item;

public class SaleDTO {

    private LocalTime saleTime;
    private double runningTotal;
    private double totalPrice;
    private double totalVAT;
    private ArrayList<Item> items;
    private double totalDiscount;

    /**
     * Constructor that creates a new instance of a SaleDTO (Sale Data Transfer
     * Object) which contains all the necessary information for the sale.
     * 
     * @param runningTotal  The running total of the sale.
     * @param totalPrice    The total price of the sale.
     * @param timeOfSale    The time of sale.
     * @param totalVAT      The total VAT.
     * @param items         The total items in the SaleDTO.
     * @param totalDiscount The total discount for this current sale.
     */
    public SaleDTO(double runningTotal, double totalPrice, LocalTime saleTime, double totalVAT, ArrayList<Item> items, double totalDiscount) {
        this.runningTotal = runningTotal;
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
     * Gets the running total of the current sale.
     * 
     * @return The running total of the current sale is returned.
     */
    public double getRunningTotal() {
        return runningTotal;
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
    public ArrayList<Item> getItems() {
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
