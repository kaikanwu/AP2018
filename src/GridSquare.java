import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


/**
 * class gridSquare, make each grid square to be a object
 * only one can be in one grid square
 */
public class GridSquare {
    private ReentrantLock squareLock = new ReentrantLock();
    private Condition occupied = squareLock.newCondition();
    private boolean isOccupied = false;
    private String symbol = "| ";



    /**
     * when the car take the square, change the symbol on the grid
     * @param car
     */
    public void takeSquare(Car car){
        try {
            Thread.sleep(car.getCarSpeed());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        squareLock.lock();
        try {
            //only one car can be in one grid square
            while (isOccupied){
                occupied.await();
            }
            isOccupied = true;
            symbol = "|" + car.getCarSymbol();

        }catch (InterruptedException e){
            e.printStackTrace();

        }finally {
            squareLock.unlock();
        }

    }


    /**
     * when the car leave the square, change the symbol to "| "
     * @param car
     */
    public void leaveSquare(Car car){
        squareLock.lock();

        try {
            isOccupied = false;
            occupied.signalAll();
        }finally {
            squareLock.unlock();
            symbol = "| ";
        }
    }


    /**
     * setter and getter method
     * @return
     */
    public String getSymbol(){
        return symbol;
    }
}
