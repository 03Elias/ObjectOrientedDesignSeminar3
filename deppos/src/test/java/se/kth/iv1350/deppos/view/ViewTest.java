package se.kth.iv1350.deppos.view;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.deppos.controller.Controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;

public class ViewTest {
    private View view;
    private Controller contr;

    @BeforeEach
    public void setup() {
       view = new View(contr);
    }

    @Test
    public void testStartView() {
        assertNotNull(view);
    }
}