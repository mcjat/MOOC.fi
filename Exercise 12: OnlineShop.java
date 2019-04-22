//online shop interface; new items may be added if given a name, price, and amount in stock; items may be sold from shop

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        // write some test code here
    Storehouse store = new Storehouse();
    store.addProduct("coffee", 5, 10);
    store.addProduct("milk", 3, 5);
    store.addProduct("milkbutter", 2, 55);
    store.addProduct("bread", 7, 8);

    Shop shop = new Shop(store, new Scanner(System.in));
    shop.manage("Pekka");
    }
}


import java.util.*;
public class Storehouse {

    private Map<String, Integer> priceList;
    private Map<String, Integer> stockList;
    public Storehouse(){
        priceList = new HashMap<String, Integer>();
        stockList = new HashMap<String, Integer>();
    }
    
    public void addProduct(String product, int price, int stock){
        this.priceList.put(product, price);
        this.stockList.put(product, stock);
    }
    
    public int price(String product){
        if(this.priceList.get(product) != null){
            return this.priceList.get(product);
        }
        return -99;
    }
    
    public int stock(String product){
        if(this.stockList.get(product) != null){
            return this.stockList.get(product);
        }
        return 0;
    }
    
    public boolean take(String product){
        if(this.stock(product) !=0){
            int newStock = this.stockList.get(product)-1;            
            this.stockList.remove(product);
            this.stockList.put(product, newStock);
            return true;
        }
        return false;
    }
    
    public Set<String> products(){
        Set<String> listOfProducts = new HashSet<String>();
        for (String i : this.priceList.keySet()){
            listOfProducts.add(i);
        }
        return listOfProducts;       
    }
            
          
}


public class Purchase {
    
    private String product;
    private int amount;
    private int unitPrice;
            
    public Purchase(String product, int amount, int unitPrice) {
        this.amount = amount;
        this.product = product;
        this.unitPrice = unitPrice;
    }
    
    public int price(){
        return this.amount*this.unitPrice;
    }
    
    public void increaseAmount(){
        this.amount++;
    }
    
    public String toString(){
        return this.product + ": " + this.amount;
    }
}


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


import java.util.Scanner;
public class Shop {
    

    private Storehouse store;
    private Scanner reader;

    public Shop(Storehouse store, Scanner reader) {
        this.store = store;
        this.reader = reader;
    }

    // the method to deal with a customer in the shop
    public void manage(String customer) {
        ShoppingBasket basket = new ShoppingBasket();
        System.out.println("Welcome to our shop " + customer);
        System.out.println("below is our sale offer:");

        for (String product : store.products()) {
            System.out.println( product );
        }

        while (true) {
            System.out.print("what do you want to buy (press enter to pay):");
            String product = reader.nextLine();
            if (product.isEmpty()) {
                break;
            }

            // here, you write the code to add a product to the shopping basket, if the storehouse is not empty
            // and decreases the storehouse stocks
            // do not touch the rest of the code!
            if(this.store.take(product)){                
                basket.add(product, store.price(product));
            }   
        }

        System.out.println("your purchases are:");
        basket.print();
        System.out.println("basket price: " + basket.price());
    }
    
}
