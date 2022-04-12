/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package vendingmachine.dao;

import vendingmachine.dto.Drink;

import java.util.List;

/**
 *
 * @author 17202
 */
public interface VendingMachineDao {

    //Add drink
    Drink addDrink(Drink drink) throws VendingMachineDaoEx;


    //List all drinks
    List<Drink> getAllDrinks() throws VendingMachineDaoEx;


    //Get drink
    Drink getDrink(String name) throws VendingMachineDaoEx;


    //Remove drink
    Drink removeDrink(String name) throws VendingMachineDaoEx;


    //Stock drink
    Drink stockDrink(Drink drink, int quantity) throws VendingMachineDaoEx;

    //Sell a drink
    boolean sellDrink(Drink drink) throws VendingMachineDaoEx;

    List<Drink> getAllPurchasableDrinks() throws VendingMachineDaoEx;
}
