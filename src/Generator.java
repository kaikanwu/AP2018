public class Generator implements Runnable {
    private int carDirection;
    private GridSquare[][] gridSquares;
    private int carGenerateTime;
    String carSymbol;


    /**
     * constructor for Generator
     * @param gridSquares
     * @param carDirection
     * @param carGenerateTime
     * @param carSymbol
     */
    public Generator(GridSquare[][] gridSquares, int carDirection, int carGenerateTime, String carSymbol){

        this.gridSquares = gridSquares;
        this.carDirection = carDirection;
        this.carGenerateTime = carGenerateTime;
        this.carSymbol = carSymbol;
    }




    @Override
    public void run() {
        //time between car generate
        try {
            Thread.sleep(carGenerateTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread car = new Thread(new Car(gridSquares,carDirection,carSymbol,this));
        car.start();




    }
}
