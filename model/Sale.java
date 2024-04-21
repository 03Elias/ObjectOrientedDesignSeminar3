package model;

import java.time.LocalTime;

import model.dto.ItemDTO;
import model.dto.SaleDTO;

public class Sale {

    private LocalTime saleTime;
    private double totalPrice;
    private double totalVAT;
    private item[] items;
    private double totalDiscount;
    private Sale currentSale;

    /**
     * Starts a new instance of Sale (a constructor).
     */
    public Sale() {

    }

    /**
     * checks if the item is already in the current sale by using the item
     * identifier.
     * 
     * @param id The item identifier.
     * @return If the item is present in the current sale or not.
     */
    public boolean checkID(int id) {

    }

    /**
     * Adds an item to the current sale.
     * 
     * @param itemInfo information about the item.
     * @return The updated sale with the SaleDTO.
     */

    public SaleDTO addItem(ItemDTO itemInfo) {

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

    }

    /**
     * Retrives the SaleDTO (Sale information) of the current sale.
     * 
     * @return The SaleDTO of the current sale.
     */
    public SaleDTO getSaleDTO() {

    }

    /**
     * Applies the discount on the current sale based on the discount info.
     * 
     * @param discountInfo Gives the discount information based on the current sale.
     * @return The applicable discount is returned in the SaleDTO which contains the
     *         Sale information.
     */
    public SaleDTO applyDiscount(double discountInfo) {

    }

    /**
     * Adds the payment to the current sale.
     * 
     * @param amountPaid The amount that the customer paid.
     * @return A SaleDTO is returned which contains all sale information regarding
     *         the current sale.
     */

    public SaleDTO addPayment(double amountPaid) {

    }

    /**
     * Ends the current sale.
     * 
     * @return The finalized SaleDTO containing all the information regarding the
     *         ended sale.
     */
    public SaleDTO endSale() {

    }

    private void setTimeOfSale() {

    }

}
