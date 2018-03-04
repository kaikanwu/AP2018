import java.util.concurrent.FutureTask;

public class APSpec1 {
    public static void main(String[] args)throws Exception{
        int rows = 10;
        int columns =20;


        // set the grid square
        Grid grid = new Grid(columns,rows);
        Thread gridThread = new Thread(grid);
        gridThread.start();


    }
}
