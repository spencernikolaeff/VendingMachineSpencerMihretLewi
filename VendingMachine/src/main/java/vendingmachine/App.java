/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vendingmachine;

import vendingmachine.controller.VendingMachineController;
import vendingmachine.dao.VendingMachineDaoEx;

/**
 *
 * @author 17202
 */
public class App {
    public static void main(String[] args) throws VendingMachineDaoEx {
        VendingMachineController controller = new VendingMachineController();
        controller.run();
    }
}
