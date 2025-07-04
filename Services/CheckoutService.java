package Services;

import java.util.ArrayList;
import java.util.List;

import Classes.Cart;
import Classes.Product;
import Classes.User;
import Exceptions.CartEmptyException;
import Exceptions.InsufficientBalanceException;
import Interfaces.Shippable;

public class CheckoutService {
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
