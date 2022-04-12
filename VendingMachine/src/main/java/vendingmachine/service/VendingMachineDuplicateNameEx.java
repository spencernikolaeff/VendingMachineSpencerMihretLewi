package vendingmachine.service;

public class VendingMachineDuplicateNameEx extends Exception {

    public VendingMachineDuplicateNameEx(String message) {
        super(message);
    }

    public VendingMachineDuplicateNameEx(String message, Throwable cause) {
        super(message, cause);
    }
}
