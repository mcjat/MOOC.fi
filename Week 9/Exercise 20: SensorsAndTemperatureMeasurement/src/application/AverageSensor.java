package application;
import java.util.List;
import java.util.ArrayList;
public class AverageSensor implements Sensor {
    private List<Integer> readings;
    private ArrayList<Sensor> sensors;
    
    public AverageSensor(){
        sensors = new ArrayList<Sensor>();
        readings = new ArrayList<Integer>();
    }
    
    public void addSensor(Sensor additional){
        this.sensors.add(additional);
    }
    
    public List<Integer> readings(){
        return readings;
    }
    
    @Override
    public boolean isOn() {
        for(Sensor s : this.sensors){
            if (!s.isOn()){
                return false;
            }            
        }
        return true;
    }

    @Override
    public void on() {
        for(Sensor s: this.sensors){
            s.on();
        }
    }

    @Override
    public void off() {
        if(this.isOn()){
            this.sensors.get(0).off();
        }
    }

    @Override
    public int measure() {
        if(this.sensors.isEmpty()){
            throw new IllegalStateException("No sensors, please add at least one");
        }
        int averageReading =0;
        for(Sensor s: this.sensors){
            averageReading += s.measure();
        }
        this.readings.add(averageReading/this.sensors.size());
        return (averageReading/(this.sensors.size()));
    }
}
