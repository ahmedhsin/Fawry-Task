package Classes;

import java.time.LocalDate;

import Interfaces.Expireable;
import Interfaces.Shippable;

public class ExpireableShippableProduct extends Product implements Expireable, Shippable {
    private double weight;
    private LocalDate expiryDate;

    public ExpireableShippableProduct(String name, double price, int quantity, double weight, LocalDate expiryDate) {
        super(name, price, quantity);
        this.weight = weight;
        this.expiryDate = expiryDate;
    }
    
    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }
    
        @Override
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
}
