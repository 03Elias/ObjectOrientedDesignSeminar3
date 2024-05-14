package se.kth.iv1350.deppos.model;

import se.kth.iv1350.deppos.integration.exceptions.*;

import se.kth.iv1350.deppos.integration.MockData;
import se.kth.iv1350.deppos.model.dto.ItemDTO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SaleTest {
    private ItemDTO itemInfo;
    private static Sale mySale;

    @BeforeEach
    public void setup() {
        itemInfo = MockData.getMockItemDTOs()[0];
        mySale = new Sale();
    }

    @Test
    void testAddItemIntoCurrentSale() throws ItemNotFoundException {
        ItemDTO expResult = itemInfo;
        ItemDTO result = mySale.addItem(itemInfo, 1).getItemMap().get(itemInfo.getItemId());
        assertEquals(expResult, result, "Verify that the item is in the sale");
    }

    @Test
    void testIncreasingItemQuantityOfSaleItem() throws ItemNotFoundException {
        int expResult = 1;
        int result = mySale.addItem(itemInfo, 1).getItemQuantityMap().get(0);
        assertEquals(expResult, result, "Item quantity should be 1");
        expResult = 2;
        result = mySale.increaseItemQuantity(0, 1).getItemQuantityMap().get(0);
        assertEquals(expResult, result, "Item quantity should be 2");
    }

    @Test
    void testApplyDiscount() {
        double expResult = 13.37;
        double result = mySale.applyDiscount(13.37).getTotalDiscount();
        assertEquals(expResult, result, "The totalDiscount should be 13.37");
    }

    @Test
    void testCheckIfItemIDIsAlreadyInCurrentSale() throws ItemNotFoundException {
        mySale.addItem(itemInfo, 1);
        boolean expResult = true;
        boolean result = mySale.checkId(0);
        assertEquals(expResult, result, "Program didn't found ID for item that was added");
    }

    // Exception Handling Tests, maybe should be moved.//

    @Test
    void testFindItemByInvalidId() throws ItemNotFoundException {
        int existentID = itemInfo.getItemId();
        int nonExistentID = -1;
        assertNotEquals(existentID, nonExistentID, "The id's for the test isn't unequal");

        mySale.addItem(itemInfo, existentID);

        assertThrows(ItemNotFoundException.class, () -> {
            mySale.findItemById(nonExistentID);
        });
    }
    @Test
    void testFindItemByValidId() throws ItemNotFoundException {
        int existentID = itemInfo.getItemId();
        int validID = 0;
        assertEquals(existentID, validID, "The id's for the test isn't equal");

        mySale.addItem(itemInfo, existentID);

        assertDoesNotThrow(() -> mySale.findItemById(validID));
    }
}