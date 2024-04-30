package se.kth.iv1350.deppos.integration;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.deppos.model.dto.ReceiptDTO;
import se.kth.iv1350.deppos.model.dto.SaleDTO;

public class SalelogHandlerTest {
    private SalelogHandler slh;
    private ReceiptDTO receiptDTO;
    private SaleDTO saleDTO;

    @BeforeEach
    public void setup() {
        slh = new SalelogHandler();
        saleDTO = new SaleDTO(33.0, 3.0, LocalDateTime.now(), null, 5.0);
        receiptDTO = new ReceiptDTO(saleDTO, 40.0, 7.0);
    }

    @Test
    public void testAddAndFetchLog() {
        assertEquals(0, slh.getSalelog().size());
        slh.addSale(receiptDTO);
        assertEquals(receiptDTO, slh.getSalelog().get(0));
        assertEquals(1, slh.getSalelog().size());
        slh.addSale(receiptDTO);
        assertEquals(receiptDTO, slh.getSalelog().get(1));
        assertEquals(2, slh.getSalelog().size());
    }
}
