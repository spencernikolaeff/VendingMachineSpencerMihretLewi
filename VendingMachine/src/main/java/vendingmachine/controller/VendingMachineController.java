package vendingmachine.controller;

import java.util.List;
import vendingmachine.dao.VendingMachineDaoEx;
import vendingmachine.dao.VendingMachineFI;
import vendingmachine.dto.Change;
import vendingmachine.dto.Drink;
import vendingmachine.ui.UserIO;
import vendingmachine.ui.UserIOConsoleImpl;
import vendingmachine.ui.VendingMachineView;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 17202
 */
public class VendingMachineController {
    UserIO uio = new UserIOConsoleImpl();
    private VendingMachineFI dao = new VendingMachineFI();
    private VendingMachineView view = new VendingMachineView(uio);
    
    boolean programRunning = true;
    
    public void run() throws VendingMachineDaoEx {
        
        
        while(programRunning) {
            try {
                dao.loadDrinks();
            } catch (VendingMachineDaoEx e) {
                view.displayErrorMessage(e.getMessage());
            }
            int choice = view.printMenuAndGet();
            
            switch(choice) {
                
                case 1:
                    listDrinks();
                    break;
                case 2:
                    enterMoney();
                    break;
                case 3:
                    viewBalance();
                    break;
                case 4:
                    viewDrink();
                    break;
                case 5:
                    purchaseDrink();
                    break;
                case 6:
                    listAvailableDrinks();
                case 0:
                    exit();
                    programRunning = false;
                    break;
                default:
                    errorMessage("No option chosen.");
            }
            System.out.println();
            System.out.println();
        }
    }
    
    //stream method
    private void listAvailableDrinks() throws VendingMachineDaoEx {
        view.listAvailableDrinksBanner1();
        //Double price = view.getAvailableDrinksPrice();
        List<Drink> temp = dao.getAllPurchasableDrinks();
        //view.listAvailableDrinksBanner2(price);
        view.displayAllDrink(temp);
    }
    
    
    //list drinks
    private void listDrinks() throws VendingMachineDaoEx {
        view.displayAllDrinkBanner();
        view.displayAllDrink(dao.getAllDrinks());
    }
    
    //enter money
    private void enterMoney() {
        dao.addMoney(Integer.parseInt(view.EnterMoney()));
    }
    
    //view balance
    private void viewBalance() {
        view.viewBalance(dao.viewMoney());
    }
    
    //view drink
    private void viewDrink() throws VendingMachineDaoEx {
        view.displayViewDrinkBanner();
        String name = view.listTheProduct();
        view.displayDrink(dao.getDrink(name));
    }
    
    //purchase drink
    private void purchaseDrink() throws VendingMachineDaoEx {
        Drink temp = dao.getDrink(view.listTheProduct());
        view.displayDrink(temp);
        if(view.BuyDrink() == true){
            view.displayEnoughMoney(dao.sellDrink(temp));
        }
    }
    
    //exit
    private void exit() {
        view.exitMessage();
    }
    
    //error message
    private void errorMessage(String error) {
        view.errorMessage(error);
    }
    
}
