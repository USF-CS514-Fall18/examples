package staticKeyword;

/** The driver class for class Martian */
public class AliensUsesFinalized {
    public static void main(String[] args) {

        for (int i = 0; i < 1000000; i++) {
            MartianUsesFinalized m = new MartianUsesFinalized("My name");
            m = null;
        }

        System.out.println(MartianUsesFinalized.getNumMartians());
    }
}
