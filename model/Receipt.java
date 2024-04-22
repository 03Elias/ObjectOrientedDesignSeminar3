package model;

import model.dto.SaleDTO;

public class Receipt {
    private SaleDTO saleInfo;
    private double change;
    private double amountPaid;

    /**
     * A constructor that creates a receipt instance that is proof of sale.
     * 
     * @param saleInfo   The information regarding the sale such as items, time of
     *                   sale, etc
     * @param amountPaid The amount that the customer paid.
     * @param change     The change that the cashier returned to the customer in
     *                   case of overpaying.
     */

    public Receipt(SaleDTO saleInfo, double amountPaid, double change) {
        this.saleInfo = saleInfo;
        this.amountPaid = amountPaid;
        this.change = change;
    }
}