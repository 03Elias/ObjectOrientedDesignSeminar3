package se.kth.iv1350.deppos.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.deppos.model.dto.ItemDTO;

class ItemTest {
    private Item item;
    private ItemDTO itemInfo;
    private int quantity;

    @BeforeEach
    public void setup() {
        itemInfo = new ItemDTO(33.0, 0.12, "TestItem", 1);
        quantity = 1;
        item = new Item(itemInfo, quantity);
    }

    @Test
    public void testIncreaseQuantity() { 
        assertEquals(1, item.getQuantity());
        item.increaseQuantity(2);
        assertEquals(3, item.getQuantity());
    }

    @Test
    public void testGetTotalPrice() { 
        double totalPrice = 36.96;
        assertEquals(totalPrice, item.getTotalPrice());
        item.increaseQuantity(3);
        totalPrice = 147.84;
        assertEquals(totalPrice, item.getTotalPrice());
    }

    @Test
    public void testGetTotalVAT() { 
        double totalVAT = 3.96;
        assertEquals(totalVAT, item.getTotalVAT());
        item.increaseQuantity(3);
        totalVAT = 15.84;
        assertEquals(totalVAT, item.getTotalVAT());
    }
}
