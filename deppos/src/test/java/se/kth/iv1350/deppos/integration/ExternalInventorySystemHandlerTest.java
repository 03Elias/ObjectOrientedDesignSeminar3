package se.kth.iv1350.deppos.integration;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.deppos.integration.exceptions.ExternalConnectionException;
import se.kth.iv1350.deppos.integration.exceptions.ItemNotFoundException;
import se.kth.iv1350.deppos.model.dto.SaleDTO;

public class ExternalInventorySystemHandlerTest {

    private static SaleDTO saleInfo;
    private static Map<Integer, Integer> itemQuantities;
    private static ExternalInventorySystemHandler eish;

    @BeforeEach
    public void setup() throws ItemNotFoundException {
        saleInfo = MockData.getMockSaleDTO();
        itemQuantities = saleInfo.getItemQuantityMap();
        eish = new ExternalInventorySystemHandler();
    }

    @Test
    public void testUpdateAndGetExternalInventorySystem() throws ExternalConnectionException {
        int quantity = eish.checkInventoryQuantity(0);
        eish.updateExternalInventorySystem(saleInfo);
        int newQuantity = eish.checkInventoryQuantity(0);
        assertEquals(quantity - itemQuantities.get(0), newQuantity);
    }
}