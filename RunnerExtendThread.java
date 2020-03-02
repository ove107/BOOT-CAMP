package JavaMultithreading;

public class RunnerExtendThread extends Thread{
    @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("Hello: " + i + " Thread: "+Thread.currentThread().getName());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class ApplicationExtends {

        public static void main(String[] args) {
            RunnerExtendThread runner1 = new RunnerExtendThread();
            runner1.start();

            RunnerExtendThread runner2 = new RunnerExtendThread();
            runner2.start();
        }

    }