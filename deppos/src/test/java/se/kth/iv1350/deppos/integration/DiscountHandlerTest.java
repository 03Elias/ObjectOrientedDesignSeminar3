package se.kth.iv1350.deppos.integration;

import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.deppos.model.Item;
import se.kth.iv1350.deppos.model.dto.ItemDTO;
import se.kth.iv1350.deppos.model.dto.SaleDTO;

public class DiscountHandlerTest {
    private DiscountHandler dh;
    private static SaleDTO saleInfo;
    private static int customerID;
    private static LocalTime saleTime;
    private static double runningTotal;
    private static double totalPrice;
    private static double totalVAT;
    private static ArrayList<Item> items;
    private static double totalDiscount;

    @BeforeEach
    public void setup() {
        saleTime = LocalTime.now();
        runningTotal = 33.0;
        totalPrice = 33.0;
        totalVAT = 3.0;
        items = new ArrayList<>();
        items.add(new Item(new ItemDTO(10.0, 0.1, "fakeItem", 0), 2));
        saleInfo = new SaleDTO(runningTotal, totalPrice, saleTime, totalVAT, items, totalDiscount);
        customerID = 1;
    }

    @Test
    public void testGetDiscount() {
        dh = new DiscountHandler();
        double itemsDiscount = items.get(0).getTotalPrice() * 0.1;
        totalDiscount = itemsDiscount + (totalPrice - itemsDiscount) * 0.1;
        double discount = dh.getDiscount(customerID, saleInfo);
        assertEquals(totalDiscount, discount);
    }
}
