/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vendingmachine.ui;

import java.util.List;
import vendingmachine.dto.Drink;

/**
 *
 * @author 17202
 */
public class VendingMachineView {

    final private UserIO io;

    public VendingMachineView(UserIO io) {
        this.io = io;
    }

    //main menu
    public int printMenuAndGet() {
        io.print("Main Menu");
        io.print("1. List All Drinks");
        io.print("2. Enter Money");
        io.print("3. View Balance");
        io.print("4. View Drink");
        io.print("5. Purchase drink ");
        io.print("0. Exit");

        return io.readInt("Please select from the above choices.", 0, 5);
    }

    //used to list individual drink
    public String listTheProduct() {
        System.out.println("==== Search Drink ====");
        return io.readString("Please enter the drinkName :");

    }
    
    public void displayDrink(Drink name) {
        io.print("[Name] " + name.getName() + " [Price] " + name.getChange().getChangeString() + " [Quantity] " + name.getQuantity());
    }
    
    //buyDrink
    
    public boolean BuyDrink() {
        String userChoice = io.readString("Would you like to purchase this Drink? (y/n)");
        return userChoice.equals("y") || userChoice.equals("Y");
    }

    public String EnterMoney() {
        return io.readString("Please add money :");

    }

    public String listhePrice() {
        return io.readString("Please enter the product price :");

    }

    public void displayViewDrinkBanner() {
        io.print("====  View Drink ====");
    }

    public void displayAddSuccessBanner() {
        io.readString(
                "drink successfully added to your cart.  Please hit enter to continue");
    }
    
    //displayAllDrink
    public void displayAllDrinkBanner() {
        System.out.println("==== All Drinks ====");
    }

    public void displayAllDrink(List<Drink> DrinkList) {
        for (Drink currDrink : DrinkList) {
            String DrinkInfo = String.format("[Name] %s  ",
                    currDrink.getName());
                    io.print(DrinkInfo);
        }
        io.readString("Press Enter to continue.");
    }
    
    public void displayErrorMessage(String error) {
        System.out.println("Recieved Error: " + error);
    }
    
    //view balance
    public void viewBalanceBanner() {
        System.out.println("==== View Balance ====");
    }
    
    public void viewBalance(double n) {
        System.out.println("Current Balance: $" + n);
    }
    
    //exit
    public void exitMessage() {
        System.out.println("Goodbye! Don't forget to take your drinks!");
    }

}
