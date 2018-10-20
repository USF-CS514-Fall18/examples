package staticKeyword;

/** The class demonstrates the use of a static variable and shows how to override finalize.
 * However, overriding finalize is a bad practice - since we don't know if and when
 * it will be invoked! */
public class MartianUsesFinalized {
    private String name;
    private static int numMartians = 0; // total number of Martian objects created

    /**
     * Constructor for class Martian
     * @param name name of this alien
     */
    public MartianUsesFinalized(String name) {
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


    @Override
    /** From class Object. Is called right before Garbage collector
     * deletes the object. But we don't know when it will be called
     * (actually may not get called at all).
     * And it's NOT a good practice to use finalize.
     */
    public void finalize() {
        //System.out.println("One less...");
        numMartians--;
    }

}
