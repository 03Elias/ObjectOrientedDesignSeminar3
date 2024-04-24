package se.kth.iv1350.deppos.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.deppos.model.CashRegister;
import se.kth.iv1350.deppos.integration.DiscountHandler;
import se.kth.iv1350.deppos.integration.ExternalAccountSystemHandler;
import se.kth.iv1350.deppos.integration.ExternalInventorySystemHandler;
import se.kth.iv1350.deppos.integration.SalelogHandler;

public class ControllerTest {
    private Controller controller;
    private CashRegister cashregister;
    private ExternalInventorySystemHandler eish;
    private ExternalAccountSystemHandler eash;
    private DiscountHandler dh;
    private SalelogHandler slh;

    @BeforeEach
    public void setup() {
        cashregister = new CashRegister();
        eish = new ExternalInventorySystemHandler();
        eash = new ExternalAccountSystemHandler();
        dh = new DiscountHandler();
        slh = new SalelogHandler();

        controller = new Controller(eish, eash, dh, slh, cashregister);
    }

    @Test
    public void testStartSale() {
        controller.startSale();
    }

    @Test
    public void testEnterItem() {
        //Placeholder test
    }

    @Test
    public void testEndSale() {
        //Placeholder test
    }

    @Test
    public void testAddDiscount() {
        //Placeholder test
    }

    @Test
    public void testAmountPaid() {
        //Placeholder test
    }
}
