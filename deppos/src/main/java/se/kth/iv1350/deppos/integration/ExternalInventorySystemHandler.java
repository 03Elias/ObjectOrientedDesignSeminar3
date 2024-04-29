package se.kth.iv1350.deppos.integration;

import se.kth.iv1350.deppos.model.Item;
import se.kth.iv1350.deppos.model.dto.ItemDTO;
import se.kth.iv1350.deppos.model.dto.SaleDTO;

public class ExternalInventorySystemHandler {
    ItemDTO[] items;
    int[] inventoryQuantities;

    /**
     * A constructor that creates/starts an instance of the External Inventory
     * System Handler that communicates
     * with the External Inventory System.
     */
    public ExternalInventorySystemHandler() {
        //Mockdata
        items = new ItemDTO[]{
            new ItemDTO(10.0, 0.1, "fakeItem1", 0),
            new ItemDTO(20.0, 0.2, "fakeItem2", 1),
            new ItemDTO(30.0, 0.3, "fakeItem3", 2),
        };

        inventoryQuantities = new int[]{3, 4, 5};
    }

    /**
     * updates the external inventory system after a sale has occured.
     * 
     * @param saleInfo The sale information that contains amount of items sold and
     *                 so on that is needed to update the inventory.
     */
    public void updateExternalInventorySystem(SaleDTO saleInfo) {
        for(Item item : saleInfo.getItems()){
            int itemID = item.getItemDTO().getItemID();
            int quantityInSale = item.getQuantity();
            
            inventoryQuantities[itemID] -= quantityInSale;
        }
    }

    public int checkInventoryQuantity(int id){
        return inventoryQuantities[id];
    }

    /**
     * To retrive item information of a specific item from the external inventory.
     * @param id The id of the item that is needed to be fetched.
     */
    public ItemDTO getItemInfo(int id){
        //fetch item info from external inventory
        for(ItemDTO item : items){
            if(item.getItemID() == id){
                return item;
            }
        }
        return null;
    }
}