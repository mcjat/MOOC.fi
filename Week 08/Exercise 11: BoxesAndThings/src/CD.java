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
