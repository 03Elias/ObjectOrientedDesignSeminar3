package model;

import model.dto.SaleDTO;

public class Cashregister {
    private double cashInRegister;
    private double change;

    /**
     * The method updates the cash in the register after a sale.
     * 
     * @param amountPaid The amount that the customer paid for the sale.
     */
    public void updateCashInRegister(double amountPaid) {

    }

    /**
     * Checks the cash in the register.
     * 
     * @return The cash in the register.
     */
    public double checkCashInRegister() {
        return cashInRegister;

    }

    /**
     * Calculates the change that the customer is given after a sale.
     * 
     * @param amountPaid The amount that the customer paid.
     * @param saleInfo   The sale information specifically the total price.
     * @return The calculated change that the customer is given.
     */
    public double calculatedChange(double amountPaid, SaleDTO saleInfo) {
        return change; // Incorrect

    }

}
