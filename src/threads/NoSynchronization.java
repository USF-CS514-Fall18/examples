package threads;

/** Demonstrates that without synchronization, when two
 * threads modify the same data, we get a race condition (the result depends on
 * the sequence of executions and might change every time we run the program.
 */
public class NoSynchronization {
    private int x = 0;

    /**
     * Addition worker increments x. Note that x is a shared variable between
     * AdditionWorker and SubtractionWorker.
     */
    private class AdditionWorker implements Runnable {
        public void run() {
            for (int i = 0; i < 1000; i++)
                 x++;
        }
    }

    /**
     * Subtraction worker decrements x. Note that x is a shared variable between
     * AdditionWorker and SubtractionWorker.
     */
    private class SubtractionWorker implements Runnable {
        public void run() {
            for (int i = 0; i < 1000; i++)
                x--;
        }
    }

    /** Creates two threads: one for AdditionWorker, one for SubstractionWorker
     *  and starts and joins them.
     *  Prints x at the end. Result may change every time you run the program.
     *  This is the wrong way to use threads!
     * @throws InterruptedException
     */
    public void createThreads() throws InterruptedException {
        Thread t1 = new Thread(new AdditionWorker());
        Thread t2 = new Thread(new SubtractionWorker());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        if (x != 0)
            System.out.println("x = " + x);
    }

    public static void main(String[] args) {
        try {
            NoSynchronization ns = new NoSynchronization();
            //for (int i = 0; i < 100000; i++) {
                ns.createThreads();
            //}
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }
    }

}
