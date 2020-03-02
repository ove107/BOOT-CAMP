package JavaMultithreading;

import java.util.HashMap;
import java.util.SortedMap;

public class RunnerExtendRunnable implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("Hello: " + i + " Thread: " + Thread.currentThread().getName());

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    class ApplicationRunnable {

        public static void main(String[] args) {
            Thread thread1 = new Thread(new RunnerExtendRunnable());
            Thread thread2 = new Thread(new RunnerExtendRunnable());
            thread1.start();
            thread2.start();
        }

    }