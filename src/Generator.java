import java.util.ArrayList;

public class Generator implements Runnable {
    private int carDirection;
    private GridSquare[][] gridSquares;
    private int carGenerateTime;
    private String carSymbol;
    private String generatorName;

    private Thread drawGridThread;
    private ArrayList<Double> timeArray = new ArrayList<Double>();
    /**
     * constructor for Generator
     * @param gridSquares
     * @param carDirection
     * @param carGenerateTime
     * @param carSymbol
     */
    public Generator(GridSquare[][] gridSquares, int carDirection, int carGenerateTime, String carSymbol, String generatorName, Thread drawGridThread){

        this.gridSquares = gridSquares;
        this.carDirection = carDirection;
        this.carGenerateTime = carGenerateTime;
        this.carSymbol = carSymbol;
        this.generatorName = generatorName;
        this.drawGridThread = drawGridThread;


    }


    /**
     * override the run method
     */
    @Override
    public void run() {


        while (drawGridThread.isAlive()){
            //delay 200 milliseconds, make the screen more clear
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //time between car generate
            try {
                Thread.sleep(carGenerateTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            Thread carThread = new Thread(new Car(gridSquares,carDirection,carSymbol,this));
            carThread.start();
        }

        //write report when the thread end
        Statistics statistics = new Statistics(timeArray,generatorName);
        statistics.writeReport();
    }


    /**
     * record time
     * @param elapsedTime
     */
    public void recordTime(double elapsedTime){
        timeArray.add(elapsedTime);
    }




}
