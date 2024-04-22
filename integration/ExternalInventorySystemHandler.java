package integration;

import model.dto.ItemDTO;
import model.dto.SaleDTO;

public class ExternalInventorySystemHandler {

    /**
     * A constructor that creates/starts an instance of the External Inventory
     * System Handler that communicates
     * with the External Inventory System.
     */
    public ExternalInventorySystemHandler() {

    }

    /**
     * updates the external inventory system after a sale has occured.
     * 
     * @param saleInfo The sale information that contains amount of items sold and
     *                 so on that is needed to update the inventory.
     */
    public void updateExternalInventorySystem(SaleDTO saleInfo) {

    }

    /**
     * To retrive item information of a specific item from the external inventory.
     * @param iteminfo
     */
    public ItemDTO getItemInfo(ItemDTO iteminfo){
        //fetch item info from external inventory
        return new ItemDTO(0, 0.0, "itemDescription", 0);
    }
}