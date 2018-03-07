import java.util.Random;

public class Car implements Runnable {

    // car's direction: 0: car from North to South, 1: car from West to East
    private int carDirection;
    private int carSpeed;
    private String carSymbol;
    private GridSquare[][] gridSquare;

    //position for car
    private int columnPosition;
    private int rowPosition;

    private GridSquare nextSquare;
    private GridSquare currentSquare;


    //
    private boolean isFinished= false;
    //car constructor
    public Car(GridSquare[][] gridSquare,int carDirection, String carSymbol){
        this.gridSquare = gridSquare;
        this.carDirection = carDirection;
        this.carSymbol = carSymbol;


        //each car has a randomly constant speed, max = 500 , min = 100
        Random r = new Random();
        carSpeed = r.nextInt(500) + 100;


        //car from North to South
        if (carDirection == 0){
            //at start , the row position must be 0
            rowPosition = 0;
            //at start, the column position should be random
            columnPosition = r.nextInt(gridSquare[0].length);
            currentSquare = gridSquare[rowPosition][columnPosition];
        }

        //car from West to East
        if (carDirection == 1){
            rowPosition = 0;
            columnPosition = r.nextInt(gridSquare.length);
            nextSquare = gridSquare[rowPosition][columnPosition];
        }


    }
//
//    //The cars' direction
//    public enum Direction{
//
//        EAST,
//        SOUTH;
//    }

    @Override
    public void run() {

        //car move
        currentSquare.takeSquare(this);


        while (!isFinished){
            //car move
            move();
            nextSquare.takeSquare(this);

            gridSquare[getRowPosition()-1][columnPosition].leaveSquare(this);

            //check car is finished or not
            checkCarStatus();
        }

        try {
            Thread.sleep(carSpeed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        nextSquare.leaveSquare(this);

    }


    /*
     * car move
     */

    public void move(){
        if (carDirection == 0){
            nextSquare = gridSquare[++rowPosition][columnPosition];

        }
    }



    /*
     * check if the car finishes the move
     */

    public void checkCarStatus(){
        if (carDirection == 0 && rowPosition== gridSquare.length -1){
            isFinished = true;
        }
    }

    /*
     * getter and setter
     */

    public int getCarDirection() {
        return carDirection;
    }

    public void setCarDirection(int carDirection) {
        this.carDirection = carDirection;
    }

    public int getCarSpeed() {
        return carSpeed;
    }

    public void setCarSpeed(int carSpeed) {
        this.carSpeed = carSpeed;
    }

    public String getCarSymbol() {
        return carSymbol;
    }

    public void setCarSymbol(String carSymbol) {
        this.carSymbol = carSymbol;
    }


    public int getRowPosition() {
        return rowPosition;
    }
}
