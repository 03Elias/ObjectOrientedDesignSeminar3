package se.kth.iv1350.deppos.integration;

import se.kth.iv1350.deppos.model.Item;
import se.kth.iv1350.deppos.model.dto.ItemDTO;
import se.kth.iv1350.deppos.model.dto.SaleDTO;

public class ExternalInventorySystemHandler {
    ItemDTO[] mockItems = new ItemDTO[]{
        new ItemDTO(10.0, 0.1, "fakeItem1", 0),
        new ItemDTO(20.0, 0.2, "fakeItem2", 1),
        new ItemDTO(30.0, 0.3, "fakeItem3", 2),
    };

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
        //update inventory
    }

    /**
     * To retrive item information of a specific item from the external inventory.
     * @param id The id of the item that is needed to be fetched.
     */
    public ItemDTO getItemInfo(int id){
        //fetch item info from external inventory
        for(ItemDTO item : mockItems){
            if(item.getItemID() == id){
                return item;
            }
        }

        return null;
    }
}