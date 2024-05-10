package se.kth.iv1350.deppos.model.dto;

public class ItemDTO {
    private String itemName;
    private double itemPrice;
    private double itemVat;
    private String itemDescription;
    private int itemID;

    /**
     * A constructor that creates a new instance of the ItemDTO which contains all
     * the information regarding an item.
     * 
     * @param itemName        The name of the item.
     * @param itemPrice       The price of an item.
     * @param vat             The VAT (Value added tax) of the item.
     * @param itemDescription The description of the item.
     * @param itemID          The identifier of the item.
     */
    public ItemDTO(String itemName, double itemPrice, double vat, String itemDescription, int itemID) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemVat = vat;
        this.itemDescription = itemDescription;
        this.itemID = itemID;
    }

    /**
     * Gets the name of the item.
     * 
     * @return The name of the item is returned.
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Gets the price of the item.
     * 
     * @return The price of the item is returned.
     */
    public double getItemPrice(){
        return itemPrice;

    }

    /**
     * Gets the VAT (Value added tax) of the item.
     * 
     * @return The VAT is returned of the item.
     */
    public double getItemVat() {
        return itemVat;
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
    public int getItemId() {
        return itemID;
    }
}
