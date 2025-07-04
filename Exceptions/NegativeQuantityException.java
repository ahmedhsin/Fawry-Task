package Exceptions;

public class NegativeQuantityException extends Exception {
    public NegativeQuantityException(int quantity) {
        super("Quantity cannot be negative. Received: " + quantity);
    }
}