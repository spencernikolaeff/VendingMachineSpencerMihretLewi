/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vendingmachine.ui;

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
        io.print("1. List drink");
        io.print("2. View balance");
        io.print("3. View drink ");
        io.print("4. Enter Money");
        io.print("5. Purchase drink ");
        io.print("0. Exit");

        return io.readInt("Please select from the above choices.", 0, 5);
    }
    public String listTheProduct() {
        return io.readString("Please enter the product list :"); 
        
    }
    public String listTheprice() {
        return io.readString("Please enter the product price :"); 
        
    }
    
}
