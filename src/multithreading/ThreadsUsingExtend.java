package multithreading;


class AppExtend extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            try {
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadsUsingExtend {
    public static void main(String[] args) {
        AppExtend app = new AppExtend();
        app.start();
    }
}
