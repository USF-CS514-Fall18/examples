package nestedClasses;


import java.util.Comparator;

/** An example of an anonymous class. Shows a way to pass parameters to the object of the anonymous class.
 *  Anonymous classes can not have explicit constructors, so we discussed how to initialize objects. */
public class AnonymousClass {

    public static void main(String[] args) {

        // Option 1: use initializer:
        Comparator<Color> comp = new Comparator<Color>() {
            private boolean isCaseSensitive;
            Comparator<Color> init(boolean isCaseSensitive) {
                this.isCaseSensitive = isCaseSensitive;
                return this;
            }
            public int compare(Color s1, Color s2) {
                return s1.getColor().compareTo(s2.getColor());
            }
        }.init(false);


        // Option 2: Use final local variable
        final int n = 3;
        Thread threadOther  = new Thread() {

            @Override
            public void run() {
                // computes and outputs the factorial of num
                int res = 1;
                for (int i = 1; i <= n; i++) {
                    res *= i;
                }
                System.out.println(res);
            }
        };
        threadOther.start();

    }


}
