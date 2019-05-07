package moving;
import moving.domain.*;
import moving.logic.*;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        // test your program here
        List<Thing> things = new ArrayList<Thing>();
        things.add(new Item("passport", 2));
        things.add(new Item("toothbrash", 1));
        things.add(new Item("book", 4));
        things.add(new Item("circular saw", 8));
        things.add(new Item("circular sawa", 4));
        things.add(new Item("circular sawb", 2));
        things.add(new Item("circular sawc", 4));
        things.add(new Item("circular sawd", 5));
        things.add(new Item("circular sawe", 6));
        things.add(new Item("circular sawf", 2));        

        // we create a packer which uses boxes whose valume is 10
        Packer packer = new Packer(10);

        // we ask our packer to pack things into boxes
        List<Box> boxes = packer.packThings( things );

        System.out.println("number of boxes: "+boxes.size());

        for (Box box : boxes) {
            System.out.println("  things in the box: "+box.getVolume()+" dm^3");
            System.out.println(box.toString());
        }
        
    }
}
