package inheritance;

/** Messages.java
 * @author: Lewis/Loftus
 * Demonstrates the use of an overridden method.
 */
public class Messages {

    /** Creates two objects: one of class Thought, and one
     *  of class Advice and invokes the message method in each.
     *
     * @param args command line arguments - not used in this example
     */
    public static void main (String[] args)
    {
        Thought parked = new Thought();
        Advice dates = new Advice();

        parked.message();

        dates.message();  // overridden
    }
}

