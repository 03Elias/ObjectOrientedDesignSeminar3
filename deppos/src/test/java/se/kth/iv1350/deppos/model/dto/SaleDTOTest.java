package se.kth.iv1350.deppos.model.dto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import se.kth.iv1350.deppos.model.Item;

public class SaleDTOTest {
    private static SaleDTO sale;
    private static LocalDateTime saleTime;
    private static double totalPrice;
    private static double totalVat;
    private static ArrayList<Item> items;
    private static double totalDiscount;

    @BeforeAll
    public static void setup() {
        saleTime = LocalDateTime.now();
        totalPrice = 33.0;
        totalVat = 3.0;
        items = new ArrayList<>();
        totalDiscount = 5.0;
        sale = new SaleDTO(totalPrice, totalVat, saleTime, items, totalDiscount);
    }

    @Test
    public void testGetSaleTime() {
        LocalDateTime timeGiven = sale.getSaleTime();
        assertEquals(saleTime, timeGiven);
    }

    @Test
    public void testGetTotalPrice() {
        double priceGiven = sale.getTotalPrice();
        assertEquals(totalPrice, priceGiven);
    }

    @Test
    public void testGetTotalDiscount() {
        double discountGiven = sale.getTotalDiscount();
        assertEquals(totalDiscount, discountGiven);
    }

    @Test
    public void testGetTotalVat() {
        double vatGiven = sale.getTotalVat();
        assertEquals(totalVat, vatGiven);
    }
}
