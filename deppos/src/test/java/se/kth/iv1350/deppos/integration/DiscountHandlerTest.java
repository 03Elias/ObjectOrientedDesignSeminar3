package se.kth.iv1350.deppos.integration;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.deppos.integration.exceptions.ItemNotFoundException;
import se.kth.iv1350.deppos.model.dto.SaleDTO;

public class DiscountHandlerTest {
    private DiscountHandler dh;
    private static SaleDTO saleInfo;
    private static int customerID;
    private static double totalPrice;
    private static Map<Integer, Double> itemPrices;
    private static Map<Integer, Integer> itemQuantities;
    private static double totalDiscount;

    @BeforeEach
    public void setup() throws ItemNotFoundException {
        saleInfo = MockData.getMockSaleDTO();
        itemPrices = saleInfo.getItemPriceMap();
        itemQuantities = saleInfo.getItemQuantityMap();
        totalPrice = saleInfo.getTotalPrice();
        customerID = 1;
    }

    @Test
    public void testGetDiscount() {
        dh = new DiscountHandler();
        totalDiscount = totalPrice * 0.1;
        double discount = dh.getDiscount(saleInfo, customerID);
        assertEquals(totalDiscount, discount);
    }
}