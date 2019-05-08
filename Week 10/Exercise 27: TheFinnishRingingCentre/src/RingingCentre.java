import java.util.*;

public class RingingCentre {
    private Map<Bird, List<String>> observationPlaces;
    public RingingCentre(){
        observationPlaces = new HashMap<Bird, List<String>>();
    }
    
    public void observe(Bird bird, String place){
        if(this.observationPlaces.get(bird) == null){
            this.observationPlaces.put(bird, new ArrayList<String>());
        }        
        List<String> birdLocs = this.observationPlaces.get(bird);
        birdLocs.add(place);
    }
    
    public void observations(Bird bird){
        int numObservations = 0;
        if (this.observationPlaces.get(bird) != null){
            numObservations = this.observationPlaces.get(bird).size();
        }
        System.out.println(bird + " observations: " + numObservations);
        if(this.observationPlaces.get(bird) != null){
            List<String> observationLocs = this.observationPlaces.get(bird);        
            for(String l : observationLocs){
                System.out.println(l);
            }
        }
    }
}
