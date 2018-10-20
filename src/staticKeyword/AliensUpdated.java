package staticKeyword;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** The driver class for class Martian */
public class AliensUpdated {
    public static void main(String[] args) {
        List<MartianUpdated> martians = new ArrayList();
        String name = "Name";
        Random r = new Random();
        for (int i = 0; i < 30; i++) {
            martians.add(new MartianUpdated(name + i));
            //System.out.println(martians.get(i));
        }

        System.out.println(MartianUpdated.getNumMartians());

        for (int k = 0; k < 5; k++) {
            int index = r.nextInt(martians.size());
            MartianUpdated m = martians.get(index);
            m.destroy();
            martians.remove(m);
        }
        System.out.println(MartianUpdated.getNumMartians());
       /* for (int i = 0; i < martians.size(); i++) {
            System.out.println(martians.get(i));
        } */

    }
}
