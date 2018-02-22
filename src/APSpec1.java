public class APSpec1 {
    public static void main(String[] args){
        System.out.println("test");
        MyThread mt1 = new MyThread("Thread 1");
        MyThread mt2 = new MyThread("Thread 2");
        MyThread mt3 = new MyThread("Thread 3");


        new Thread(mt1).start();
        new Thread(mt2).start();
        new Thread(mt3).start();

    }
}
