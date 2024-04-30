package se.kth.iv1350.deppos.integration;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.deppos.model.Item;
import se.kth.iv1350.deppos.model.dto.SaleDTO;

public class ExternalAccountSystemHandlerTest {

    private static SaleDTO sale;
    private static LocalDateTime saleTime;
    private static double totalPrice;
    private static double totalVat;
    private static ArrayList<Item> items;
    private static double totalDiscount;
    private static ExternalAccountSystemHandler eash;


    @BeforeEach
    public void setup() {
        saleTime = LocalDateTime.now();
        totalPrice = 33.0;
        totalVat = 3.0;
        items = new ArrayList<>();
        totalDiscount = 5.0;
        sale = new SaleDTO(totalPrice, totalVat, saleTime, items, totalDiscount);
        eash = new ExternalAccountSystemHandler();
    }

    @Test
    public void testUpdateAndFetchExternalAccountSystem() {
        double initialAmount = eash.getTotalAmountOfMoney();
        eash.updateExternalAccountSystem(sale);
        assertEquals(initialAmount + (totalPrice - totalDiscount), eash.getTotalAmountOfMoney());
    }
}
