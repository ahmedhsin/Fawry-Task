package Classes;

import java.time.LocalDate;

import Interfaces.Expireable;

public class ExpireableProduct extends Product implements Expireable {

    private LocalDate expiryDate;
    public ExpireableProduct(String name, double price, int quantity, LocalDate expireDate) {
        super(name, price, quantity);
        this.expiryDate = expireDate;
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
