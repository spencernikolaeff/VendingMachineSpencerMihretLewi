/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vendingmachine.dto;

/**
 *
 * @author Spencer
 */
public class Change {
    
    //attributes (denominations of coins)
    private int quarters;
    private int dimes;
    private int nickels;
    private int pennies;
    private double totalCoins;
    
    //constructor
    public Change(int penny) {
        this.totalCoins = penny;
        while(penny > 0) {
            if(penny >= 25) {
                this.quarters++;
            } else if(penny >= 10 && penny < 25) {
                this.dimes++;
            } else if(penny >= 5 && penny < 10) {
                this.nickels++;
            } else if(penny >= 1 && penny < 5) {
                this.pennies++;
            }
        }
    }
    
    //getters
    public int getQuarters() {
        return quarters;
    }
    
    public int getDimes() {
        return dimes;
    }
    
    public int getNickels() {
        return nickels;
    }
    
    public int getPennies() {
        return pennies;
    }
    
    //setters
    public void setQuarters(int num) {
        this.quarters = num;
    }
    
    public void setDimes(int num) {
        this.dimes = num;
    }
    
    public void setNickels(int num) {
        this.nickels = num;
    }
    
    public void setPennies(int num) {
        this.pennies = num;
    }
    
    //total coins
    public double getTotal() {
        return totalCoins;
    }
    
    public void setTotal(double total) {
        this.totalCoins = total;
    }
    
    //get change string format
    public String getChangeString() {
        String ret = String.valueOf(this.totalCoins/100);
        return ret;
    }
}
