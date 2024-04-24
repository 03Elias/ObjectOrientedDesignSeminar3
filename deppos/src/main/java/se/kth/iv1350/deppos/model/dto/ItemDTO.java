package se.kth.iv1350.deppos.model.dto;

public class ItemDTO {
    private double itemPrice;
    private double VAT;
    private String itemDescription;
    private int itemID; // Maybe better if string?

    /**
     * A constructor that creates a new instance of the ItemDTO which contains all
     * the information regarding an item.
     * 
     * @param itemPrice       The price of an item.
     * @param VAT             The VAT (Value added tax) of the item.
     * @param itemDescription The description of the item.
     * @param itemID          The identifier of the item.
     */
    public ItemDTO(double itemPrice, double VAT, String itemDescription, int itemID) {
        this.itemPrice = itemPrice;
        this.VAT = VAT;
        this.itemDescription = itemDescription;
        this.itemID = itemID;
    }

    /**
     * Gets the price of the item.
     * 
     * @return The price of the item is returned.
     */
    public double getItemPrice() {
        return itemPrice;

    }

    /**
     * Gets the VAT (Value added tax) of the item.
     * 
     * @return The VAT is returned of the item.
     */
    public double getVAT() {
        return VAT;
    }

    /**
     * Gets the description of the item.
     * 
     * @return The description of the item is returned.
     */
    public String getItemDescription() {
        return itemDescription;
    }

    /**
     * Gets the item ID (identfier).
     * 
     * @return The indetifier of the item is returned.
     */
    public int getItemID() {
        return itemID;
    }
}
