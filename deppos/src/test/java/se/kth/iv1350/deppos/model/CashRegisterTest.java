package se.kth.iv1350.deppos.model;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.deppos.model.dto.SaleDTO;

public class CashRegisterTest {
    private CashRegister cashRegister;
    private SaleDTO saleInfo;

    @BeforeEach
    public void setup() {
        cashRegister = CashRegister.getRegister();
        saleInfo = new SaleDTO(33.0, 3.0, null, null, 5.0);
    }

    @Test
    void testCheckCashInRegister() {
        double cashInRegister = cashRegister.checkCashInRegister();
        assertEquals(0.0, cashInRegister);
        cashRegister.updateCashInRegister(33.0);
        cashInRegister = cashRegister.checkCashInRegister();
        assertEquals(33.0, cashInRegister);
    }

    @Test
    void testUpdateCashInRegister() { 
        assertEquals(0.0, cashRegister.checkCashInRegister());
        cashRegister.updateCashInRegister(33.0);
        assertEquals(33.0, cashRegister.checkCashInRegister());
    }

    @Test
    void testCalculatedChangeOfAnEndedSale() { 
        double amountPaid = 40.0;
        assertEquals(12.0, cashRegister.calculatedChange(amountPaid,saleInfo));
    }
}
