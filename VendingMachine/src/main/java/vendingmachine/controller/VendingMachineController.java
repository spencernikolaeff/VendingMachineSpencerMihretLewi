package vendingmachine.controller;

import vendingmachine.dao.VendingMachineFI;
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
    private VendingMachineFI dao = new VendingMachineDaoFI();
    private VendingMachineView view = new VendingMachineView(uio);
    
    boolean programRunning = true;
    
    public void run() {
        
        while(programRunning) {
            
            dao.loadDrinks();
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
                case 0:
                    exit();
                    break;
                default:
                    errorMessage();
            }
            System.out.println();
            System.out.println();
        }
    }
    
    //list drinks
    private void listDrinks() {
        
    }
    
    //enter money
    private void enterMoney() {
        
    }
    
    //view balance
    private void viewBalance() {
        
    }
    
    //view drink
    private void viewDrink() {
        
    }
    
    //purchase drink
    private void purchaseDrink() {
        
    }
    
    //exit
    private void exit() {
        
    }
    
    //error message
    private void errorMessage() {
        System.out.println("Error Message");
    }
    
}
