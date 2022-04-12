/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vendingmachine.dto;

import vendingmachine.dto.Change;

import java.util.Objects;

/**
 *
 * @author Spencer
 */
public class Drink {
    
    //attributes
    private String name;
    private int pricePenny; //pennies
    private Change inChange;
    private int quantity;
    
    private String id; //optional
    
    //basic constructor
    public Drink(String name){
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drink drink = (Drink) o;
        return name.equals(drink.name) && pricePenny == drink.pricePenny &&
                quantity == drink.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pricePenny, quantity);
    }
    
    //full constructor
    public Drink(String name, int price, int amount, String id) {
        this.name = name;
        this.pricePenny = price;
        this.quantity = amount;
        this.inChange = new Change(price);
        this.id = id; //optional
    }
    
    //getters
    //
    //these are public since they'll need to be accessed outside the class
    //
    public String getName() {
        return name;
    }
    
    public int getPricePenny() {
        return pricePenny;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public Change getChange() {
        return inChange;
    }
    
    //optional
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    //setters
    //
    //these are private and only used in DrinkFactory?
    //--------i couldn't figure out Java factory classes
    //maybe not necessary since we can just load the drinks from a file anyways
    //
    public void setName(String name){
        this.name = name;
    }

    public void setPrice(int price){
        this.pricePenny = price;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public void setChange(Change change) {
        this.inChange = change;
    }
    
}
