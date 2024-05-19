package se.kth.iv1350.deppos.integration;

import se.kth.iv1350.deppos.integration.exceptions.*;
import se.kth.iv1350.deppos.model.dto.ItemDTO;
import se.kth.iv1350.deppos.model.dto.SaleDTO;

public class ExternalInventorySystemHandler {
    // Mockdata
    private ExceptionHandler eh;
    private ItemDTO[] items = MockData.getMockItemDTOs();
    private int[] inventoryQuantities = MockData.getMockInventoryQuantities();

    /**
     * A constructor that creates/starts an instance of the External Inventory
     * System Handler that communicates
     * with the External Inventory System.
     */
    public ExternalInventorySystemHandler() {
        eh = new ExceptionHandler("inventory");
    }

    /**
     * Updates the external inventory system after a sale has occured.
     * 
     * @param saleInfo The sale information that contains amount of items sold and
     *                 so on that is needed to update the External.
     */
    public void updateExternalInventorySystem(SaleDTO saleInfo) throws ExternalConnectionException {
        for (ItemDTO itemDTO : saleInfo.getItemMap().values()) {
            int itemId = itemDTO.getItemId();
            simulateThrowDependingOnID(itemId);

            int quantityInSale = saleInfo.getItemQuantityMap().get(itemId);

            inventoryQuantities[itemId] -= quantityInSale;
        }
    }

    /**
     * Checks the external inventory system for a certian quantity of an item.
     * 
     * @param id Identifies the desired item.
     * @return The quantity of the desired item that is stored in the external
     *         inventory system.
     * @throws Exception if the given item ID does not exist in inventory catalog.
     */

    public int checkInventoryQuantity(int id) throws ExternalConnectionException {
        simulateThrowDependingOnID(id);

        return inventoryQuantities[id];
    }

    /**
     * To retrive item information of a specific item from the external Inventory.
     * 
     * @param id The id of the item that is needed to be fetched.
     * @throws Exception if the given item ID does not exist in Inventory catalog.
     */
    public ItemDTO getItemInfo(int id) throws ExternalConnectionException, ItemNotFoundException {
        simulateThrowDependingOnID(id);

        for (ItemDTO item : items) {
            if (item.getItemId() == id) {
                return item;
            }
        }
        eh.handleNoSuchElementError();
        return null;
    }

    /**
     * Simulates an error depending on the given items id
     */
    private void simulateThrowDependingOnID(int id) throws ExternalConnectionException {
        if (id == 3) {
            eh.handleConnectionError();
        }
    }
}