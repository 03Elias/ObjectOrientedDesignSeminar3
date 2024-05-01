package se.kth.iv1350.deppos.integration;

import se.kth.iv1350.deppos.model.Item;
import se.kth.iv1350.deppos.model.Sale;
import se.kth.iv1350.deppos.model.dto.ItemDTO;
import se.kth.iv1350.deppos.model.dto.SaleDTO;

public class MockData {

/**
 * A method for getting the "fake/mock" SaleDTO.
 *   
 * @return A SaleDTO that contains mock/fake information. 
 */
    public static SaleDTO getMockSaleDTO() {
        Sale sale = new Sale();
        sale.addItem(getMockItemDTOs()[0], getMockInventoryQuantities()[0]);
        return sale.getSaleDTO();
    }
    

    /**
     * A method for getting the "fake/mock" Items.
     * 
     * @return An item array is returned containing the fake/mock items. 
     */
    public static Item[] getMockItems() {
        return new Item[]{
            new Item(getMockItemDTOs()[0], 1),
            new Item(getMockItemDTOs()[1], 2),
            new Item(getMockItemDTOs()[2], 1),
        };
    }

    /**
     * A method for getting the "fake/mock" ItemDTOs.
     * 
     * @return An ItemDTO array is returned containing the fake/mock ItemDTOs (containing all information about an item).
     */
    public static ItemDTO[] getMockItemDTOs() {
        return new ItemDTO[]{
            new ItemDTO("O'Boy 450g", 37.95, 0.12, "A chocolate drink powder", 0),
            new ItemDTO("Heineken 33cl", 11.95, 0.25, "Beer", 1),
            new ItemDTO("Aftonbladet", 19.95, 0.06, "Newspaper", 2),
        };
    }

    /**
     * A method for getting the "fake/mock" inventory quantites for all fake/mock items in the external inventory system.
     * 
     * @return An integer array is returned containing the quantites of the different items.  
     */

    public static int[] getMockInventoryQuantities() {
        return new int[]{3, 4, 5};
    }
}
