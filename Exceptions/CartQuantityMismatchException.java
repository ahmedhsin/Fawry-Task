package Exceptions;

public class CartQuantityMismatchException extends Exception {
    public CartQuantityMismatchException(int toRemove, int inCart) {
        super("Cannot remove " + toRemove + " items from cart. Only " + inCart + " items available.");
    }
}