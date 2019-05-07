package moving.logic;

import java.util.*;
import moving.domain.*;
public class Packer {    
    private int boxesVolume;
    
    public Packer(int boxesVolume){
        this.boxesVolume = boxesVolume;
    }
    
    public List<Box> packThings(List<Thing> things){
        List<Box> allBoxes = new ArrayList<Box>();
        int needNewBox = 1;
        for(Thing t: things){
            for(Box b: allBoxes){
                if (b.addThing(t)){
                    needNewBox = 0;
                    break;
                }
            }
            if (needNewBox ==1){
                Box aBox = new Box(this.boxesVolume);
                aBox.addThing(t);
                allBoxes.add(aBox);
            }
            needNewBox =1;
        }
        return allBoxes;
    }
    
}
