package multithreading;

public class SynchronizedDemo {
    int count = 0;

    public static void main(String[] args) {
        SynchronizedDemo obj = new SynchronizedDemo();
        obj.run();
    }

    private void run() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    increment();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count: " + count);
    }

    private synchronized void increment() {
        count++;
    }

}
