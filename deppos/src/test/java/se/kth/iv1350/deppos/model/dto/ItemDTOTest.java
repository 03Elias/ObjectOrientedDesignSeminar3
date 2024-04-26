package se.kth.iv1350.deppos.model.dto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;

public class ItemDTOTest {
    private static ItemDTO item;
    private static double itemPrice;
    private static double VAT;
    private static String itemDescription;
    private static int itemID;

    @BeforeAll
    public static void setup() {
        itemPrice = 50.0;
        VAT = 0.12;
        itemDescription = "TestItem";
        itemID = 1;
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
