import java.util.Random;

/**
 * Car class: Let the car move on the grid
 * @author 2327942w
 */
public class Car implements Runnable {

    private int carDirection;
    private int carSpeed;
    private String carSymbol;
    private GridSquare[][] gridSquare;


    private int columnPosition;
    private int rowPosition;

    private GridSquare nextSquare;
    private GridSquare currentSquare;

    private boolean isFinished= false;

    private double startTime;
    private double endTime;
    private double elapsedTime;
    /**
     * Car constructor for spec1
     * @param gridSquare
     * @param carDirection
     * @param carSymbol
     */
    public Car(GridSquare[][] gridSquare,int carDirection, String carSymbol){
        this.gridSquare = gridSquare;
        this.carDirection = carDirection;
        this.carSymbol = carSymbol;


        //each car has a randomly constant speed, max = 1000 , min = 100
        Random r = new Random();
        carSpeed = r.nextInt(1000) + 100;


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
            columnPosition = 0;
            rowPosition = r.nextInt(gridSquare.length);
            currentSquare = gridSquare[rowPosition][columnPosition];
        }
//        //car from South to North
//        else if (carDirection == 2){
//            rowPosition = gridSquare.length - 1;
//            columnPosition
//
//
//        }

    }

    /**
     * Car constructor for spec2
     * @param gridSquare
     * @param carDirection
     * @param carSymbol
     * @param generator
     */
    public Car(GridSquare[][] gridSquare,int carDirection, String carSymbol, Generator generator){
        this.gridSquare = gridSquare;
        this.carDirection = carDirection;
        this.carSymbol = carSymbol;


        //each car has a randomly constant speed, max = 1000 , min = 100
        Random r = new Random();
        carSpeed = r.nextInt(1000-100) + 100;


        //car from North to South
        if (carDirection == 0){
            //at start , the row position must be 0
            rowPosition = 0;
            //at start, the column position should be random
            columnPosition = r.nextInt(gridSquare[0].length/2);
            currentSquare = gridSquare[rowPosition][columnPosition];
        }
        //car from West to East
        if (carDirection == 1){
            columnPosition = 0;
            rowPosition = r.nextInt(gridSquare.length/2);
            currentSquare = gridSquare[rowPosition][columnPosition];
        }
        //car from South to North
        else if (carDirection == 2){
            rowPosition = gridSquare.length - 1;
            columnPosition = r.nextInt(gridSquare[0].length - gridSquare[0].length/2) + gridSquare[0].length/2;
            currentSquare = gridSquare[rowPosition][columnPosition];
        }
        //car from East to West
        else if (carDirection == 3){
            columnPosition = gridSquare[0].length-1;
            rowPosition = r.nextInt(gridSquare.length - gridSquare.length/2) + gridSquare.length/2;
            currentSquare = gridSquare[rowPosition][columnPosition];


        }
    }







    /**
     * Override run method
     */
    @Override
    public void run() {
        //record the start time
        startTime = System.nanoTime();


        //let the car display at the start position
        currentSquare.takeSquare(this);

        // when the car is not move to the end,
        while (!isFinished){
            //car move
            move();
            nextSquare.takeSquare(this);


            if (carDirection==0){
                gridSquare[getRowPosition()-1][columnPosition].leaveSquare(this);
            }else if (carDirection ==1){
                gridSquare[getRowPosition()][getColumnPosition()-1].leaveSquare(this);
            }else if(carDirection == 2){
                gridSquare[getRowPosition()+1][columnPosition].leaveSquare(this);
            }else if (carDirection ==3){
                gridSquare[getRowPosition()][getColumnPosition()+1].leaveSquare(this);
            }
            //check car is finished or not
            checkCarStatus();
        }
        // car need to leave the last grid square
        try {
            Thread.sleep(carSpeed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //record the end time
        endTime = System.nanoTime();

        elapsedTime = endTime-startTime;

        nextSquare.leaveSquare(this);

    }




    /**
     * method: change the nextSquare according to the different car direction
     */
    public void move(){
        if (carDirection == 0){
            nextSquare = gridSquare[++rowPosition][columnPosition];

        }else if (carDirection ==1){
            nextSquare = gridSquare[rowPosition][++columnPosition];
        }else if (carDirection == 2){
            nextSquare = gridSquare[--rowPosition][columnPosition];
        }else if (carDirection ==3){
            nextSquare = gridSquare[rowPosition][--columnPosition];
        }
    }



    /**
     * check weather the car is moving to the end
     */
    public void checkCarStatus(){
        if (carDirection == 0 && rowPosition== gridSquare.length -1){
            isFinished = true;
        }else if (carDirection ==1 && columnPosition ==gridSquare[0].length-1){
            isFinished = true;
        }else if (carDirection == 2 && rowPosition== 0){
            isFinished = true;

        }else if (carDirection ==3  && columnPosition == 0){
            isFinished = true;
        }




    }


    /**
     * getter and setter methods
     *
     * @return
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

    public int getColumnPosition() {
        return columnPosition;
    }

    public double getElapsedTime() {
        return elapsedTime;
    }
}
