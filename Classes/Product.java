package Classes;

import Exceptions.InsufficientQuantityException;
import Exceptions.OutOfStockException;

public class Product {
    private String name;
    private double price;
    private int quantity;
    public Product(String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public void decreaseQuantity(int quantity) throws InsufficientQuantityException, OutOfStockException{
        if (this.quantity == 0){
            throw new OutOfStockException(this.name);
        }
        if (this.quantity - quantity < 0){
            throw new InsufficientQuantityException(quantity, this.quantity);
        }
        this.quantity = quantity;
    }
}
