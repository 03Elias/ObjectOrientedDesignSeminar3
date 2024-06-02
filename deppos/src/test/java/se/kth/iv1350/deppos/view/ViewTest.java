package se.kth.iv1350.deppos.view;

import org.junit.jupiter.api.Test;
import se.kth.iv1350.deppos.controller.Controller;
import se.kth.iv1350.deppos.integration.ExternalAccountSystemHandler;
import se.kth.iv1350.deppos.integration.ExternalInventorySystemHandler;
import se.kth.iv1350.deppos.integration.SalelogHandler;
import se.kth.iv1350.deppos.model.CashRegister;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;

public class ViewTest {
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

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void addItemTest() {
        String expected = "Added 1 of item with item id 0 to the sale.\nItem ID:                0\nItem Name:              O'Boy 450g\nItem Cost:              37.95\nItem VAT:               12.0%\nItem Description:       A chocolate drink powder\n-------------------------------------------------";
        expected = expected.replaceAll("[^a-zA-Z0-9.%]", "");
        boolean containsItemInfo = outputStream.toString().replaceAll("[^a-zA-Z0-9.%]", "").contains(expected);

        standardOut.println("Captured Output:\n" + outputStream.toString());
        assertTrue(containsItemInfo, "It didn't print the expected result: " + expected);
    }

    @Test
    public void printReceiptTest() {
        String expected1 = "------------------Begin Receipt-------------------Time of Sale:";

        String expected2 = "'Boy 450g       1 x 37:95       37:95 SEK Heineken 33cl    2 x 11:95       11:95 SEKAftonbladet      1 x 19:95       19:95 SEKTotal:           81:80 SEKVAT:             9:98 SEKCash:            90:00 SEKChange:          8:20 SEK--------------------End Receipt--------------------";
        expected1 = expected1.replaceAll("[^a-zA-Z0-9.%]", "");
        expected2 = expected2.replaceAll("[^a-zA-Z0-9.%]", "");
        boolean containsItemInfo1 = outputStream.toString().replaceAll("[^a-zA-Z0-9.%]", "").contains(expected1);
        boolean containsItemInfo2 = outputStream.toString().replaceAll("[^a-zA-Z0-9.%]", "").contains(expected2);

        standardOut.println("Captured Output:\n" + outputStream.toString());
        assertTrue(containsItemInfo1, "It didn't print the expected result: " + expected1);
        assertTrue(containsItemInfo2, "It didn't print the expected result: " + expected2);
    }
}