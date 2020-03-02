package JavaMultithreading;


import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class CallableTask implements Callable<Integer>
{

    @Override
    public Integer call() throws Exception {
        Random num=new Random();
        Integer integer=num.nextInt(4);
        Thread.sleep(integer*1000);
        return integer;
    }
}
class UseCallable {
    public static void main(String[] args) throws  InterruptedException, ExecutionException {
        FutureTask<Integer>[] randomTasks=new FutureTask[4];
        for(int i=0;i<4;i++)
        {
            Callable<Integer> callable=new CallableTask();
            randomTasks[i]=new FutureTask<Integer>(callable);
            Thread t=new Thread(randomTasks[i]);
            t.start();
        }
        for (int i=0;i<4; i++)
        {
            System.out.println(randomTasks[i].get());

        }
    }
}