package Exceptions;

public class CartEmptyException extends Exception {
    public CartEmptyException() {
        super("The cart is empty. Add items before proceeding.");
    }
}