package se.kth.iv1350.deppos.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.deppos.model.CashRegister;
import se.kth.iv1350.deppos.integration.DiscountHandler;
import se.kth.iv1350.deppos.integration.ExternalAccountSystemHandler;
import se.kth.iv1350.deppos.integration.ExternalInventorySystemHandler;
import se.kth.iv1350.deppos.integration.SalelogHandler;
import se.kth.iv1350.deppos.model.dto.SaleDTO;

public class ControllerTest {
    private Controller controller;
    private CashRegister cashRegister;
    private ExternalInventorySystemHandler eish;
    private ExternalAccountSystemHandler eash;
    private DiscountHandler dh;
    private SalelogHandler slh;

    @BeforeEach
    public void setup() {
        cashRegister = new CashRegister();
        eish = new ExternalInventorySystemHandler();
        eash = new ExternalAccountSystemHandler();
        dh = new DiscountHandler();
        slh = new SalelogHandler();

        controller = new Controller(eish, eash, dh, slh, cashRegister);
    }

    @Test
    public void testEnterItem() {
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
    public void testEndSale() {
        controller.startSale();
        SaleDTO saleInfo = controller.enterItem(0, 1);
        assertNotEquals(0.0, saleInfo.getTotalPrice(), "Double check so we have a running total");
        saleInfo = controller.endSale();
        assertNotEquals(0.0, saleInfo.getTotalPrice(), "EndSale should return total price");
        assertNotEquals(0.0, saleInfo.getTotalVat(), "EndSale should return total VAT");
    }

    @Test
    public void testApplyDiscount() {
        controller.startSale();
        SaleDTO saleInfo = controller.enterItem(0, 1);
        assertEquals(0.0, saleInfo.getTotalDiscount(), "StartSale should set totalDiscount to 0.0");
        controller.addDiscount(0);
    }
}
