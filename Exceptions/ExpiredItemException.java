package Exceptions;

public class ExpiredItemException extends Exception {
    public ExpiredItemException(String itemName, String expiryDate) {
        super("The item '" + itemName + "' has expired on " + expiryDate + ".");
    }
}