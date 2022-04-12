/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vendingmachine.dto;

/**
 *
 * @author 17202
 */
public abstract class Drink {
    
    //attributes
    private String name;
    private int pricePenny; //pennies
    private int quantity;
    
    //basic constructor
    public Drink(String name){
        this.name = name;
    }
    
    //full constructor
    public Drink(String name, int price, int amount) {
        this.name = name;
        this.pricePenny = price;
        this.quantity = amount;
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
    
    //setters
    //
    //these are private and only used in DrinkFactory?
    //--------i couldn't figure out Java factory classes
    //maybe not necessary since we can just load the drinks from a file anyways
    //
    private void setName(String name){
        this.name = name;
    }
    
    private void setPrice(int price){
        this.pricePenny = price;
    }
    
    private void setQuantity(int quantity){
        this.quantity = quantity;
    }
    
}
