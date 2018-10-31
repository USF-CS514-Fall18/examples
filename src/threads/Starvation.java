package threads;

public class Starvation {

    public static class Worker implements Runnable {
        private String name;
        public Worker(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            synchronized (Worker.class) {
                while (true) {
                    System.out.println("Thread " + name + " is working");


                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Worker("1"));
        Thread t2 = new Thread(new Worker("2"));
        Thread t3 = new Thread(new Worker("3"));
        t1.start();
        t2.start();
        t3.start();

    }
}
