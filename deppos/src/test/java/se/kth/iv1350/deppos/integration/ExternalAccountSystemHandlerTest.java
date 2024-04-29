package se.kth.iv1350.deppos.integration;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.deppos.model.Item;
import se.kth.iv1350.deppos.model.dto.SaleDTO;

public class ExternalAccountSystemHandlerTest {

    private static SaleDTO sale;
    private static LocalTime saleTime;
    private static double runningTotal;
    private static double totalPrice;
    private static double totalVAT;
    private static ArrayList<Item> items;
    private static double totalDiscount;
    private static ExternalAccountSystemHandler eash;


    @BeforeEach
    public void setup() {
        saleTime = LocalTime.now();
        runningTotal = 33.0;
        totalPrice = 33.0;
        totalVAT = 3.0;
        items = new ArrayList<>();
        totalDiscount = 5.0;
        sale = new SaleDTO(runningTotal, totalPrice, saleTime, totalVAT, items, totalDiscount);
        eash = new ExternalAccountSystemHandler();
    }

    @Test
    public void testUpdateAndFetchExternalAccountSystem() {
        double initialAmount = eash.getTotalAmountOfMoney();
        eash.updateExternalAccountSystem(sale);
        assertEquals(initialAmount + (totalPrice - totalDiscount), eash.getTotalAmountOfMoney());
    }
}
