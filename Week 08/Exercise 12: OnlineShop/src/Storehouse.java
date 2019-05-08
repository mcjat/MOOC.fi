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
