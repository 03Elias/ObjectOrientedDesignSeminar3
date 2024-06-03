package se.kth.iv1350.deppos.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
//import java.lang.ModuleLayer.Controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.deppos.integration.ExternalAccountSystemHandler;
import se.kth.iv1350.deppos.integration.ExternalInventorySystemHandler;
import se.kth.iv1350.deppos.integration.SalelogHandler;
import se.kth.iv1350.deppos.model.CashRegister;
import se.kth.iv1350.deppos.model.ConsoleRevenueObserver;
import se.kth.iv1350.deppos.controller.*;

public class TotalRevenueViewTest {
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

        String expected = "TotalRevenueView shows: 81.8";
        assertTrue(outputStream.toString().contains(expected), "It didn't print the expected result: " + expected);
    }

}
