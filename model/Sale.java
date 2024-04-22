package model;

import java.time.LocalTime;
import model.dto.ItemDTO;
import model.dto.SaleDTO;

public class Sale {
    private LocalTime saleTime;
    private double totalPrice;
    private double totalVAT;
    private double totalDiscount;
    private Item[] items;

    /**
     * Starts a new instance of Sale (a constructor).
     */
    public Sale() {
        this.saleTime = setTimeOfSale();
        this.totalPrice = 0;
        this.totalVAT = 0;
        this.totalDiscount = 0;
        this.items = null;
    }

    /**
     * checks if the item is already in the current sale by using the item
     * identifier.
     * 
     * @param id The item identifier.
     * @return If the item is present in the current sale or not.
     */
    public boolean checkID(int id) {
        for(Item item : items) {
            if(item.itemDTO.getItemID() == id) {
                return true;
            }
    } return false;
}

    /**
     * Adds an item to the current sale.
     * 
     * @param itemInfo information about the item.
     * @return The updated sale with the SaleDTO.
     */

    public SaleDTO addItem(ItemDTO itemInfo, int quantity) {
        this.items[this.items.length] = new Item(itemInfo, quantity);
        return getSaleDTO();
    }

    /**
     * Increases the quantity of an item in for a current sale.
     * 
     * @param id            Is the identifier of the item.
     * @param quantityToAdd The increased quantity that is desired for the item.
     * @return The SaleDTO is returned which contains the sale information of the
     *         current sale.
     */
    public SaleDTO increaseItemQuantity(int id, int quantityToAdd) {
        for(Item item : items) {
            if(item.itemDTO.getItemID() == id) {
                item.increaseQuantity(quantityToAdd);
            }
        }
        return getSaleDTO();
    }

    /**
     * Retrives the SaleDTO (Sale information) of the current sale.
     * 
     * @return The SaleDTO of the current sale.
     */
    public SaleDTO getSaleDTO() {
        return new SaleDTO(this.totalPrice, this.saleTime, this.totalVAT, this.items, this.totalDiscount);
    }

    /**
     * Applies the discount on the current sale based on the discount info.
     * 
     * @param discountAmount Gives the discount information based on the current sale.
     * @return The applicable discount is returned in the SaleDTO which contains the
     *         Sale information.
     */
    public SaleDTO applyDiscount(double discountAmount) {
        this.totalDiscount = discountAmount;
        return getSaleDTO();
    }

    /**
     * Ends the current sale.
     * 
     * @return The finalized SaleDTO containing all the information regarding the
     *         ended sale.
     */
    public SaleDTO endSale() {
        for(Item item : items) {
            this.totalPrice += item.getTotalPrice();
            this.totalVAT += item.itemDTO.getItemPrice() * item.itemDTO.getVAT();
        }
        return getSaleDTO();
    }

    /**
     * Sets the time of sale.
     * 
     * @return The time of sale is returned.
     * */
    private LocalTime setTimeOfSale() {
        return LocalTime.now();
    }
}
