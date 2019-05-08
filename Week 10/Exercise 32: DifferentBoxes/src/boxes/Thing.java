package boxes;

public class Thing {
    private String name;
    private int weight;

    public Thing(String name, int weight) {
        if(weight < 0){
            throw new IllegalArgumentException("Weight cannot be negative");
        }
        this.name = name;
        this.weight = weight;
    }

    public Thing(String name) {
        this(name, 0);
    }

    public String getName() {
        return name;
    }
    
    @Override
    public int hashCode(){
        return (int)name.hashCode() ;
    }   

    @Override
    public boolean equals(Object obj) {
        if(this.hashCode() == obj.hashCode()){
            return true;
        }
        return false;
    }

    public int getWeight() {
        return weight;
    }
}
