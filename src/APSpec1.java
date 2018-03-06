import java.util.concurrent.FutureTask;

public class APSpec1 {
    public static void main(String[] args)throws Exception{
        int rows = 10;
        int columns =20;


        /*
         * 1. make the grid square
         */
        
        GridSquare[][] gridSquares = new GridSquare[rows][columns];


        //make each grid square to be a object.
        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j < columns ; j++) {
                gridSquares[i][j] = new GridSquare();

            }

        }


        /*
         * 2. Draw the grid
         */
        DrawGrid drawGrid = new DrawGrid(gridSquares);
        Thread gridThread = new Thread(drawGrid);
        gridThread.start();



        /*
         * 3. Generate the cars
         */


        // when the grid thread start, generate the car
        while (gridThread.isAlive()){
            Thread.sleep(500);

            Thread car = new Thread( new Car(gridSquares,0,"-"));
//            new Car(gridSquares,0,"-");
            car.start();
        }
    }
}
