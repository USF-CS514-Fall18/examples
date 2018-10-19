package exceptions;

import inheritanceExercises.Human;

import java.util.ArrayList;
import java.util.List;

/** The Driver class for Creature, Alien and Human */
public class SpaceCreatures {
    public static void main(String[] args) {
        try {
            Alien a1 = new Alien("qghbp", "Venus");
            a1.speak();

            Alien a2 = new Alien("Vjapjvp", "Mars");
            a2.speak();

            Alien a3 = new Alien("BOO", "Saturn");
            a3.speak();
        }
        catch(InvalidAlienGreetingException e) {
            System.out.println(e);
        }

    }
}
