package se.kth.iv1350.deppos.integration;

import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.deppos.model.Item;
import se.kth.iv1350.deppos.model.dto.ItemDTO;
import se.kth.iv1350.deppos.model.dto.SaleDTO;

public class ExternalInventorySystemHandlerTest {

    private static LocalTime saleTime;
    private static SaleDTO saleInfo;
    private static double runningTotal;
    private static double totalPrice;
    private static double totalVAT;
    private static ArrayList<Item> items;
    private static double totalDiscount;
    private static ExternalInventorySystemHandler eish;

    @BeforeEach
    public void setup() {
        saleTime = LocalTime.now();
        runningTotal = 33.0;
        totalPrice = 33.0;
        totalVAT = 3.0;
        totalDiscount = 5.0;
        items = new ArrayList<>();
        items.add(new Item(new ItemDTO(30, 0.1, "fakeItem", 0), 2));
        saleInfo = new SaleDTO(runningTotal, totalPrice, saleTime, totalVAT, items, totalDiscount);
        eish = new ExternalInventorySystemHandler();
    }

    @Test
    public void testUpdateAndGetExternalInventorySystem() {
        int quantity = eish.checkInventoryQuantity(0);
        eish.updateExternalInventorySystem(saleInfo);
        int newQuantity = eish.checkInventoryQuantity(0);
        assertEquals(quantity - items.get(0).getQuantity(), newQuantity);
    }
}
