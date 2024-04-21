package integration;

import model.dto.SaleDTO;

public class DiscountHandler {

    /**
     * Starts an new instance of DiscountHandler.
     */
    public DiscountHandler() {

    }

    /**
     * Retrives the discount for the customer of a specific sale by communication
     * with the discount database.
     * 
     * @param customerID The customer identifier so that the right discount is
     *                   fetched.
     * @param saleDTO    The sale information that is needed to determine the right
     *                   discount for the items in the sale.
     * @return
     */
    public double getDiscount(int customerID, SaleDTO saleDTO) {

    }

}
