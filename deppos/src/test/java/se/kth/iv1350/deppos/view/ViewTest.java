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
    public void doShowTotalIncomeTest() {
        String expected = "Added 1 of item with item id 0 to the sale.\nItem ID:                0\nItem Name:              O'Boy 450g\nItem Cost:              37.95\nItem VAT:               12.0%\nItem Description:       A chocolate drink powder\n-------------------------------------------------";
        expected = expected.replaceAll("[^a-zA-Z0-9.%]", "");
        boolean containsItemInfo = outputStream.toString().replaceAll("[^a-zA-Z0-9.%]", "").contains(expected);

        standardOut.println("Captured Output:\n" + outputStream.toString());
        assertTrue(containsItemInfo, "It didn't print the expected result: " + expected);
    }

    // private View view;
    // private Controller contr;

    // @Test
    // public void testStartView() {
    // // view = new View(contr);
    // assertNotNull(view);
    // }
}