package se.kth.iv1350.deppos.model;
import se.kth.iv1350.deppos.model.dto.ItemDTO;

public class Item {
    ItemDTO itemDTO;
    private int quantity;

    /**
     * Constructor for Item so it creates an Item when the cashier enters the item
     * identifier/scanned.
     * 
     * @param itemDTO  Provides the information about the item such as item
     *                 description, price, etc.
     * @param quantity Provides the quantity of the Item needed for the sale.
     */

    public Item(ItemDTO itemDTO, int quantity) {
        this.itemDTO = itemDTO;
        this.quantity = quantity;
    }

    /**
     * Gets the information about the item.
     * 
     * @return The information about the item is returned.
     * 
     * @see se.kth.iv1350.deppos.model.dto.ItemDTO
     */
    public ItemDTO getItemDTO() {
        return itemDTO;
    }

    /**
     * Gets the quantity of the item.
     * 
     * @return The quantity of the item is returned.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Increases the quantity of a certain Item if already bought/scanned.
     * 
     * @param quantity The quantity of the item in the current sale.
     * @return The item is returned with the correct quantity of it in the sale.
     */
    public Item increaseQuantity(int quantity) {
        this.quantity += quantity;
        return this;
    }

    /**
     * Gets the total price of the item.
     * 
     * @return The total price is returned.
     */
    public double getTotalPrice() {
        double itemPrice = this.itemDTO.getItemPrice();
        return itemPrice * this.quantity;
    }

    /**
     * Gets the total VAT of the item.
     * 
     * @return The total VAT is returned.
     * 
     */
    public double getTotalVat() {
        double itemPrice = this.itemDTO.getItemPrice();
        double itemVat = this.itemDTO.getItemVat();
        return (itemPrice * quantity) - (itemPrice / (1 + itemVat)) * quantity;
    }
}