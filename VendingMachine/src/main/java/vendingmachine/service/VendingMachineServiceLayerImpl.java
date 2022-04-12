package vendingmachine.service;

import vendingmachine.dao.AuditDao;
import vendingmachine.dao.VendingMachineDao;
import vendingmachine.dao.VendingMachineDaoEx;
import vendingmachine.dto.Drink;

import java.util.List;

public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer {
    VendingMachineDao dao;
    private AuditDao auditDao;

    public VendingMachineServiceLayerImpl(VendingMachineDao dao, AuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public void createDrink(Drink drink) throws VendingMachineDuplicateNameEx, VendingMachineDataValidationEx, VendingMachineDaoEx {
        if (dao.getDrink(drink.getName()) != null) {
            throw new VendingMachineDuplicateNameEx(
                    "ERROR: Could not create drink. Drink name "
                        + drink.getName()
                        + " already exists");
        }

        validateDrinkData(drink);

        dao.addDrink(drink);

        auditDao.writeAuditEntry("Drink " + drink.getName() + " CREATED.");
    }

    @Override
    public List<Drink> getAllDrinks() throws VendingMachineDaoEx {
        return dao.getAllDrinks();
    }

    @Override
    public Drink getDrink(String name) throws VendingMachineDaoEx {
        return dao.getDrink(name);
    }

    @Override
    public boolean sellDrink(Drink drink) throws VendingMachineDaoEx {
        boolean soldDrink = dao.sellDrink(drink);

        auditDao.writeAuditEntry("Drink " + drink.getName() + " sold.");

        return soldDrink;
    }

    @Override
    public Drink stockDrink(Drink drink, int quantity) throws VendingMachineDaoEx {
        Drink stockedDrink = dao.stockDrink(drink, quantity);

        auditDao.writeAuditEntry("Drink " + drink.getName() + " updated stock: " + stockedDrink.getQuantity());
        return stockedDrink;
    }

    private void validateDrinkData(Drink drink) throws VendingMachineDataValidationEx {
        if (drink.getName() == null
                || drink.getName().trim().length() == 0
                || drink.getPricePenny() < 0
                || drink.getQuantity() < 0) {

            throw new VendingMachineDataValidationEx(
                    "ERROR: All frields [Name, Price, Quantity] are required.");
        }
    }
}
