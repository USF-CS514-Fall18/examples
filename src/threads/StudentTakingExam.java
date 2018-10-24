package threads;

/**
 * Exam example - threads work on exam problems until the timer thread
 * says to stop; uses volatile
 */
public class StudentTakingExam extends Thread {

    public static final int TEN_SECONDS = 10000;
    public static volatile boolean finished = false;

    public void run() {
       // FILL IN CODE

    }

    /**
     * The main thread is the "timer" thread in this example.
     * @param args command line args
     */
    public static void main(String[] args) {
        StudentTakingExam student1 = new StudentTakingExam();
        StudentTakingExam student2 = new StudentTakingExam();
        student1.start();
        student2.start();
        // FILL IN CODE
    }
}