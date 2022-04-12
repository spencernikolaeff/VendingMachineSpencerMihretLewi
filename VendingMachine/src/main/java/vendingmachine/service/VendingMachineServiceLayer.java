package vendingmachine.service;

import vendingmachine.dao.VendingMachineDaoEx;
import vendingmachine.dto.Drink;

import java.util.List;

public interface VendingMachineServiceLayer {

    void createDrink(Drink drink) throws
            VendingMachineDuplicateNameEx,
            VendingMachineDataValidationEx,
            VendingMachineDaoEx;

    List<Drink> getAllDrinks() throws
            VendingMachineDaoEx;

    Drink getDrink(String name) throws
            VendingMachineDaoEx;

    boolean sellDrink(Drink drink) throws
            VendingMachineDaoEx;

    Drink stockDrink(Drink drink, int quantity) throws
            VendingMachineDaoEx;
}
