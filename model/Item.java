package model;
import model.dto.ItemDTO;

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
        return this.itemDTO.getItemPrice() * (1 + this.itemDTO.getVAT()) * this.quantity;
    }
}