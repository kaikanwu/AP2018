import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private int ticket = 10;
    @Override
    public String call() throws Exception{
        for (int x = 0; x < 100; x++){
            if (this.ticket>0){
                System.out.println("sale the ticket, ticket left= " + this.ticket--);

            }
        }
        return "The ticket is sold out!";
    }
}
