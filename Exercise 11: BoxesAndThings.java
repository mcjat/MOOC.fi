// creates a box which can store objects which have interface ToBeStored, sample objects Book and CD included
// boxes may be stored inside of other boxes which have enough available capacity

public class Main {
    public static void main(String[] args) {
        Box box1 = new Box(10);
        Box box2 = new Box(20);

        box1.add( new Book("Fedor Dostojevski", "Crime and Punishment", 2) ) ;
        box1.add( new Book("Robert Martin", "Clean Code", 1) );
        box1.add( new Book("Kent Beck", "Test Driven Development", 0.7) );

        box2.add( new CD("Pink Floyd", "Dark Side of the Moon", 1973) );
        box2.add( new CD("Wigwam", "Nuclear Nightclub", 1975) );
        box2.add( new CD("Rendezvous Park", "Closer to Being Here", 2012) );

        System.out.println( box1 );
        System.out.println( box2 );
        System.out.println("Combine boxes");
        box2.add(box1);
        System.out.println( box2 );
        System.out.println("Escher box");
        box2.add(box2);
        System.out.println( box2 );
    }
    
}


public interface ToBeStored {
    double weight();   
}



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


public class CD implements ToBeStored {
    private final double weight;
    private String artist;
    private String title;
    private int yearPublished;
    
    public CD(String artist, String title, int yearPublished){
        this.weight =.1;
        this.artist = artist;
        this.title = title;
        this.yearPublished = yearPublished;
    }
    
    public double weight(){
        return this.weight;
    }
    
    public String toString(){
        return this.artist + ": " + this.title + " (" + this.yearPublished + ")";
    }
    
    
}


import java.util.ArrayList;
public class Box implements ToBeStored {
    private double maxWeight;    
    private ArrayList<ToBeStored> thingsInBox;
    
    public Box(double maxWeight){
        this.maxWeight = maxWeight;
        this.thingsInBox = new ArrayList<ToBeStored>();
    }
    
    public void add(ToBeStored toBeStored){
        if ((toBeStored.weight() + this.weight()) <= this.maxWeight){
            this.thingsInBox.add(toBeStored);
        }
    }
    
    public double weight(){
        double weight = 0.0;
        for(ToBeStored obj : this.thingsInBox){
            weight += obj.weight();
        }
        return weight;
    }
    
    public String toString(){
        return "Box: " + this.thingsInBox.size() + " things, total weight " 
                + this.weight() + " kg";
    }
}
