package se.kth.iv1350.deppos.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.deppos.integration.exceptions.*;
import se.kth.iv1350.deppos.model.CashRegister;
import se.kth.iv1350.deppos.integration.ExternalAccountSystemHandler;
import se.kth.iv1350.deppos.integration.ExternalInventorySystemHandler;
import se.kth.iv1350.deppos.integration.SalelogHandler;
import se.kth.iv1350.deppos.model.dto.SaleDTO;

public class ControllerTest {
    private Controller controller;
    private CashRegister cashRegister;
    private ExternalInventorySystemHandler eish;
    private ExternalAccountSystemHandler eash;
    private SalelogHandler slh;

    @BeforeEach
    public void setup() {
        cashRegister = CashRegister.getRegister();
        eish = new ExternalInventorySystemHandler();
        eash = new ExternalAccountSystemHandler();
        slh = new SalelogHandler();

        controller = new Controller(eish, eash, slh, cashRegister);
    }

    @Test
    public void testEnterItem() throws ExternalConnectionException, ItemNotFoundException {
        controller.startSale();
        SaleDTO saleInfo = controller.enterItem(0, 1);
        assertEquals(1, saleInfo.getItemMap().size(), "There should be one item in the sale");
        assertEquals(1, saleInfo.getItemQuantityMap().get(0), "The quantity of the item should be 1");
        saleInfo = controller.enterItem(0, 3);
        assertEquals(4, saleInfo.getItemQuantityMap().get(0), "The quantity of the item should be 4");
        saleInfo = controller.enterItem(1, 5);
        assertEquals(2, saleInfo.getItemMap().size(), "There should be two items in the sale");
        assertEquals(5, saleInfo.getItemQuantityMap().get(1), "The quantity of item 2 should be 5");
    }

    @Test
    public void testEndSale() throws ExternalConnectionException, ItemNotFoundException {
        controller.startSale();
        SaleDTO saleInfo = controller.enterItem(0, 1);
        assertNotEquals(0.0, saleInfo.getTotalPrice(), "Double check so we have a running total");
        saleInfo = controller.endSale();
        assertNotEquals(0.0, saleInfo.getTotalPrice(), "EndSale should return total price");
        assertNotEquals(0.0, saleInfo.getTotalVat(), "EndSale should return total VAT");
    }

    @Disabled
    @Test
    public void testApplyDiscount() throws ExternalConnectionException, ItemNotFoundException {
        controller.startSale();
        SaleDTO saleInfo = controller.enterItem(0, 1);
        assertEquals(0.0, saleInfo.getTotalDiscount(), "StartSale should set totalDiscount to 0.0");
        controller.addDiscount(0);
    }

    @Test
    public void testEnterNonExistingItem() {
        try {
            controller.startSale();
            SaleDTO saleInfo = controller.enterItem(-1, 1);
            fail("The test didn't throw an exception");
        }
        catch (ItemNotFoundException e1){
            assertTrue(e1.getMessage().contains("-1"), "The message didn't contain the id -1");
        }
        catch (Exception e2) {
            fail("ItemNotFoundException was not catched in the test");
        }
    }

    
    /**
     * Tests that the program throws an Connection exception.
     * The program simulates a connection exception when an item
     * with ID 3 is added.
     * 
33 //3 Adding aItem 3 an Item with ID 3 will simulate an throw.     * 
     * 
     */
    @Test
    public void externalConnectionExceptionTest() {
        try {
            controller.startSale();
            SaleDTO saleInfo = controller.enterItem(3, 1);
            fail("The test didn't throw an exception");
        }
        catch (ExternalConnectionException e1){
            assertTrue(e1.getMessage().contains("No connection to the external"), "The exception message didn't contain: \"No connection to the external\"");
        }
        catch (Exception e2) {
            fail("ExternalConnectionException was not catched in the test");
        }
    }
}