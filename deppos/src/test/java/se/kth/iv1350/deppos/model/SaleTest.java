package se.kth.iv1350.deppos.model;

import se.kth.iv1350.deppos.integration.MockData;
import se.kth.iv1350.deppos.model.dto.ItemDTO;
import se.kth.iv1350.deppos.model.dto.SaleDTO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SaleTest {
    private ItemDTO itemInfo;
    private static Sale mySale;
    
    @BeforeEach
    public void setup() {
        itemInfo = MockData.getMockItemDTOs()[0];
        mySale = new Sale();
    }

    @Test
    void testAddItem() {
        assertEquals(0, mySale.getSaleDTO().getItemMap().size());
        SaleDTO saleInfo = mySale.addItem(itemInfo, 1);
        assertEquals(itemInfo, saleInfo.getItemMap().get(itemInfo.getItemId()));
    }


    @Test
    void testAddDuplicateItem() {
        assertEquals(0, mySale.getSaleDTO().getItemMap().size());
        SaleDTO saleInfo = mySale.addItem(itemInfo, 1);
        assertEquals(1, saleInfo.getItemQuantityMap().get(0), "Item quantity should be 1");
        saleInfo = mySale.increaseItemQuantity(0, 1);
        assertEquals(2, saleInfo.getItemQuantityMap().get(0), "Item quantity should be 2");
    }

    @Test
    void testGetSaleDTO() {
        mySale.addItem(itemInfo, 2);
        double priceOfItems = itemInfo.getItemPrice() * 2;
        SaleDTO saleDTO = mySale.getSaleDTO();
        assertEquals(1, saleDTO.getItemMap().values().size(), "Item size should be 1");
        assertEquals(itemInfo, saleDTO.getItemMap().get(itemInfo.getItemId()), "Item should be TestItem");
        assertEquals(priceOfItems, saleDTO.getTotalPrice(), "Running total should be " + priceOfItems);
        assertEquals(75.9, saleDTO.getTotalPrice(), "Total price should be 75.9");
        assertEquals(8.132142857142867, saleDTO.getTotalVat(), "Total VAT should be 8.132142857142867");
        assertEquals(0.0, saleDTO.getTotalDiscount(), "Total discount should be 0.0");
        assertNotNull(saleDTO.getSaleTime(), "Sale time should not be null");
    }

    @Test
    void testApplyDiscount() {
        // Placeholder Test
    }

    @Test
    void testEndSale() {
        // Placeholder Test
    }

    @Test
    void testCheckId() {
        // assertEquals(false, mySale.)
        // mySale.addItem(itemInfo, 1);
    }

    @Test
    void testSetTimeOfSale() {
        // Placeholder Test
    }
}
