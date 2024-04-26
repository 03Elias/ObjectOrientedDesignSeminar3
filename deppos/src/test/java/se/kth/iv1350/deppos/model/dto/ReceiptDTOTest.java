package se.kth.iv1350.deppos.model.dto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.deppos.model.Item;

import java.time.LocalTime;
import java.util.ArrayList;

public class ReceiptDTOTest {
    private static ReceiptDTO receipt;
    private static LocalTime saleTime;
    private static double runningTotal;
    private static double totalPrice;
    private static double totalVAT;
    private static ArrayList<Item> items;
    private static double totalDiscount;
    private static SaleDTO saleDTO;
    private static double amountPaid;
    private static double change;

    @BeforeAll
    public static void setup() {
        saleTime = LocalTime.now();
        runningTotal = 33.0;
        totalPrice = 33.0;
        totalVAT = 3.0;
        items = new ArrayList<>();
        totalDiscount = 5.0;
        amountPaid = 33.0;
        change = 0.0;
        saleDTO = new SaleDTO(runningTotal, totalPrice, saleTime, totalVAT, items, totalDiscount);
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
