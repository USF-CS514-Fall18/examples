package threads;


import java.util.Random;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

/**
 * Class demonstrating the use of the BlockingQueue by two threads: Producer and Consumer
 * From http://tutorials.jenkov.com/java-concurrency/blocking-queues.html
 */
public class BlockingQueueExample {
    //private static final Logger log = LogManager.getRootLogger();

    /** Consumer thread removes elements from the queue */
    public static class Consumer implements Runnable {
        private BlockingQueue queue;

        Consumer(BlockingQueue q) {
            queue = q;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    int elem = queue.dequeue();
                    //log.debug("Removing "+ elem);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /** Producer thread adds elements to the queue */
    public static class Producer implements Runnable {
        private BlockingQueue queue;
        private Random r;

        Producer(BlockingQueue q) {
            queue = q;
            r = new Random();
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    int elem = r.nextInt(10);
                    queue.enqueue(elem);
                    //System.out.println("Inserting " + elem);
                    //log.debug("Inserting "+ elem);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
        //BlockingQueue q = new BlockingQueue(5, log);
        BlockingQueue q = new BlockingQueue(5);
        Thread thread1 = new Thread(new Consumer(q));
        Thread thread2 = new Thread(new Producer(q));

        thread1.start();
        thread2.start();
    }
}