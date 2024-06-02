package se.kth.iv1350.deppos.startup;

import org.junit.jupiter.api.Test;

import se.kth.iv1350.deppos.controller.Controller;
import se.kth.iv1350.deppos.integration.ExternalAccountSystemHandler;
import se.kth.iv1350.deppos.integration.ExternalInventorySystemHandler;
import se.kth.iv1350.deppos.integration.SalelogHandler;
import se.kth.iv1350.deppos.model.CashRegister;
import se.kth.iv1350.deppos.view.TotalRevenueFileOutput;
import se.kth.iv1350.deppos.view.TotalRevenueView;
import se.kth.iv1350.deppos.view.View;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;

public class MainTest {
    private PrintStream standardOut;
    private ByteArrayOutputStream outputStream;
    private View retailStoreView;

    @BeforeEach
    public void setup() throws Exception {

        outputStream = new ByteArrayOutputStream();
        standardOut = System.out;
        System.setOut(new PrintStream(outputStream));
        SalelogHandler slh = new SalelogHandler();
        TotalRevenueView revenueView = new TotalRevenueView();
        TotalRevenueFileOutput revenueOutput = new TotalRevenueFileOutput();
        ExternalAccountSystemHandler eash = new ExternalAccountSystemHandler();
        ExternalInventorySystemHandler eish = new ExternalInventorySystemHandler();
        CashRegister cr = CashRegister.getRegister();

        eash.addObserver(revenueView);
        // eash.addObserver(revenueOutput);

        Controller controller = new Controller(eish, eash, slh, cr);
        retailStoreView = new View(controller);
        retailStoreView.sampleRun();
    }

    @Test
    public void testMain() {
        assertDoesNotThrow(() -> Main.main(null));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void addItemTest() {
        String expected1 = "Added 1 of item with item id 0 to the sale.\n" +
                "Item ID:                0\n" +
                "Item Name:              O'Boy 450g\n" +
                "Item Cost:              37.95\n" +
                "Item VAT:               12.0%\n" +
                "Item Description:       A chocolate drink powder\n" +
                "-------------------------------------------------\n" +
                "Total cost (incl VAT):  37:95 SEK\n" +
                "Total VAT:              4:07 SEK\n" +
                "-------------------------------------------------\n" +
                "Added 2 of item with item id 1 to the sale.\n" +
                "Item ID:                1\n" +
                "Item Name:              Heineken 33cl\n" +
                "Item Cost:              11.95\n" +
                "Item VAT:               25.0%\n" +
                "Item Description:       Beer\n" +
                "-------------------------------------------------\n" +
                "Total cost (incl VAT):  61:85 SEK\n" +
                "Total VAT:              8:85 SEK\n" +
                "-------------------------------------------------\n" +
                "Added 1 of item with item id 2 to the sale.\n" +
                "Item ID:                2\n" +
                "Item Name:              Aftonbladet\n" +
                "Item Cost:              19.95\n" +
                "Item VAT:               6.0%\n" +
                "Item Description:       Newspaper\n" +
                "-------------------------------------------------\n" +
                "Total cost (incl VAT):  81:80 SEK\n" +
                "Total VAT:              9:98 SEK\n" +
                "-------------------------------------------------\n" +
                "End sale:\n" +
                "Total cost (incl VAT):  81:80 SEK\n\n" +
                "Customer pays   90:00 SEK\n" +
                "TotalRevenueView shows: 81.8\n" +
                "------------------Begin Receipt-------------------\n" +
                "Time of Sale:";

        String expected2 = "O'Boy 450g       1 x 37:95       37:95 SEK\n" +
                "Heineken 33cl    2 x 11:95       11:95 SEK\n" +
                "Aftonbladet      1 x 19:95       19:95 SEK\n\n" +
                "Total:           81:80 SEK\n" +
                "VAT:             9:98 SEK\n\n" +
                "Cash:            90:00 SEK\n" +
                "Change:          8:20 SEK\n" +
                "--------------------End Receipt--------------------\n\n" +
                "Change to give the customer: 8:20 SEK";

        expected1 = expected1.replaceAll("[^a-zA-Z0-9.%]", "");
        expected2 = expected2.replaceAll("[^a-zA-Z0-9.%]", "");
        boolean containsItemInfo1 = outputStream.toString().replaceAll("[^a-zA-Z0-9.%]", "").contains(expected1);
        boolean containsItemInfo2 = outputStream.toString().replaceAll("[^a-zA-Z0-9.%]", "").contains(expected2);

        standardOut.println("Captured Output:\n" + outputStream.toString());
        assertTrue(containsItemInfo1, "It didn't print the expected result: " + expected1);
        assertTrue(containsItemInfo2, "It didn't print the expected result: " + expected2);
    }
}