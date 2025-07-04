package Exceptions;

public class OutOfStockException extends Exception {
    public OutOfStockException(String productName) {
        super("The product '" + productName + "' is currently out of stock.");
    }
}