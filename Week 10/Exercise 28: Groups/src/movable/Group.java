package movable;
import java.util.*;

public class Group implements Movable{    
    private List<Movable> groupList;
    public Group(){
        groupList = new ArrayList<Movable>();
    }
    
    @Override
    public String toString(){
        String groupString = "";
        for(Movable m : this.groupList){
            groupString += m.toString() + "\n";
        }
        return groupString;
    }
    
    public void addToGroup(Movable movable){
        this.groupList.add(movable);
    }
    
    @Override
    public void move(int dx, int dy){
        for(Movable m : this.groupList){
            m.move(dx, dy);
        }
    }     
}
