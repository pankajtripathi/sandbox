### 1.  What is the difference between a process and a thread?

Both processes and threads are units of concurrency, but they have a fundamental difference: processes do not share a 
common memory, while threads do.   


### 2. How can you create a Thread instance and run it?   
```
        // method-1
        Thread thread1 = new Thread(() -> System.out.println("Inside runnable....."));
        thread1.start();
        
        // method-2
        class ThreadExtends extends Thread {
            @Override
            public void run() {
                System.out.println("Extend Thread......");
            }
        }
        
        class ThreadImplements implements Runnable {
            @Override
            public void run() {
                System.out.println("Implements Runnable.....");
            }
        }
        
        public class ThreadPrac {
            public static void main(String[] args) {
                ThreadExtends thread1 = new ThreadExtends();
                thread1.start();
                
                Thread thread2 = new Thread(new ThreadImplements());
                thread2.start();
            }
        }
``` 


### 3. What is the difference between the Runnable and Callable interfaces? How are they used?
The Runnable interface has a single run method. It represents a unit of computation that has to be run in a separate
thread. The Runnable interface does not allow this method to return value or to throw unchecked exceptions.

The Callable interface has a single call method and represents a task that has a value. 
That’s why the call method returns a value. It can also throw exceptions. Callable is generally used in 
ExecutorService instances to start an asynchronous task and then call the returned Future instance to get its value


### 4. What is a daemon thread, what are its use cases? How can you create a daemon thread?
A daemon thread is a thread that does not prevent JVM from exiting. When all non-daemon threads are terminated,
the JVM simply abandons all remaining daemon threads.   
```
        Thread daemon = new Thread(() -> {
            System.out.println("Daemon Thread...... ");
        });
        daemon.setDaemon(true);
        daemon.start();
```  

### 5. What is the meaning of a synchronized keyword in the definition of a method? 
The synchronized keyword before a block means that any thread entering this block has to acquire the monitor
(the object in brackets). If the monitor is already acquired by another thread, the former thread will enter
the BLOCKED state and wait until the monitor is released.
```
private int count = 0;

    private synchronized void increment() {
        count++;
    }

    private void app() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println(Thread.currentThread().getName());
                    increment();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 2000; i++) {
                    System.out.println(Thread.currentThread().getName());
                    increment();
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count "+ count);
    }

    public static void main(String[] args) {
        ThreadPrac obj = new ThreadPrac();
        obj.app();
    }
    
```


