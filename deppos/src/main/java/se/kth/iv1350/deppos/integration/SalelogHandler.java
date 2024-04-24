package integration;

import model.dto.ReceiptDTO;

public class SalelogHandler {
    private ReceiptDTO[] saleList;

    /**
     * The constructor that makes a new instance of SalelogHandler that communicates
     * with the Salelog database.
     */
    public SalelogHandler() {
        this.saleList = new ReceiptDTO[0];
    }

    /**
     * Adds the information of the sale to the Salelog database.
     * 
     * @param receipt Contains all the information regarding the sale.
     */

    public void addSale(ReceiptDTO receipt) {
        this.saleList[this.saleList.length] = receipt;
    }

    /**
     * Retrives all the previous sales from the Salelog database.
     * 
     * @return All the receipts of the previous pursaches/sales.
     */
    public ReceiptDTO[] getSalelog() {
        return this.saleList;
    }
}