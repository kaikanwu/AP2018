import java.util.concurrent.FutureTask;

public class APSpec1 {
    public static void main(String[] args)throws Exception{
        System.out.println("test");
        MyThread mt1 = new MyThread();
        MyThread mt2 = new MyThread();

        FutureTask<String> task1 = new FutureTask<String>(mt1);
        FutureTask<String> task2 = new FutureTask<String>(mt2);


        new Thread(task1).start();
        new Thread(task2).start();


        System.out.println("thread A :" + task1.get());
        System.out.println("thread B :" + task2.get());
    }
}
