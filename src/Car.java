import java.util.Random;

public class Car implements Runnable {

    // car's direction: 0: car from North to South, 1: car from West to East
    private int carDiretion;
    private int carSpeed;
    private String carSymbol;
    private GridSquare[][] gridSquare;

    //position for car
    int startPosition;
    int currentPosition;

    GridSquare next;
    //car constructor
    public Car(GridSquare[][] gridSquare,int carDiretion, String carSymbol){
        this.gridSquare = gridSquare;
        this.carDiretion = carDiretion;
        this.carSymbol = carSymbol;


        //each car has a randomly constant speed, max = 500
        Random r = new Random();
        carSpeed = r.nextInt(500);


        //car from North to South
        if (carDiretion == 0){
            currentPosition = 0;
            startPosition = r.nextInt(gridSquare[0].length);
            next = gridSquare[currentPosition][startPosition];
        }

        //car from West to East
        if (carDiretion == 1){
            currentPosition = 0;
            startPosition = r.nextInt(gridSquare.length);
            next = gridSquare[currentPosition][startPosition];
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

    }
}
