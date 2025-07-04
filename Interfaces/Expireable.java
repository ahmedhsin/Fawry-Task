package Interfaces;

import java.time.LocalDate;

public interface Expireable {

    LocalDate getExpiryDate();
    void setExpiryDate(LocalDate expiryDate);
}