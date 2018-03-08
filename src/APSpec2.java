/**
 * Class for the  Advanced Programming Specifications - level 2\
 * @author 2327942w
 */
public class APSpec2 {
    public static void main(String[] args){
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


        DrawGrid drawGrid = new DrawGrid(gridSquares);
        Thread drawGridThread = new Thread(drawGrid);
        drawGridThread.start();

        /*
         * 3. Generate the cars
         */
        // when the grid thread start, generate the car
        while (drawGridThread.isAlive()){

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Generator carGenerator1 = new Generator(gridSquares,2,1000,"*");
            Generator carGenerator2 = new Generator(gridSquares,0,1000,"o");
            Generator carGenerator3 = new Generator(gridSquares,1,1000,"-");
            Generator carGenerator4 = new Generator(gridSquares,3,1000,"x");

            Thread carThread1 = new Thread(carGenerator1);
            carThread1.start();
            Thread carThread2 = new Thread(carGenerator2);
            carThread2.start();
            Thread carThread3 = new Thread(carGenerator3);
            carThread3.start();
            Thread carThread4 = new Thread(carGenerator4);
            carThread4.start();


            try {
                carThread1.join();
                carThread2.join();
                carThread3.join();
                carThread4.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }




        /*
         * 4. stop the simulator when the grid has be-en drawn 2000 times
         */
        System.exit(0);



    }
}
