/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vendingmachine.dto;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Spencer
 */
public class Change {

    public enum Coin {
        QUARTER, DIME, NICKEL, PENNY
    }

    //attributes (denominations of coins)
    private int quarters;
    private int dimes;
    private int nickels;
    private int pennies;
    private int totalValue;

    private int numCoins;
    private Map<Coin, Integer> purse;

    //constructor
    public Change(int penny) {
        numCoins = 0;
        this.totalValue = penny;
        Map<Coin, Integer> temp = new HashMap<>();
        temp.put(Coin.QUARTER,0);
        temp.put(Coin.DIME,0);
        temp.put(Coin.NICKEL,0);
        temp.put(Coin.PENNY,0);
        purse = temp;
        addCoins(penny);
    }
    

    //purse method for adding coins
    public void addCoins(int penny) {
        this.totalValue = this.totalValue + penny;
        while (penny > 0) {
            if (penny >= 25) {
                int numQ = purse.get(Coin.QUARTER)+1;
                purse.put(Coin.QUARTER, numQ);
                penny = penny - 25;
                this.quarters++;
                this.numCoins++;
            } else if (penny >= 10 && penny < 25) {
                int numD = purse.get(Coin.DIME)+1;
                purse.put(Coin.DIME, numD);
                penny = penny - 10;
                this.dimes++;
                this.numCoins++;
            } else if (penny >= 5 && penny < 10) {
                int numN = purse.get(Coin.NICKEL)+1;
                purse.put(Coin.NICKEL, numN);
                penny = penny - 5;
                this.nickels++;
                this.numCoins++;
            } else if (penny >= 1 && penny < 5) {
                int numP = purse.get(Coin.PENNY)+1;
                purse.put(Coin.PENNY, numP);
                penny = penny - 1;
                this.pennies++;
                this.numCoins++;
            }
        }
    }
    
    
    //purse method for spending coins
    public void spendCoins(int penny) {
        this.totalValue = this.totalValue - penny;
        while (penny > 0) {
            if (penny >= 25) {
                int numQ = purse.get(Coin.QUARTER)-1;
                purse.put(Coin.QUARTER, numQ);
                penny = penny - 25;
                this.quarters--;
                this.numCoins--;
            } else if (penny >= 10 && penny < 25) {
                int numD = purse.get(Coin.DIME)-1;
                purse.put(Coin.DIME, numD);
                penny = penny - 10;
                this.dimes--;
                this.numCoins--;
            } else if (penny >= 5 && penny < 10) {
                int numN = purse.get(Coin.NICKEL)-1;
                purse.put(Coin.NICKEL, numN);
                penny = penny - 5;
                this.nickels--;
                this.numCoins--;
            } else if (penny >= 1 && penny < 5) {
                int numP = purse.get(Coin.PENNY)-1;
                purse.put(Coin.PENNY, numP);
                penny = penny - 1;
                this.pennies--;
                this.numCoins--;
            }
        }
    }
    
    //get value as BigDecimal
    public BigDecimal getValueBigDecimal() {
        return BigDecimal.valueOf(totalValue/100);
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
    public int getTotal() {
        return totalValue;
    }

    public void setTotal(int total) {
        this.totalValue = total;
    }

    //get change string format
    public String getChangeString() {
        String ret = String.valueOf(this.totalValue / 100);
        return ret;
    }
    
    //get change with coin values
    public String getChangeFullString() {
        return "[Quarters] (" + this.quarters + ") [Dimes] (" + this.dimes + ") [Nickels] (" + this.nickels + ") [Pennies] (" + this.pennies + ")";
    }
}

//        while(penny > 0) {
//            if(penny >= 25) {
//                purse[numCoins] = Coin.QUARTER;
//                penny = penny - 25;
//                this.quarters++;
//                this.numCoins++;
//            } else if(penny >= 10 && penny < 25) {
//                purse[numCoins] = Coin.DIME;
//                penny = penny - 10;
//                this.dimes++;
//                this.numCoins++;
//            } else if(penny >= 5 && penny < 10) {
//                purse[numCoins] = Coin.NICKEL;
//                penny = penny - 5;
//                this.nickels++;
//                this.numCoins++;
//            } else if(penny >= 1 && penny < 5) {
//                purse[numCoins] = Coin.PENNY;
//                penny = penny - 1;
//                this.pennies++;
//                this.numCoins++;
//            }
//        }
