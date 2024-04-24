package startup;

import controller.Controller;
import integration.DiscountHandler;
import integration.ExternalAccountSystemHandler;
import integration.SalelogHandler;
import integration.ExternalInventorySystemHandler;
import model.Cashregister;
import view.View;

public class Main {

    /**
     * The intiliazer for the application. Starts the application.
     * 
     * @param args Command-line argument passed to the application.
     */
    public static void main(String[] args) {
        DiscountHandler dh = new DiscountHandler();
        SalelogHandler slh = new SalelogHandler();
        ExternalAccountSystemHandler eash = new ExternalAccountSystemHandler();
        ExternalInventorySystemHandler eish = new ExternalInventorySystemHandler();
        Cashregister cr = new Cashregister();   //Fanns inte med i SSD:n

        Controller controller = new Controller(eish, eash, dh, slh, cr);

        View retailStoreView = new View(controller);
    }
}