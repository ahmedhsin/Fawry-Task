package Exceptions;

public class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(double total, double balance) {
        super("Insufficient balance: required " + total + ", but only " + balance + " is available.");
    }
}