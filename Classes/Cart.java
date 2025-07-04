package Classes;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import Exceptions.ExpiredItemException;
import Exceptions.InsufficientQuantityException;
import Exceptions.OutOfStockException;
import Interfaces.Expireable;

public class Cart {
    private Map<Product, Integer> items;

    public Cart(){
        this.items = new HashMap<>();
    }

    public void add(Product item, int quantity) throws InsufficientQuantityException, OutOfStockException, ExpiredItemException{
        if (quantity <= 0) return;
        if (item instanceof Expireable){
            Expireable product = (Expireable) item;
            if (product.getExpiryDate().isBefore(LocalDate.now())) {
                throw new ExpiredItemException(item.getName(), product.getExpiryDate().toString());
            }

        }
        item.decreaseQuantity(quantity);
        Integer currentQuantity = this.items.getOrDefault(item, 0);
        this.items.put(item, currentQuantity + quantity);
    }

    public void remove(Product item, int quantity){
        if (quantity <= 0) return;
        Integer currentQuantity = this.items.getOrDefault(item, 0);
        if (currentQuantity - quantity <= 0){
            this.items.remove(item);
        }else{
            this.items.put(item, currentQuantity - quantity);
        }
        Integer newItemQuantity = item.getQuantity() + quantity;
        item.setQuantity(newItemQuantity);
    }

    public Map<Product, Integer> getItems(){
        return this.items;
    }

    public void clear(){
        this.items.clear();
    }

}
