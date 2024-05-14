package se.kth.iv1350.deppos.view;

import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
import java.net.ConnectException;

import se.kth.iv1350.deppos.controller.Controller;
import se.kth.iv1350.deppos.model.dto.ItemDTO;
import se.kth.iv1350.deppos.model.dto.ReceiptDTO;
import se.kth.iv1350.deppos.model.dto.SaleDTO;

public class View {
    private Controller contr;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * A new View instance is made that is associated with Controller.
     * 
     * @param contr The object Controller instance that the view will use.
     */

    public View(Controller contr) {
        this.contr = contr;
    }

    /**
     * A sample run of the program
     * 
     */
    public void sampleRun() {

        contr.startSale();
        addItem(0, 1);
        addItem(1, 2);
        addItem(2, 1);

        SaleDTO saleInfo = contr.endSale();
        System.out.println("End sale: ");
        System.out.println(
                String.format("Total cost (incl VAT): \t%.2f SEK", saleInfo.getTotalPrice()).replace(",", ":"));
        System.out.println();

        System.out.println(String.format("Customer pays \t%.2f SEK", 90.0).replace(",", ":"));
        ReceiptDTO receipt = amountPaid(90);
        
        printReceipt(receipt);
    }

    /**
     * Prints the receipt of the sale.
     * 
     * @param receipt Is a ReceiptDTO containing all the information necessary
     *                regarding the ended sale.
     */
    private void printReceipt(ReceiptDTO receipt) {
        SaleDTO saleInfo = receipt.getSaleInfo();

        System.out.println("------------------Begin Receipt-------------------");
        System.out.println("Time of Sale: \t " + saleInfo.getSaleTime().format(formatter) + "\n");
        for (ItemDTO itemDTO : saleInfo.getItemMap().values()) {
            int itemQuantity = saleInfo.getItemQuantityMap().get(itemDTO.getItemId());
            double itemPrice = saleInfo.getItemPriceMap().get(itemDTO.getItemId());
            System.out.println(String.format("%s \t %d x %.2f \t %.2f SEK", itemDTO.getItemName(), itemQuantity,
                    itemDTO.getItemPrice(), itemPrice).replace(",", ":"));
        }
        ;
        System.out.println(String.format("\nTotal: \t\t %.2f SEK", saleInfo.getTotalPrice()).replace(",", ":"));
        System.out.println(String.format("VAT: \t\t %.2f SEK", saleInfo.getTotalVat()).replace(",", ":"));

        System.out.println("\nCash: \t\t " + String.format("%.2f SEK", receipt.getAmountPaid()).replace(",", ":"));
        System.out.println(String.format("Change: \t %.2f SEK", receipt.getChange()).replace(",", ":"));
        System.out.println("--------------------End Receipt--------------------");

        System.out.println(
                "\nChange to give the customer: " + String.format("%.2f SEK", receipt.getChange()).replace(",", ":"));
    }

    /**
     * Prints the adding of an item to the sale.
     * 
     * @param id       The id of the item to add to the sale.
     * @param quantity The amount of this said item that will be added into the
     *                 sale.
     * 
     */
    private void addItem(int id, int quantity) {
        try {
            SaleDTO saleInfo = contr.enterItem(id, quantity);
            ItemDTO itemInfo = saleInfo.getItemMap().get(id);

            System.out.println("Added " + quantity + " of item with item id " + id + " to the sale.");
            System.out.println("Item ID:\t\t" + id);
            System.out.println("Item Name:\t\t" + itemInfo.getItemName());
            System.out.println("Item Cost:\t\t" + itemInfo.getItemPrice());
            System.out.println("Item VAT:\t\t" + itemInfo.getItemVat() * 100 + "%");
            System.out.println("Item Description:\t" + itemInfo.getItemDescription());
            System.out.println("-------------------------------------------------");
            System.out.println(
                    String.format("Total cost (incl VAT): \t%.2f SEK", saleInfo.getTotalPrice()).replace(",", ":"));
            System.out.println(String.format("Total VAT: \t\t%.2f SEK", saleInfo.getTotalVat()).replace(",", ":"));
            System.out.println("-------------------------------------------------");
        } catch (ConnectException e1) {
            System.out.println(e1.getMessage());

        } catch (NoSuchElementException e2) {
            System.out.println(e2.getMessage());
        }
        // catch(NullPointerException e3){
        //     System.out.println(e3.getMessage());
        // }
    }

    private ReceiptDTO amountPaid(double amount){
        try {
            return contr.amountPaid(amount);
        }
        catch (ConnectException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}