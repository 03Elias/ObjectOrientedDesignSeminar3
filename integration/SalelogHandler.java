package integration;

import model.Receipt;

public class SalelogHandler {

    private Receipt[] saleList;

    /**
     * The constructor that makes a new instance of SalelogHandler that communicates
     * with the Salelog database.
     */
    public SalelogHandler() {
        this.saleList = new Receipt[0];
    }

    /**
     * Adds to the Salelog database the information of the sale.
     * 
     * @param receipt Contains all the information regarding the sale.
     */

    public void addSale(Receipt receipt) {
        this.saleList[this.saleList.length] = receipt;
    }

    /**
     * Retrives all the previous sales from the Salelog database.
     * 
     * @return All the receipts of the previous pursaches/sales.
     */
    public Receipt[] getSalelog() {
        return this.saleList;
    }

}
