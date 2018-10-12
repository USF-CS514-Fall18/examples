package interfaces;

import java.util.Iterator;

/** Driver class for ToyBox */
public class ToyBoxExample {
    public static void main(String[] args) {
        ToyBox box = new ToyBox();
        box.add("bear");
        box.add("car");
        box.add("lego");
        box.add("puzzle");

        // Iterate over the toys using iterator explicitly
        Iterator<String> it = box.iterator();
        while (it.hasNext()) {
            String s = it.next();
            System.out.println(s);
        }
        System.out.println("");

        // another way to iterate over the toys if ToyBox implements Iterable:
        // Uses iterator implicitly
        //for (String toy: box) {
        //  System.out.println(toy);
        //}


    }
}
