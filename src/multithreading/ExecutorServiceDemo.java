package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class App implements Runnable {
    int id;

    App(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            System.out.println("APP Id: " + id);
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class ExecutorServiceDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5; i++) {
            executorService.submit(new App(i));
        }

        executorService.shutdown();

        System.out.println("All submitted....");

        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All completed.....");
    }

}
