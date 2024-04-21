package view;

import controller.Controller;

public class View {
    private Controller contr;

    /**
     * A new View instance is made that is associated with Controller.
     * 
     * @param contr The object Controller instance that the view will use.
     */

    public View(Controller contr) {

        this.contr = contr;
    }
}