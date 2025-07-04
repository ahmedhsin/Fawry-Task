import Classes.Product;
import Classes.ShippableProduct;
import Classes.User;
import Exceptions.CartEmptyException;
import Exceptions.ExpiredItemException;
import Exceptions.InsufficientBalanceException;
import Exceptions.InsufficientQuantityException;
import Exceptions.OutOfStockException;
import Interfaces.Shippable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Classes.Cart;
import Classes.ExpireableProduct;
import Classes.ExpireableShippableProduct;
import Classes.HomeShippingService;
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

        checkout(customer, cart);
    }


    public static void checkout(User customer, Cart cart) throws InsufficientBalanceException, CartEmptyException{
        if(cart.getItems().isEmpty()){
            throw new CartEmptyException();
        }
        List<Product> shippedProducts =  new ArrayList<Product>();
        System.out.println("** Shipment notice **");
        double totalWeight = 0;
        for(var item : cart.getItems().entrySet()){
            Product product = item.getKey();
            if (product instanceof Shippable){
                Shippable shipItem = (Shippable) product;
                Integer quantity = item.getValue();
                double weight = shipItem.getWeight();
                totalWeight += weight * quantity;
                System.out.println(String.format("%-1dx %-14s %s", quantity, product.getName(), weight * quantity));
                //wierd code but explained in the assumptions file
                for(int i = 0; i< quantity; i++){
                    shippedProducts.add(product);
                }
            }
        }
        System.out.println("Total package weight "+ totalWeight/1000 +"kg");
        System.out.println();
        System.out.println("** Checkout receipt **");
        double subtotal = 0;
        for(var item : cart.getItems().entrySet()){
            Product product = item.getKey();
            Integer quantity = item.getValue();
            double price = product.getPrice();
            subtotal += price * quantity;
            System.out.println(String.format("%-1dx %-14s %s", quantity, product.getName(), price * quantity));
        }
        System.out.println("-------------------------");
        System.out.println(String.format("SubTotal %-14s", subtotal));
        double totalShipping = (totalWeight * 0.5) / 10;
        System.out.println(String.format("Shipping %-14s", totalShipping));
        double total = subtotal + totalShipping;
        System.out.println(String.format("Amount %-14s", total));
        System.out.println();

        customer.decreaseBalance(total);
        System.out.println(String.format("Customer Remaining Balance %-14s", customer.getBalance()));
        System.out.println();

        cart.clear();

        HomeShippingService homeService = new HomeShippingService(shippedProducts);
    }

}
