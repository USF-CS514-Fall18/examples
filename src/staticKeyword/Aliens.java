package staticKeyword;

/** The driver class for class Martian */
public class Aliens {
    public static void main(String[] args) {
        Martian m1 = new Martian("beebeesfqpjfq");
        m1.dealWithEnemy();

        Martian m2 = new Martian("tatadam-tatadam-tatadam-tatadam");
        m2.dealWithEnemy();
        Martian m3 = new Martian("yammi,yammi,yammi");
        m1.dealWithEnemy();
        m2.dealWithEnemy();
        m3.dealWithEnemy();
        System.out.println(System.lineSeparator() + "Total number of martians: " + Martian.getNumMartians());

    }
}
