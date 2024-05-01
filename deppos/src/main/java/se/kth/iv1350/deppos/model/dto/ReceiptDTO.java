package se.kth.iv1350.deppos.model.dto;

public class ReceiptDTO {
    private SaleDTO saleInfo;
    private double change;
    private double amountPaid;

    /**
     * A constructor that creates a receipt instance that is proof of sale.
     * 
     * @param saleInfo   The information regarding the sale such as items, time of
     *                   sale, etc
     * @param amountPaid The amount that the customer paid.
     * 
     * @param change     The change that the cashier returned to the customer in
     *                   case of overpaying.
     */
    public ReceiptDTO(SaleDTO saleInfo, double amountPaid, double change) {
        this.saleInfo = saleInfo;
        this.amountPaid = amountPaid;
        this.change = change;
    }

    /**
     * Gets the information regarding the sale.
     * 
     * @return The information regarding the sale is returned.
     * 
     * @see se.kth.iv1350.deppos.model.dto.SaleDTO
     */
    public SaleDTO getSaleInfo() {
        return saleInfo;
    }

    /**
     * Gets the amount that the customer paid.
     * 
     * @return The amount that the customer paid is returned.
     * 
     */
    public double getAmountPaid() {
        return amountPaid;
    }

    /**
     * Gets the change that the cashier returned to the customer in case of
     * overpaying.
     * 
     * @return The change is returned.
     * 
     */
    public double getChange() {
        return change;
    }
}