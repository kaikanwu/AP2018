

public class MyThread implements Runnable {


    private int ticket = 5;
    @Override
    public void run(){

        for (int i = 0; i < 10; i++) {
            System.out.println("Thread is running "+ (i+1));


            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }







//        for (int i = 0; i < 20; i++) {
//////            synchronized(this){
////                if (this.ticket>0){
////
////                    try {
////                        Thread.sleep(1000);
////
////                    }catch (InterruptedException e){
////                        e.printStackTrace();
////                    }
////                    System.out.println(Thread.currentThread().getName()+ "sold ticket, ticket left = " + this.ticket--);
////
////                }
//////            }
//
//
//
//
//        }




    }

}
