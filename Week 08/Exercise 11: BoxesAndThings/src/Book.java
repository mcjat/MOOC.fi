public class Book implements ToBeStored {
    private String writer;
    private String name;
    private double weight;
    
    public Book(String writer, String name, double weight){
        this.name = name;
        this.weight = weight;
        this.writer = writer;
    }
    
    public double weight(){
        return this.weight;
    }
    
    public String toString(){
        return this.writer + ": " + this.name;
    }
}
