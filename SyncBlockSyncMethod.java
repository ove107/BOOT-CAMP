package JavaMultithreading;

public class SyncBlockSyncMethod extends Thread {

    @Override
    public void run() {
        try {
            method1();
            try {
                Thread.sleep(3000);
            } catch (Exception e) {

            }
            method2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized void method1() throws InterruptedException {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread::" + Thread.currentThread().getName() + " i first in method1 :: " + i);
        }
    }

    void method2() throws InterruptedException {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread::" + Thread.currentThread().getName() + " i second in method1 :: " + i);
            Thread.sleep(2000);
        }
        Thread.sleep(4000);
        synchronized (this) {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread::" + Thread.currentThread().getName() + " i inside sync block in method2 :: " + i);
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        SyncBlockSyncMethod s = new SyncBlockSyncMethod();
        Thread thread = new Thread(s);
        Thread thread1 = new Thread(s);
        thread.start();
        thread1.start();
    }
}


