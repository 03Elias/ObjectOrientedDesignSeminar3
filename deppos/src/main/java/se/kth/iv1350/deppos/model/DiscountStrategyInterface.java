package se.kth.iv1350.deppos.model;

import se.kth.iv1350.deppos.integration.DiscountHandler;
import se.kth.iv1350.deppos.model.dto.SaleDTO;

public interface DiscountStrategyInterface {
    double calculateDiscount(SaleDTO saleDTO, int customerID);
}
