import java.util.*;

public class ShoppingBasket {
    private Map<String, Purchase> basket;

    public ShoppingBasket(){
        basket = new HashMap<String, Purchase>();
    }

    public void add(String product, int price){
        if(this.basket.get(product) != null){
            this.basket.get(product).increaseAmount();
        }
        else{
            this.basket.put(product, new Purchase(product, 1, price));
        }
    }

    public int price(){
        int price = 0;
        for(String p : this.basket.keySet()){
            Purchase tempPurch = this.basket.get(p);
            price += tempPurch.price();
        }
        return price;
    }

    public void print(){
        for(String p : this.basket.keySet()){
            System.out.println(this.basket.get(p).toString());
        }
    }
}
