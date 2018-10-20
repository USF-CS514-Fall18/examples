package staticKeyword;

/** The class demonstrates the use of a static variable */
public class MartianUpdated {
    private String name;
    private static int numMartians = 0; // total number of Martian objects created
    private boolean isAlive = true;

    /**
     * Constructor for class Martian
     * @param name name of this alien
     */
    public MartianUpdated(String name) {
        this.name = name;
        this.isAlive = true;
        numMartians++;
    }

    /**
     * Getter for the name
     * @return
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " " + isAlive + System.lineSeparator();
    }

    /**
     * Is this Martian alive?
     * @return whether it's alive
     */
    public boolean isAlive() {
        return isAlive;
    }

    /**
     * Destroys this martian.
     */
    public void destroy() {
        this.isAlive = false;
        numMartians--;
    }

    /**
     * How a Martian deals with an enemy:
     * if there are
     */
    public void dealWithEnemy() {
        System.out.print("My name is " + name + ". ");
        if (numMartians < 900000) {
            System.out.println(" Where are my friends? I better hide");
        }
        else {
            System.out.println(" There are quite a few of us, let's fight!");
        }
    }


    public static int getNumMartians() {

        return numMartians;
    }

}
