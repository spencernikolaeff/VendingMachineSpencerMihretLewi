package vendingmachine.service;

import org.junit.jupiter.api.*;
import vendingmachine.dao.*;
import vendingmachine.dto.Drink;

import static org.junit.jupiter.api.Assertions.*;

class VendingMachineServiceLayerImplTest {
    private VendingMachineServiceLayer service;

    public VendingMachineServiceLayerImplTest() {
        VendingMachineDao dao = new StubImpl();
        AuditDao auditDao = new AuditDaoStubImpl();

        service = new VendingMachineServiceLayerImpl(dao, auditDao);
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testCreateValidDrink() {
        Drink drink = new Drink("Coke");
        drink.setPrice(125);
        drink.setQuantity(5);

        try {
            service.createDrink(drink);
        } catch (VendingMachineDuplicateNameEx
                | VendingMachineDataValidationEx
                | VendingMachineDaoEx e) {
            fail("Drink was valid. No exception should have been thrown");
        }
    }

    @Test
    public void testCreateDuplicateNameDrink() {
        Drink drink = new Drink("Sprite");
        drink.setPrice(500);
        drink.setQuantity(50);

        try {
            service.createDrink(drink);
            fail("Expected Dupe Name Exception was not thrown");
        } catch (VendingMachineDataValidationEx
                | VendingMachineDaoEx e) {
            fail("Incorrect exception was thrown.");
        } catch (VendingMachineDuplicateNameEx e) {
            return;
        }
    }

    @Test
    public void testCreateDrinkInvalidData() throws Exception {
        Drink drink = new Drink("Fanta");
        drink.setPrice(-1);
        drink.setQuantity(20);

        try {
            service.createDrink(drink);
            fail("Expected ValidationException was not thrown.");
        } catch (VendingMachineDuplicateNameEx | VendingMachineDaoEx e) {
            fail("Incorrect exception was thrown");
        } catch (VendingMachineDataValidationEx e) {
            return;
        }
    }

    @Test
    public void testGetDrink() throws Exception {
        Drink testClone = new Drink("Sprite");
        testClone.setPrice(225);
        testClone.setQuantity(4);

        // ACT & ASSERT
        Drink shouldBeSprite = service.getDrink("Sprite");
        assertNotNull(shouldBeSprite, "Getting Sprite should be not null.");
        assertEquals(testClone, shouldBeSprite,
                "Drink stored under Sprite should be 225.");

        Drink shouldBeNull = service.getDrink("ASDF");
        assertNull(shouldBeNull, "Getting ASDF should be null.");

    }

}