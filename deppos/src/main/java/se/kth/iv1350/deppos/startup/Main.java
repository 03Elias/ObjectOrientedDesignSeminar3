package se.kth.iv1350.deppos.startup;

import se.kth.iv1350.deppos.controller.Controller;
import se.kth.iv1350.deppos.integration.ExternalAccountSystemHandler;
import se.kth.iv1350.deppos.integration.SalelogHandler;
import se.kth.iv1350.deppos.integration.ExternalInventorySystemHandler;
import se.kth.iv1350.deppos.integration.exceptions.*;
import se.kth.iv1350.deppos.model.CashRegister;
import se.kth.iv1350.deppos.model.CompositionRandom;
import se.kth.iv1350.deppos.view.TotalRevenueView;
import se.kth.iv1350.deppos.view.TotalRevenueFileOutput;
import se.kth.iv1350.deppos.view.View;
import se.kth.iv1350.deppos.model.InheritanceRandom;

public class Main {

    /**
     * The intiliazer for the application. Starts the application.
     * 
     * @throws ExternalConnectionException if there is an error with connecting to
     *                                     the inventory.
     * @param args Command-line argument passed to the application.
     */
    public static void main(String[] args) throws ExternalConnectionException {
        SalelogHandler slh = new SalelogHandler();
        TotalRevenueView revenueView = new TotalRevenueView();
        TotalRevenueFileOutput revenueOutput = new TotalRevenueFileOutput();
        ExternalAccountSystemHandler eash = new ExternalAccountSystemHandler();
        ExternalInventorySystemHandler eish = new ExternalInventorySystemHandler();
        CashRegister cr = CashRegister.getRegister();

        eash.addObserver(revenueView);
        eash.addObserver(revenueOutput);

        Controller controller = new Controller(eish, eash, slh, cr);
        View retailStoreView = new View(controller);

        if (args != null) {
            // retailStoreView.sampleRun();
            sampleRunInheritanceComposition();
        }
    }

    public static void sampleRunInheritanceComposition() {
        System.out.println("Testing InheritanceRandom().printRandomIntTimes2");
        InheritanceRandom myInheritanceRandom = new InheritanceRandom();
        myInheritanceRandom.printRandomIntTimes2(100);
        System.out.println("");
        
        System.out.println("Testing CompositionRandom().printRandomIntTimes2");
        CompositionRandom myCompositionRandom = new CompositionRandom();
        myCompositionRandom.printRandomIntTimes2(100);
    }
}