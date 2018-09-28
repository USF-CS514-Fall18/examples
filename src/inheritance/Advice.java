package inheritance;

/** Advice.java
 * @author: Lewis/Loftus
 *
 * Represents some thoughtful advice. Used to demonstrate the use
 *  of an overridden method.
 */
public class Advice extends Thought {

    /** Prints a message. This method overrides the parent's version. */
    @Override
    public void message() {
        System.out.println ("Warning: Dates in calendar are closer " +
                "than they appear.");

        System.out.println();
        super.message();  // explicitly invokes the parent's version
    }
}
