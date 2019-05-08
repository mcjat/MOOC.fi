package boxes;
import java.util.*;

public class BlackHoleBox extends Box{
    private Collection<Thing> inBox;
    public BlackHoleBox(){
        this.inBox = new ArrayList<Thing>();
    }
    
    @Override
    public void add(Thing thing) {
       this.inBox.add(thing);
    }

    @Override
    public boolean isInTheBox(Thing thing) {
       return false;
    }
}
