package model;

import model.dto.SaleDTO;

public class Cashregister {
    private double cashInRegister;
    private double change;

    /**
     * The method updates the cash in the register after a sale.
     * 
     * @param amountPaid The amount that the customer paid for the sale.
     * @param saleInof   The sale information that is needed for updating the cash
     *                   in the register espacially the total price info.
     */
    public void updateCashInRegister(double amountPaid, SaleDTO saleInfo){
        double totalPrice = saleInfo.getTotalPrice();
        double cashToBePutInToRegister = totalPrice - amountPaid;
        if (cashToBePutInToRegister > 0) {
            cashToBePutInToRegister = 0; // fix more, the tought is if person pay less than
                                         // totalPrice then no cash will be over and person needs to pay the rest.
        } else if (cashToBePutInToRegister <= 0) {
            cashInRegister += cashToBePutInToRegister;
        }
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
     * @param saleInfo   The sale information specifically the total price is the
     *                   desired part.
     * @return The calculated change that the customer is given.
     */
    public double calculatedChange(double amountPaid, SaleDTO saleInfo) {
        double totalPrice = saleInfo.getTotalPrice();
        change = amountPaid - totalPrice;
        if (change > 0) {
            return change;
        } else {
            return 0;
        }
    }
}
