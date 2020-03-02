package JavaMultithreading;

import java.util.concurrent.CountDownLatch;

class MyThreadd implements Runnable
    {
        private final String name;
        private final int timmeToStart;
        private final CountDownLatch latch;
        public MyThreadd(String name,int timmeToStart,CountDownLatch latch)
        {
            this.name=name;
            this.timmeToStart= timmeToStart;
            this.latch=latch;
        }

        @Override
        public void run() {
            try{
                Thread.sleep(timmeToStart);
            }
            catch (InterruptedException ex)
            {
                System.out.println(Thread.currentThread().getName()+" "+ex.getMessage());
            }
            System.out.println(name+ "is Up ");
            latch.countDown();
        }
    }
    public class CountLatch {
        public static void main(String[] args) {
            final CountDownLatch latch=new CountDownLatch(3);
            Thread a=new Thread(new MyThreadd("A ",1000,latch));
            Thread b=new Thread(new MyThreadd("B ",2000,latch));
            Thread c=new Thread(new MyThreadd("C ",500,latch));

            a.start();
            b.start();
            c.start();


            try{
                latch.await();
                System.out.println("All services up,Application is starting now");
            }
            catch (InterruptedException ie)
            {
                ie.printStackTrace();
            }

        }
    }

