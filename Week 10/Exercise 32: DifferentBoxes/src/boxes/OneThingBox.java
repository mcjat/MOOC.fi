package boxes;

public class OneThingBox extends Box{
    private Thing thing;
    private boolean boxFull;
    
    public OneThingBox(){
        this.boxFull = false;
    }
    
    @Override
    public void add(Thing thing) {
      if(!this.boxFull){
          this.thing = thing;
          this.boxFull = true;
      }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        if(this.thing == null){
            return false;
        }
       return this.thing.equals(thing);
    }    
}
