package vendingmachine.dao;

import vendingmachine.dto.Drink;

import java.util.ArrayList;
import java.util.List;

public class StubImpl implements VendingMachineDao {
    public Drink onlydrink;

    public StubImpl() {
        onlydrink = new Drink("Sprite");
        onlydrink.setPrice(225);
        onlydrink.setQuantity(4);
    }

    public StubImpl(Drink testDrink) {
        this.onlydrink = testDrink;
    }

    @Override
    public Drink addDrink(Drink drink) throws VendingMachineDaoEx {
        if (drink.getName().equals(onlydrink.getName())) {
            return onlydrink;
        } else {
            return null;
        }
    }

    @Override
    public List<Drink> getAllDrinks() throws VendingMachineDaoEx {
        List<Drink> drinkList = new ArrayList<>();
        drinkList.add(onlydrink);
        return drinkList;
    }

    @Override
    public Drink getDrink(String name) throws VendingMachineDaoEx {
        if (name.equals(onlydrink.getName())) {
            return onlydrink;
        } else {
            return null;
        }
    }

    @Override
    public Drink removeDrink(String name) throws VendingMachineDaoEx {
        if (name.equals(onlydrink.getName())) {
            return onlydrink;
        } else {
            return null;
        }
    }

    @Override
    public Drink stockDrink(Drink drink, int quantity) throws VendingMachineDaoEx {
        return null;
    }

    @Override
    public boolean sellDrink(Drink drink) throws VendingMachineDaoEx {
        return false;
    }

    @Override
    public void addMoney(int amount) {
    }

}
