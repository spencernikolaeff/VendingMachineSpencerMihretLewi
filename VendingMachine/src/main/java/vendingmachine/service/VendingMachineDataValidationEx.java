package vendingmachine.service;

public class VendingMachineDataValidationEx extends Exception {
    public VendingMachineDataValidationEx(String message) {
        super(message);
    }

    public VendingMachineDataValidationEx(String message, Throwable cause) {
        super(message, cause);
    }
}
