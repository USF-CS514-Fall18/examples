package threads;
/** A class that implements Runnable. run() method prints 1, 2, 3 */
public class PrintTask implements Runnable {
    public void run() {
        for (int i = 0; i < 3; i++)
            System.out.println(i);
    }
}
