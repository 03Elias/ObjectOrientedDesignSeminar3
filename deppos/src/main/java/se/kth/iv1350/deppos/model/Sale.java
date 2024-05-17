package se.kth.iv1350.deppos.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

import se.kth.iv1350.deppos.integration.exceptions.*;

import se.kth.iv1350.deppos.model.dto.ItemDTO;
import se.kth.iv1350.deppos.model.dto.SaleDTO;

public class Sale {
    private LocalDateTime saleTime;
    private double totalPrice;
    private double totalVat;
    private double totalDiscount;
    private ArrayList<Item> items;

    /**
     * Starts a new instance of Sale (a constructor).
     */
    public Sale() {
        this.saleTime = LocalDateTime.now();
        this.totalPrice = 0.0;
        this.totalVat = 0.0;
        this.totalDiscount = 0.0;
        this.items = new ArrayList<>();

    }

    /**
     * checks if the item is already in the current sale by using the item
     * identifier.
     * 
     * @param id The item identifier.
     * @return If the item is present in the current sale or not.
     */
    public boolean checkId(int id) {
        for (Item item : items) {
            if (item.itemDTO.getItemId() == id) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adds an item to the current sale.
     * 
     * @param itemInfo Information about the item.
     * @param quantity The quantity of the desired item.
     * @return The updated sale with the SaleDTO.
     */

    public SaleDTO addItem(ItemDTO itemInfo, int quantity) throws ItemNotFoundException {
        Item item = new Item(itemInfo, quantity);
        this.items.add(item);
        this.totalPrice += item.getTotalPrice();
        this.totalVat += item.getTotalVat();
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
    public SaleDTO increaseItemQuantity(int id, int quantityToAdd) throws ItemNotFoundException {
        if (!checkId(id)) {
            throw new ItemNotFoundException("Id doesn't exist in the sale");
        }

        Item item = findItemById(id);
        double previousPrice = item.getTotalPrice();
        double previousVat = item.getTotalVat();

        item.increaseQuantity(quantityToAdd);
        this.totalPrice += item.getTotalPrice() - previousPrice;
        this.totalVat += item.getTotalVat() - previousVat;

        return getSaleDTO();
    }

    /**
     * Retrives an item from the current sale based on the item identifier.
     * 
     * @param id The identifier of the item.
     * @return The item is returned.
     * @throws IllegalArgumentException detects and throws an exception if the ID
     *                                  does not exist in the inventory catalog.
     */
    public Item findItemById(int id) throws ItemNotFoundException {
        for (Item item : items) {
            if (item.itemDTO.getItemId() == id) {
                return item;
            }
        }

        ItemNotFoundException IdDoesntExist = new ItemNotFoundException(
                "ID does not exist in the inventory catalog.");
        throw IdDoesntExist;
    }

    /**
     * Retrives the SaleDTO (Sale information) of the current sale.
     * 
     * @return The SaleDTO of the current sale.
     */
    public SaleDTO getSaleDTO() {
        return new SaleDTO(this.totalPrice, this.totalVat, this.saleTime, this.items, this.totalDiscount);
    }

    /**
     * Applies the discount on the current sale based on the discount info.
     * @param ds The discount strategy that is used.
     * @param customerID 
     * 
     * @return The applicable discount is returned in the SaleDTO which contains the
     *         Sale information.
     */
    public SaleDTO applyDiscount(DiscountStrategyInterface ds, int customerID) {
        
        this.totalDiscount = ds.calculateDiscount(getSaleDTO(), customerID);
        return getSaleDTO();
    }
}
