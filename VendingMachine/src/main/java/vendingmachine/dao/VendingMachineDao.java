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
    Drink addDrink(Drink drink);


    //List all drinks
    List<Drink> getAllDrinks();


    //Get drink
    Drink getDrink(String name);


    //Remove drink
    Drink removeDrink(String name);


    //Stock drink
    Drink stockDrink(Drink drink, int quantity);

    //Sell a drink
    Drink sellDrink(Drink drink);
}
