package overloading;

/** This class has two overloaded messages: they have the same name
 *  but different parameters.
 */
public class OverloadingEx {
    public void disp(char c) {
        System.out.println(c);
    }

    public void disp(char c, int num) {
        System.out.println(c + " " + num);
    }
}
