package se.kth.iv1350.deppos.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.deppos.model.ConsoleRevenueObserver;

public class TotalRevenueViewTest {
    private PrintStream standardOut;
    private ByteArrayOutputStream outputStream;
    
    @BeforeEach
    public void setup() {
        standardOut = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test 
    public void doShowTotalIncomeTest() {
        
    }

}


