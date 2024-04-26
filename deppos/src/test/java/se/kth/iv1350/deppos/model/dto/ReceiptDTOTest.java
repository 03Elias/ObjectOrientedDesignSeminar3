package se.kth.iv1350.deppos.model.dto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.deppos.model.Item;

import java.time.LocalTime;
import java.util.ArrayList;

public class ReceiptDTOTest {
    private static ReceiptDTO receipt;
    private static LocalTime saleTime = LocalTime.now();
    private static double runningTotal = 33.0;
    private static double totalPrice = 33.0;
    private static double totalVAT = 3.0;
    private static ArrayList<Item> items = new ArrayList<>();
    private static double totalDiscount = 5.0;
    private static SaleDTO saleDTO = new SaleDTO(runningTotal, totalPrice, saleTime, totalVAT, items, totalDiscount);
    private static double amountPaid = 33.0;
    private static double change = 0.0;

    @BeforeAll
    public static void setup() {
        receipt = new ReceiptDTO(saleDTO, amountPaid, change);
    }

    @Test
    void testGetSaleInfoPlaceholder() { 
        SaleDTO saleInfoGiven = receipt.getSaleInfo();
        assertEquals(saleDTO, saleInfoGiven);
    }

    @Test
    void testGetAmountPaidPlaceholder() { 
        double amountPaidGiven = receipt.getAmountPaid();
        assertEquals(amountPaid, amountPaidGiven);
    }

    @Test
    void testGetChangePlaceholder() { 
        double changeGiven = receipt.getChange();
        assertEquals(change, changeGiven);
    }
}
