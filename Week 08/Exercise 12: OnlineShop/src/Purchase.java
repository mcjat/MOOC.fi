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
