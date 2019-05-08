package containers;

public class ProductContainerRecorder extends ProductContainer{    
    private ContainerHistory history;    
    public ProductContainerRecorder(String productName, double capacity, double initialVolume) {
        super(productName, capacity);        
        this.history = new ContainerHistory();
        this.addToTheContainer(initialVolume);
    }
    
    public String history(){
        return this.history.toString();
    }
    
    @Override
    public void addToTheContainer(double amount){
        super.addToTheContainer(amount);
        this.history.add(super.getVolume());
    }
    
    @Override
    public double takeFromTheContainer(double amount){
        double holder = super.takeFromTheContainer(amount);
        this.history.add(super.getVolume());
        return holder;
    }
    
    public void printAnalysis(){
        System.out.println("Product: " + super.getName() + 
                "\nHistory: " + this.history() + 
                "\nGreatest product amount: " + this.history.maxValue() + 
                "\nSmallest product amount: " + this.history.minValue() + 
                "\nAverage: " + this.history.average() + 
                "\nGreatest change: " + this.history.greatestFluctuation() + 
                "\nVariance: " + this.history.variance());
    }
}
