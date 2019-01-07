package multithreading;

class AppImplements implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread " + i);
        }
    }
}

public class ThreadsUsingImplements {
    public static void main(String[] args) {
        Thread t1 = new Thread(new AppImplements());
        t1.start();
    }
}
