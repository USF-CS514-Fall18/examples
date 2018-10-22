package threads;
/** A simple example demonstrating three threads (main, Thread1, Thread2).
 *  Shows how to create threads and how to start them.
 *  Also shows that operations of Thread1 and Thread2 can be "interleaved"
 *  since there is no synchronization.
 *  Run this program multiple times and observe what gets printed. */

public class PrintTaskExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(new PrintTask());
        t1.start();
        Thread t2 = new Thread(new PrintTask());
        t2.start();
        System.out.println("Done");
    }
}
