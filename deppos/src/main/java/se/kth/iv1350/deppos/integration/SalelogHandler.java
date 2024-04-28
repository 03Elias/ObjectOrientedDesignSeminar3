package se.kth.iv1350.deppos.integration;

import java.util.ArrayList;

import se.kth.iv1350.deppos.model.dto.ReceiptDTO;

public class SalelogHandler {
    private ArrayList<ReceiptDTO> saleList;

    /**
     * The constructor that makes a new instance of SalelogHandler that communicates
     * with the Salelog database.
     */
    public SalelogHandler() {
        this.saleList = new ArrayList<ReceiptDTO>();
    }

    /**
     * Adds the information of the sale to the Salelog database.
     * 
     * @param receipt Contains all the information regarding the sale.
     */

    public void addSale(ReceiptDTO receipt) {
        this.saleList.add(receipt);
    }

    /**
     * Retrives all the previous sales from the Salelog database.
     * 
     * @return All the receipts of the previous pursaches/sales.
     */
    public ArrayList<ReceiptDTO> getSalelog() {
        return this.saleList;
    }
}