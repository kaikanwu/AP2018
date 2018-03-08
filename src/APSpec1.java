/**
 *
 *  @author Kaikan Wu (2327942w)
 */
public class APSpec1 {
    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args)throws Exception{
        int rows = 10;
        int columns =20;

        /*
         * 1. make the grid square, each grid square should be a object!
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
        Thread drawGridThread = new Thread(drawGrid);
        drawGridThread.start();

        /*
         * 3. Generate the cars
         */
        // when the grid thread start, generate the car
        while (drawGridThread.isAlive()){
            //let the car generate not too fast, make the screen more clear
            Thread.sleep(800);
            // car From North to South. Symbol: "o"
            Thread car1 = new Thread( new Car(gridSquares,0,"o"));
            car1.start();
            // car from West to East. Symbol: "-"
            Thread car2 = new Thread(new Car(gridSquares,1,"-"));
            car2.start();
        }

        /*
         * 4. stop the simulator when the grid has be-en drawn 2000 times
         */
        System.exit(0);

    }
}
