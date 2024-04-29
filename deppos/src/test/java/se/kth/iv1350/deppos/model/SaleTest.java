package se.kth.iv1350.deppos.model;

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
        itemInfo = new ItemDTO(33.0, 0.12, "TestItem", 1);
        mySale = new Sale();
    }

    @Test
    void testAddItem() {
        assertEquals(0, mySale.getSaleDTO().getItems().size());
        SaleDTO saleInfo = mySale.addItem(itemInfo, 1);
        assertEquals(itemInfo, saleInfo.getItems().get(0).getItemDTO());
    }


    @Test
    void testAddDuplicateItem() {
        assertEquals(0, mySale.getSaleDTO().getItems().size());
        SaleDTO saleInfo = mySale.addItem(itemInfo, 1);
        assertEquals(1, saleInfo.getItems().get(0).getQuantity(), "Item quantity should be 1");
        saleInfo = mySale.increaseItemQuantity(1, 1);
        assertEquals(2, saleInfo.getItems().get(0).getQuantity(), "Item quantity should be 2");
    }

    @Test
    void testGetSaleDTO() {
        mySale.addItem(itemInfo, 2);
        SaleDTO saleDTO = mySale.getSaleDTO();
        assertEquals(1, saleDTO.getItems().size(), "Item size should be 1");
        assertEquals(itemInfo, saleDTO.getItems().get(0).getItemDTO(), "Item should be TestItem");
        assertEquals(73.92, saleDTO.getRunningTotal(), "Running total should be 73.92 (33.0 * 2 + 33 * 0.12 * 2)");
        assertEquals(0, saleDTO.getTotalPrice(), "Total price should be 0.0");
        assertEquals(0, saleDTO.getTotalVAT(), "Total VAT should be 0.0");
        assertEquals(0.0, saleDTO.getTotalDiscount(), "Total discount should be 0.0");
        assertNotNull(saleDTO.getSaleTime(), "Sale time should not be null");
    }

    @Test
    void testApplyDiscount() {
        SaleDTO saleDTO = mySale.getSaleDTO();
        assertEquals(0.0, saleDTO.getTotalDiscount(), "The totalDiscount wasn't 0.0");
        mySale.applyDiscount(13.37);
        saleDTO = mySale.getSaleDTO();
        assertEquals(13.37, saleDTO.getTotalDiscount(), "The totalDiscount wasn't 13.37");
    }

    @Test
    void testEndSale() {
        // Placeholder Test
    }

    @Test
    void testCheckID() {
        assertEquals(false, mySale.checkID(1), "Program found ID for item that wasn't added");
        mySale.addItem(itemInfo, 1);
        assertEquals(true, mySale.checkID(1), "Program didn't found ID for item that was added");
    }

    @Test
    void testSetTimeOfSale() {
        // Placeholder Test
    }
}
