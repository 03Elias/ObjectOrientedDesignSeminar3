package se.kth.iv1350.deppos.model.dto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;

public class ItemDTOTest {
    private static ItemDTO item;
    private static String itemName;
    private static double itemPrice;
    private static double vat;
    private static String itemDescription;
    private static int itemID;

    @BeforeAll
    public static void setup() {
        itemName = "TestItem";
        itemPrice = 50.0;
        vat = 0.12;
        itemDescription = "TestItemDescription";
        itemID = 1;
        item = new ItemDTO(itemName, itemPrice, vat, itemDescription, itemID);
    }

    @Test
    public void testGetItemPrice() {
        double priceGiven = item.getItemPrice();
        assertEquals(itemPrice, priceGiven);
    }

    @Test
    public void testGetVat() {
        double vatGiven = item.getItemVat();
        assertEquals(vat, vatGiven);
    }

    @Test
    public void testGetItemDescription() {
        String descriptionGiven = item.getItemDescription();
        assertEquals(itemDescription, descriptionGiven);
    }

    @Test
    public void testGetItemId() {
        int idGiven = item.getItemId();
        assertEquals(itemID, idGiven);
    }
}
