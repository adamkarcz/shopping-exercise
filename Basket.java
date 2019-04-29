package basket;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Basket {
    private final String name;
    private final Map<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list = new TreeMap<>();
    }

    public int reserveToBasket(StockItem item, int quantity){
        if ((item != null) && (quantity > 0)){
            int inBasket = list.getOrDefault(item, 0);
            list.put(item, inBasket + quantity);

            return inBasket;
        }
        return 0;
    }

    public int unReserveToBasket(StockItem item, int quantity){
        if ((item != null) && (quantity > 0)){
            int inBasket = list.getOrDefault(item, 0);
            list.put(item, inBasket - quantity);

            return inBasket;
        }
        return 0;
    }


    public void basketCheckOut(){
        double totalCost = 0.0;
        for (Map.Entry<StockItem, Integer> item : list.entrySet()){
            item.getKey().checkOut(item.getValue());
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        System.out.println("\nBasket: " + name + " checked out.\nTo pay: " + totalCost + " $");
        this.list.clear();
    }


    public Map<StockItem, Integer> Items(){
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nShopping basket " + name + " contains " + list.size() + ((list.size() ==1) ? " item" : " items") + "\n";
        double totoalCost = 0.0;
        for (Map.Entry<StockItem, Integer> item : list.entrySet()){
            s = s + item.getKey() + ". " + item.getValue() + " reserved in basket\n";
            totoalCost += item.getKey().getPrice() * item.getValue();
        }
        return s + "Total cost " + totoalCost;
    }
}
