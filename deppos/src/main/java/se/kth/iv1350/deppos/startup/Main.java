package se.kth.iv1350.deppos.startup;

import se.kth.iv1350.deppos.controller.Controller;
import se.kth.iv1350.deppos.integration.DiscountHandler;
import se.kth.iv1350.deppos.integration.ExternalAccountSystemHandler;
import se.kth.iv1350.deppos.integration.SalelogHandler;
import se.kth.iv1350.deppos.integration.ExternalInventorySystemHandler;
import se.kth.iv1350.deppos.integration.exceptions.*;
import se.kth.iv1350.deppos.model.CashRegister;
import se.kth.iv1350.deppos.view.TotalRevenueView;
import se.kth.iv1350.deppos.view.TotalRevenueFileOutput;
import se.kth.iv1350.deppos.view.View;

public class Main {

    /**
     * The intiliazer for the application. Starts the application.
     * 
     * @param args Command-line argument passed to the application.
     */
    public static void main(String[] args) throws ExternalConnectionException {
        DiscountHandler dh = new DiscountHandler();
        SalelogHandler slh = new SalelogHandler();
        TotalRevenueView revenueView = new TotalRevenueView();
        TotalRevenueFileOutput revenueOutput = new TotalRevenueFileOutput();
        ExternalAccountSystemHandler eash = new ExternalAccountSystemHandler();
        ExternalInventorySystemHandler eish = new ExternalInventorySystemHandler();
        CashRegister cr = CashRegister.getRegister();

        eash.addObserver(revenueView);
        eash.addObserver(revenueOutput);

        Controller controller = new Controller(eish, eash, dh, slh, cr);
        View retailStoreView = new View(controller);

        if(args != null) {
            retailStoreView.sampleRun();
        }
    }
}