package se.kth.iv1350.deppos.model.dto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;
import java.util.ArrayList;

import se.kth.iv1350.deppos.model.Item;

public class SaleDTOTest {
    private static SaleDTO sale;
    private static LocalTime saleTime = LocalTime.now();
    private static double runningTotal = 33.0;
    private static double totalPrice = 33.0;
    private static double totalVAT = 3.0;
    private static ArrayList<Item> items = new ArrayList<>();
    private static double totalDiscount = 5.0;

    @BeforeAll
    public static void setup() {
        sale = new SaleDTO(runningTotal, totalPrice, saleTime, totalVAT, items, totalDiscount);
    }

    @Test
    public void testGetSaleTime() {
        LocalTime timeGiven = sale.getSaleTime();
        assertEquals(saleTime, timeGiven);
    }

    @Test
    public void testGetTotalPrice() {
        double priceGiven = sale.getTotalPrice();
        assertEquals(totalPrice, priceGiven);
    }

    @Test
    public void testGetItems() {
        ArrayList<Item> itemsGiven = sale.getItems();
        assertEquals(items, itemsGiven);
    }

    @Test
    public void testGetTotalDiscount() {
        double discountGiven = sale.getTotalDiscount();
        assertEquals(totalDiscount, discountGiven);
    }

    @Test
    public void testGetTotalVAT() {
        double vatGiven = sale.getTotalVAT();
        assertEquals(totalVAT, vatGiven);
    }
}
