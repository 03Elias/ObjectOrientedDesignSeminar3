package se.kth.iv1350.deppos.model.dto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;

public class ItemDTOTest {
    private static ItemDTO item;
    private static double itemPrice = 50.0;
    private static double VAT = 0.12;
    private static String itemDescription = "TestItem";
    private static int itemID = 1;

    @BeforeAll
    public static void setup() {
        item = new ItemDTO(itemPrice, VAT, itemDescription, itemID);
    }

    @Test
    public void testGetItemPrice() {
        double priceGiven = item.getItemPrice();
        assertEquals(itemPrice, priceGiven);
    }

    @Test
    public void testGetVAT() {
        double vatGiven = item.getVAT();
        assertEquals(VAT, vatGiven);
    }

    @Test
    public void testGetItemDescription() {
        String descriptionGiven = item.getItemDescription();
        assertEquals(itemDescription, descriptionGiven);
    }

    @Test
    public void testGetItemID() {
        int idGiven = item.getItemID();
        assertEquals(itemID, idGiven);
    }
}
