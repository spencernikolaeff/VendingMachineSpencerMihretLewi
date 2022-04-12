package com.vendingmachine.unittesting;

import org.junit.jupiter.api.*;
import vendingmachine.dao.VendingMachineDao;
import vendingmachine.dao.VendingMachineFI;
import vendingmachine.dto.Drink;

import java.io.FileWriter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VendingMachineFITest {

    VendingMachineDao testDao;

    public VendingMachineFITest() {

    }

    @BeforeEach
    public void setUp() throws Exception{
        String testFile = "testFile.txt";
        // Use the FileWriter to quickly blank the file
        new FileWriter(testFile);
        testDao = new VendingMachineFI(testFile);
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testAddGetDrink() throws Exception {
        // Create our method test inputs
        String drinkName = "Coke";
        Drink drink = new Drink(drinkName);
        drink.setPrice(100);
        drink.setQuantity(5);

        //  Add the drink to the DAO
        testDao.addDrink(drink);
        // Get the drink from the DAO
        Drink retrievedStudent = testDao.getDrink(drinkName);

        // Check the data is equal
        assertEquals(drink.getName(),
                retrievedStudent.getName(),
                "Checking drink name.");
        assertEquals(drink.getPricePenny(),
                retrievedStudent.getPricePenny(),
                "Checking drink price.");
        assertEquals(drink.getQuantity(),
                retrievedStudent.getQuantity(),
                "Checking drink quantity.");
    }

    @Test
    public void testAddGetAllDrinks() throws Exception {
        // Create our first drink
        Drink drink1 = new Drink("Coke");
        drink1.setPrice(125);
        drink1.setQuantity(5);

        // Create our second drink
        Drink drink2 = new Drink("Sprite");
        drink2.setPrice(225);
        drink2.setQuantity(10);

        // Add both our drinks to the DAO
        testDao.addDrink(drink1);
        testDao.addDrink(drink2);

        // Retrieve the list of all students within the DAO
        List<Drink> allDrinks = testDao.getAllDrinks();

        // First check the general contents of the list
        assertNotNull(allDrinks, "The list of drinks must not null");
        assertEquals(2, allDrinks.size(),"List of drinks should have 2 drinks.");

        // Then the specifics
        assertTrue(testDao.getAllDrinks().contains(drink1),
                "The list of drinks should include Coke.");
        assertTrue(testDao.getAllDrinks().contains(drink2),
                "The list of drinks should include Sprite.");

    }

    @Test
    public void testSellDrink() throws Exception {
        testDao.addMoney(1000);

        // Create a drink
        Drink drink = new Drink("Coke");
        drink.setPrice(125);
        drink.setQuantity(5);

        // call sell drink method
        testDao.sellDrink(drink);

        int expected = 4;
        int actual = drink.getQuantity();

        //Checks to see if quantity decreases by 1 (sold 1 drink)
        assertEquals(expected, actual);
    }

    @Test
    public void testSellDrinkNoMoney() throws Exception {
        testDao.addMoney(1);

        // Create a drink
        Drink drink = new Drink("Coke");
        drink.setPrice(125);
        drink.setQuantity(5);

        // call sell drink method
        testDao.sellDrink(drink);

        int expected = 5;
        int actual = drink.getQuantity();

        //Checks to see if quantity decreases by 1 (sold 1 drink)
        assertEquals(expected, actual);
    }

    @Test
    public void testStockDrink() throws Exception {
        // Create a drink
        Drink drink = new Drink("Coke");
        drink.setPrice(125);
        drink.setQuantity(5);

        // Create a 2nd drink
        Drink drink2 = new Drink("Sprite");
        drink2.setPrice(225);
        drink2.setQuantity(0);

        // call sell drink method
        testDao.stockDrink(drink, 4);
        testDao.stockDrink(drink2, 4);

        int expectedDrink1 = 9;
        int actualDrink1 = drink.getQuantity();

        //Checks to see if quantity increases to 9 (stocked 4 so 4 + 5 = 9)
        assertEquals(expectedDrink1, actualDrink1);

        int expectedDrink2 = 4;
        int actualDrink2 = drink2.getQuantity();

        //Checks to see if quantity increases to 4 (stocked 4 so 4 + 0 = 4)
        assertEquals(expectedDrink2, actualDrink2);
    }
}