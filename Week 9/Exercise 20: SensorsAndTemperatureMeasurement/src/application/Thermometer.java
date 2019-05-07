package application;
import java.util.Random;

public class Thermometer implements Sensor{    
    private boolean isOn;
    public Thermometer() {
        this.isOn = false;
    }

    @Override
    public boolean isOn() {
        return this.isOn;
    }

    @Override
    public void on() {
        this.isOn = true;
    }

    @Override
    public void off() {
        this.isOn = false;
    }

    @Override
    public int measure() {
        if (!this.isOn){
            throw new IllegalStateException("Thermometer is not on");
        }
        Random random = new Random();        
        return random.nextInt(60)-30;
    }  
}
