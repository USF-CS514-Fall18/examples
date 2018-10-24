package threads;

import java.nio.file.Paths;

/** Uses two threads to count the total number of lines of code in all files in a given directory. */
public class LOCCalculatorModified {

    private volatile int totalCount = 0;

    /** Counts the lines of code in a given .java file - does not count a line
     * if it is empty, or if it starts with // or if it contains *
     * (Note: this is a very primitive algorithm for deciding
     * if the line has code or not).
     */
    public static class LOCWorker extends Thread {
        // FILL IN CODE: add instance variables as needed

        LOCWorker(String filename) {
            // FILL IN CODE
        }

        @Override
        public void run() {
            // FILL IN CODE

        }

        public int getCount() {
            // FILL IN CODE: return count of the lines of code

            return 0;
        }

    }

    public static void main(String[] args) {
        System.out.println(Paths.get(".").toAbsolutePath().toString());
        Thread t1 = new LOCWorker("./src/threads/PrintTaskExample.java");
        Thread t2 = new LOCWorker("./src/threads/PrintTaskExampleWithJoin.java");
        // FILL IN CODE:
        // t1 and t1 should compute the number of lines of code in the given file

        // Print the result once threads t1 and t2 finished their job
    }
}
