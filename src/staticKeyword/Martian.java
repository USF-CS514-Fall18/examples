package staticKeyword;

/** The class demonstrates the use of a static variable */
public class Martian {
    private String name;
    private static int numMartians = 0; // total number of Martian objects created

    private static String slogan; // slogan of Martians.

    /**
     * Constructor for class Martian
     * @param name name of this alien
     */
    public Martian(String name) {
        this.name = name;
        numMartians++;
    }

    /**
     * Getter for the name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * How a Martian deals with an enemy:
     * if there are less than 3 martians, hide
     * if there are 3 or more martians total, then fight
     */
    public void dealWithEnemy() {
        System.out.print("My name is " + name + ". ");
        if (numMartians < 3) {
            System.out.println(" Where are my friends? I better hide");
        }
        else {
            System.out.println(" There are quite a few of us, let's fight!");
        }
    }

    /**
     * Changes the slogan of Martians. Static method.
     * @param newSlogan new slogan
     */
    public static void changeSlogan(String newSlogan) {
        slogan = newSlogan;
    }

    public void setSlogan(String sl) {
        slogan = sl;
    }

    /**
     * Returns the slogan of martians - static method
     * @return slogan
     */
    public static String getSlogan() {
        return slogan;

    }

    /**
     * Returns the total number of Martians
     * @return number of Martians
     */
    public static int getNumMartians() {

        return numMartians;
    }

}
