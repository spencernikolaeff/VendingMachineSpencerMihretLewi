/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vendingmachine.dto;

/**
 *
 * @author 17202
 */
public class Change {
    
    //attributes (denominations of coins)
    private int quarters;
    private int dimes;
    private int nickels;
    private int pennies;
    
    //constructor
    public Change(int penny) {
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
}
