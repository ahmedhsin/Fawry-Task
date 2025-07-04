package Classes;

import java.util.ArrayList;
import java.util.List;

import Interfaces.ShipingService;
import Interfaces.Shippable;

public class HomeShippingService implements ShipingService {

    List<Product> items = new ArrayList<Product>();

    public HomeShippingService(List<Product>items){
        this.items = items;
    }
    
    @Override
    public String getName() {
        return "Home Shipping";
    }

    @Override
    public double getWeight() {
        double total = 0;
        for (Product i : items){
            Shippable item = (Shippable) i;
            total += item.getWeight();
        }
        return total;
    }
    
}
