package moving.domain;

public class Item implements Thing, Comparable<Item> {
    private String name;
    private int volume;
    
    public Item(String name, int volume){
        this.name = name;
        this.volume = volume;
    }
    
    public String getName(){
        return this.name;
    }
    
    @Override
    public int getVolume() {
        return this.volume;
    }    

    
    @Override
    public String toString(){
        return this.getName() + " (" + this.getVolume() + " dm^3)";
    }

    @Override
    public int compareTo(Item item) {
        if (this.getVolume() > item.getVolume()){
            return 1;
        }
        if (this.getVolume() == item.getVolume()){
            return 0;
        }
        return -1;
    } 
}
