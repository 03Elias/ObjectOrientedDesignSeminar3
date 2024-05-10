package se.kth.iv1350.deppos.model;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.deppos.integration.MockData;

class ItemTest {
    private Item item;
    private double itemPrice;
    private double itemVat;

    @BeforeEach
    public void setup() {
        item = MockData.getMockItems()[0];
        itemPrice = item.getItemDTO().getItemPrice();
        itemVat = item.getItemDTO().getItemVat();
    }

    @Test
    public void testIncreaseQuantityForAnItem() { 
        assertEquals(1, item.getQuantity(), "Quantity should be 1 at the beginning");
        item.increaseQuantity(2);
        assertEquals(3, item.getQuantity(), "Quantity should be 3 since increased it by 2");
    }

    @Test
    public void testCalculateTotalPriceForAllQuantitiesOfTheItem() {
        assertEquals(itemPrice, item.getTotalPrice(), "Total price should be " + itemPrice + " since we only have 1 item");
        item.increaseQuantity(3);
        double totalPrice = itemPrice * 4;

                assertEquals(totalPrice, item.getTotalPrice(), "Total price should be " + totalPrice + " since we have 4 items");
    }

    @Test
    public void testCalculateTotalVatForAllQuantitiesOfTheItem() { 
        double totalVat = itemPrice - (itemPrice / (1 + itemVat));
        assertEquals(totalVat, item.getTotalVat(), "Total vat should be " + totalVat);
        item.increaseQuantity(3);
        totalVat += totalVat * 3;
        assertEquals(totalVat, item.getTotalVat(), "Total vat should be " + totalVat);
    }
}