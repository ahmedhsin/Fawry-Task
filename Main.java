import Classes.Product;
import Classes.ShippableProduct;
import Classes.User;
import Exceptions.CartEmptyException;
import Exceptions.ExpiredItemException;
import Exceptions.InsufficientBalanceException;
import Exceptions.InsufficientQuantityException;
import Exceptions.OutOfStockException;

import java.time.LocalDate;

import Classes.Cart;
import Classes.ExpireableProduct;
import Classes.ExpireableShippableProduct;
import Services.CheckoutService;
public class Main {
    public static void main(String[] args) throws InsufficientQuantityException, InsufficientBalanceException, CartEmptyException, OutOfStockException, ExpiredItemException {
        Product cheese = new ExpireableShippableProduct("Cheese", 100, 10, 250, LocalDate.of(2023, 11, 2));
        Product biscuts = new ExpireableShippableProduct("Biscuts", 150, 20, 100, LocalDate.of(2025, 7, 1));
        Product tv = new ShippableProduct("Tv", 3500, 20, 3000);
        Product scratchCard = new ExpireableProduct("ScratchCard", 50, 100, LocalDate.of(2027, 1, 1));
        User customer = new User(3200);
        Cart cart = new Cart();
        cart.add(scratchCard, 5);
        cart.add(cheese, 2);
        cart.add(tv, 10);

        CheckoutService.checkout(customer, cart);
    }


}
