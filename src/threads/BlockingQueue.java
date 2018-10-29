package threads;

import java.util.LinkedList;

/** BlockingQueue example - demonstrates the use of wait() and notify().
 * From http://tutorials.jenkov.com/java-concurrency/blocking-queues.html
 */
public class BlockingQueue {
    private LinkedList<Integer> queue = new LinkedList<Integer>();
    private int capacity;


    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Waits until there is space in the queue, then adds an element to the queue
     * @param element the element to be added to the queue
     * @throws InterruptedException
     */
    public synchronized void enqueue(Integer element) throws InterruptedException {
        //System.out.println("Entering enqueue");
        while (queue.size() == capacity) {
            this.wait();
        }

        if (queue.isEmpty())
            this.notifyAll();

        queue.add(element);
        System.out.println("Inserting " + element); //should be using Logger instead

    }

    /**
     * Waits until the queue has something to dequeue, then dequeues it and returns the element.
     * @return the first element from the queue
     * @throws InterruptedException
     */
    public synchronized Integer dequeue() throws InterruptedException {
        //System.out.println("Entering dequeue: ");
        while (queue.isEmpty()) {
            this.wait();
            //System.out.println("Done waiting");
        }
        //System.out.println("Out of wait");
        if (queue.size() == capacity)
            this.notifyAll();

        Integer item = queue.remove();
        System.out.println("Removing " + item); // should be using Logger instead

        return item;
    }
}
