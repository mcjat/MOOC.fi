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
