package application;

public class ConstantSensor implements Sensor {    
    private int measurement;
    
    public ConstantSensor(int measurement){
        this.measurement = measurement;
    }

    @Override
    public boolean isOn() {
        return true;
        
    }

    @Override
    public void on() {        
    }

    @Override
    public void off() {        
    }

    @Override
    public int measure() {
        return this.measurement;
    }
}
