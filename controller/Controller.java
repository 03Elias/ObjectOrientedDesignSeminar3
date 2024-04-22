package controller;

import integration.DiscountHandler;
import integration.ExternalAccountSystemHandler;
import integration.ExternalInventorySystemHandler;
import integration.SalelogHandler;
import model.Cashregister;
import model.Sale;
import model.Receipt;
import model.dto.ItemDTO;
import model.dto.SaleDTO;

public class Controller {

    private Sale sale;
    private Cashregister cashregister;
    private ExternalInventorySystemHandler eish;
    private ExternalAccountSystemHandler eash;
    private DiscountHandler dh;
    private SalelogHandler slh;

    /**
     * Constructor for Controller, so creates instance of Controller so it is able
     * to communicate with them later on.
     * 
     * @param eish is an instance of the object ExternalInventorySystemHandler.
     * @param eash is an instance of the object ExternalAccountSystemHandler.
     * @param dh   is an instance of the object DiscountHandler.
     * @param slh  is an instance of the object SalelogHandler.
     */

    public Controller(ExternalInventorySystemHandler eish, ExternalAccountSystemHandler eash, DiscountHandler dh,
            SalelogHandler slh, Cashregister cashregister) {
        
        this.cashregister = cashregister;
        this.eish = eish;
        this.eash = eash;
        this.dh = dh;
        this.slh = slh;
    }

    /**
     * Starts a new sale.
     */
    public void startSale() {
        sale = new Sale();
    }

    /**
     * When an item is scanned/entered.
     * 
     * @param id       The id is the identifier if the entered item that will be
     *                 added into the sale.
     * @param quantity The amount of this said item that will be added into the
     *                 sale.
     * @return A SaleDTO object containing the updated sale information, which
     *         includes the details of the entered item
     *         and the updated total amount of the sale, etc.
     */
    public SaleDTO enterItem(int id, int quantity) {
        if(sale.checkID(id)) {
            sale.increaseItemQuantity(id, quantity);
        }
        else {
            ItemDTO itemInfo = eish.getItemInfo(id);
            sale.addItem(itemInfo, quantity);
        }
        return sale.getSaleDTO();
    }

    /**
     * Ends the current sale after all the desired items have been entered into the
     * sale.
     * 
     * @return A SaleDTO containing all information regarding the ended sale.
     */
    public SaleDTO endSale() {
        return sale.endSale();
    }

    /**
     * Adds a discount to the current sale depending on the customer.
     * 
     * @param customerID The identifier for the customer to be able to see if having
     *                   right to discount.
     * @return A SaleDTO which contains all the information of the current sale
     *         including the added discount.
     */
    public SaleDTO addDiscount(int customerID) {
        SaleDTO saleInfo = sale.getSaleDTO();
        double discountAmount = dh.getDiscount(customerID, saleInfo);

        return sale.applyDiscount(discountAmount);
    }

    /**
     * Showcases the amount paid from the customer. Updates the external systems as well as the register.
     * Also adds a sale to the salelog.
     * 
     * @param amountPaid The amount that the customer paid.
     * @return A updated SaleDTO containing the amoun paid among other sale
     *         information regarding the pursache.
     */
    public SaleDTO amountPaid(double amountPaid) {
        SaleDTO saleInfo = sale.getSaleDTO();

        eash.updateExternalAccountSystem(saleInfo);
        eish.updateExternalInventorySystem(saleInfo);

        double change = this.cashregister.calculatedChange(amountPaid, saleInfo);
        this.cashregister.updateCashInRegister(amountPaid, saleInfo);

        slh.addSale(new Receipt(saleInfo, amountPaid, change));

        return sale.getSaleDTO();
    }
}