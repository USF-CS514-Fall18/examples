package staticKeyword;

/** The driver class for class Martian.
 *  Shows:
 *  1) How behavior of dealWithEnemy method changes depending on how
 *     many Martian objects exist.
 *  2) Shows that any Martian can change the slogan, and all other martians
 *     will see that change (since slogan is a static variable)
 */
public class Aliens {
    public static void main(String[] args) {
        Martian m1 = new Martian("beebeesfqpjfq");
        m1.dealWithEnemy();

        Martian m2 = new Martian("tatadam-tatadam-tatadam-tatadam");
        m2.dealWithEnemy();
        Martian m3 = new Martian("yammi,yammi,yammi");
        System.out.println(System.lineSeparator() + "Total number of martians: " + Martian.getNumMartians());

        m1.dealWithEnemy();
        m2.dealWithEnemy();
        m3.dealWithEnemy();

        System.out.println("m1 changes the slogan; everybody sees this change: ");
        m1.changeSlogan("Mars rocks!");
        System.out.println(Martian.getSlogan());
        System.out.println(m1.getSlogan());
        System.out.println(m2.getSlogan());
        System.out.println(m3.getSlogan());

        System.out.println();
        System.out.println("m3 changes the slogan; everybody sees this change: ");
        m3.changeSlogan("We love Mars!");
        System.out.println(Martian.getSlogan());
        System.out.println(m3.getSlogan());
        System.out.println(m1.getSlogan());
        System.out.println(m2.getSlogan());

    }
}
