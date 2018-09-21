package recursion;

/** SolveTowers.java       Author: Lewis/Loftus
 *  Demonstrates recursion.
 */
public class SolveTowers
{
    /** Creates a TowersOfHanoi puzzle and solves it.
     *
     * @param args command line arguments - not used in this example
     */
    public static void main (String[] args) {
        TowersOfHanoi towers = new TowersOfHanoi (3);
        towers.solve();
    }
}
