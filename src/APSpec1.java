import java.util.concurrent.FutureTask;

public class APSpec1 {
    public static void main(String[] args)throws Exception{

        MyThread mt = new MyThread();
        Thread t = new Thread(mt);
        t.start();










    }
}
