package threads;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

/** Two threads will count the number of lines of code in two different files
 *  at the same time  (one thread per file). Uses IBM WorkQueue.
 */
public class LOCCalculatorIBMWorkQueue {

    public static class LOCWorker extends Thread {
        private String filename;
        private int count = 0;

        LOCWorker(String filename) {
            this.filename = filename;
        }

        @Override
        public void run() {
            count = 0;
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line  = br.readLine()) != null) {
                    // note: this is not a good way to count lines of code;
                    // For instance, it won't count a line if it has a *. But the
                    // main point of this exercise is multithreading, not good LOC
                    if ((!line.trim().isEmpty()) && !line.trim().startsWith("/") && (!line.trim().contains("*"))) {
                        count++;
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
        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        System.out.println(Paths.get(".").toAbsolutePath().toString());
        WorkQueue wq = new WorkQueue(3);

        Runnable r1 = new LOCWorker("./src/threads/PrintTaskExample.java");
        wq.execute(r1);
        Runnable r2 = new LOCWorker("./src/threads/PrintTaskExampleWithJoin.java");
        wq.execute(r2);
        Runnable r3 = new LOCWorker("./src/threads/LockDemo.java");
        wq.execute(r3);

        wq.shutdown(); // do not accept any more jobs
        wq.awaitTermination(); // wait for all tasks to finish

        int totalCount = ((LOCWorker)r1).getCount() + ((LOCWorker)r2).getCount() + ((LOCWorker)r3).getCount();
        System.out.println(totalCount);


    }
}
