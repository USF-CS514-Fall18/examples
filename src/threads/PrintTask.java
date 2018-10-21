package threads;

public class PrintTask implements Runnable {
    public void run() {
        for (int i = 0; i < 3; i++)
            System.out.println(i);
    }
    public static void main(String[] args) {
        Thread t1 = new Thread(new PrintTask());
        t1.start();
        Thread t2 = new Thread(new PrintTask());
        t2.start();
        System.out.println("Done");
    }
}
