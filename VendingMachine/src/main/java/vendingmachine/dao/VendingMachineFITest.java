package vendingmachine.dao;

import org.junit.jupiter.api.*;
import vendingmachine.dto.Drink;

import java.io.FileWriter;

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
}