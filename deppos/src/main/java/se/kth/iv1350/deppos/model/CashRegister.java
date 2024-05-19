package se.kth.iv1350.deppos.model;

import se.kth.iv1350.deppos.model.dto.SaleDTO;

public class CashRegister {
    private double cashInRegister;
    private static CashRegister register; 

   
    private CashRegister() {
        cashInRegister = 0;
    }

    /**
     * The method returns the cash register.
     * 
     * @return The cash register.
     */
    public static CashRegister getRegister() {
        if(register == null) {
            register = new CashRegister();
        }
        return new CashRegister();
    }

    /**
     * The method updates the cash in the register after a sale.
     * 
     * @param amountPaid The amount that the customer paid for the sale.
     */
    public void updateCashInRegister(double amountPaid){
        cashInRegister += amountPaid;
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
        double totalPrice = getSalePrice(saleInfo);
        double change = amountPaid - totalPrice;

        if (change > 0) {
            return change;
        } else {
            return 0;
        }
    }

    /**
     * Calculates the total price of the sale.
     * 
     * @param saleInfo The sale information that contains the total price and the discount.
     * 
     * @return The total price of the sale.
     * */
    private double getSalePrice(SaleDTO saleInfo) {
        return saleInfo.getTotalPrice() - saleInfo.getTotalDiscount();
    }
}
