package threads;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

/** Two threads will count the number of lines of code in two different files
 *  at the same time  (one thread per file).
 */
public class LOCCalculatorSolutionModified {
    private int totalCount = 0;

    public class LOCWorker extends Thread {
        private String filename;
        //private int count = 0;

        public LOCWorker(String filename) {
            this.filename = filename;
        }

        //public synchronized void incrementCounter() {
          //  .totalCount += 1;
        //}
        @Override
        public void run() {
            //count = 0;
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line  = br.readLine()) != null) {
                    // note: this is not a good way to count lines of code;
                    // For instance, it won't count a line if it has a *. But the
                    // main point of this exercise is multithreading, not good LOC
                    if ((!line.trim().isEmpty()) && !line.trim().startsWith("/") && (!line.trim().contains("*"))) {
                        //count++;
                        incrementTotalCount();
                    }
                }
            }
            catch (IOException e) {
                System.out.println(e);
            }
        }

        /**
         * Returns count
         * @return
         */
         /*public int getCount() {
            return count;
        } */
    }

    public synchronized int getTotalCount() {
        return totalCount;
    }

    public synchronized void incrementTotalCount() {
        totalCount++;
    }


    public static void main(String[] args) {
        LOCCalculatorSolutionModified calc = new LOCCalculatorSolutionModified();
        System.out.println(Paths.get(".").toAbsolutePath().toString());
        Thread t1 = calc.new LOCWorker("./src/threads/PrintTaskExample.java");
        t1.start();
        Thread t2 = calc.new LOCWorker("./src/threads/PrintTaskExampleWithJoin.java");
        t2.start();
        try {
            t1.join();
            t2.join();
            //System.out.println(((LOCWorker) t1).getCount());
            //System.out.println(((LOCWorker) t2).getCount());
            System.out.println(calc.getTotalCount());
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }


    }
}
