import java.util.Random;

public class Car implements Runnable {

    // car's direction: 0: car from North to South, 1: car from West to East
    private int carDirection;
    private int carSpeed;
    private String carSymbol;
    private GridSquare[][] gridSquare;

    //position for car
    int startPosition;
    int currentPosition;

    GridSquare nextSquare;
    GridSquare currentSquare;


    //
    private boolean isFinished= false;
    //car constructor
    public Car(GridSquare[][] gridSquare,int carDirection, String carSymbol){
        this.gridSquare = gridSquare;
        this.carDirection = carDirection;
        this.carSymbol = carSymbol;


        //each car has a randomly constant speed, max = 500
        Random r = new Random();
        carSpeed = r.nextInt(500) + 100;


        //car from North to South
        if (carDirection == 0){
            currentPosition = 0;
            startPosition = r.nextInt(gridSquare[0].length);
            nextSquare = gridSquare[currentPosition][startPosition];
        }

        //car from West to East
        if (carDirection == 1){
            currentPosition = 0;
            startPosition = r.nextInt(gridSquare.length);
            nextSquare = gridSquare[currentPosition][startPosition];
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
        nextSquare.takeSquare(this);


        while (!isFinished){
            //car move
            move();
            nextSquare.takeSquare(this);

            gridSquare[getCurrentPosition()-1][startPosition].leaveSquare(this);

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
            nextSquare = gridSquare[++currentPosition][startPosition];
        }
    }



    /*
     * check if the car finishes the move
     */

    public void checkCarStatus(){
        if (carDirection == 0 && currentPosition== gridSquare.length -1){
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


    public int getCurrentPosition() {
        return currentPosition;
    }
}
