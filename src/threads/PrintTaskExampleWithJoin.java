package threads;

/** Modification of PrintTaskExample  -
 *  because we called t1.join() and t2.join() inside main,
 *  the main thread will be blocked until t1 and t2 finish executing,
 *  so Done will always be printed at the end.
 *  Run the program multiple times and compare the output with PrintTaskExampleNoJoin */
public class PrintTaskExampleWithJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new PrintTask(), "Thread1");
        Thread t2 = new Thread(new PrintTask(), "Thread2");
        t1.start();
        t2.start();

        // main thread will wait for t1 and t2 to finish before printing Done
        // comment lines with join and see what happens.
        t1.join();
        t2.join();
        System.out.println("Done ");
    }
}
