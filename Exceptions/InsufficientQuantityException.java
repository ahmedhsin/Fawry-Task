package Exceptions;

public class InsufficientQuantityException extends Exception {
    public InsufficientQuantityException(int requested, int available) {
        super("Requested quantity (" + requested + ") exceeds available quantity (" + available + ").");
    }
}
