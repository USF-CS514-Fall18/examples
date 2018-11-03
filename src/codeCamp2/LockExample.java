package codeCamp2;

/** Problem 5 from the code camp 2. Lock example. */
public class LockExample {
    private Thread worker;
    private static Object staticLock = new Object(); // Note that lock is static
    private static int x = 0;

    public LockExample() {
        worker = new Worker(staticLock); // this lock will be shared by workers of demoA and demoB
        worker.start();
    }

    private class Worker extends Thread {
        private Object lock;
        public Worker(Object lock) {
            this.lock = lock;
        }
        @Override
        public void run() {
            synchronized(lock) { // only one worker at a time would be able to
                // execute this block of code
                for (int i = 0; i < 1000; i++)
                    x++;
                System.out.println(x);
            }
        }
    }

    public static void main(String[] args)  {
        LockExample demoA = new LockExample();
        LockExample demoB = new LockExample();
    }
}

