import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*
Only one car can be in any one grid square
 */
public class GridSquare {
    private ReentrantLock squareLock = new ReentrantLock();
    private Condition occupied = squareLock.newCondition();
    private boolean isOccupied = false;
    private String symbol = "| ";




    /*
     * the car take the square
     */
    public void takeSquare(Car car){
        try {
            Thread.sleep(car.getCarSpeed());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        squareLock.lock();

        try {

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

    /*
        car leave the square
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


    /*
     * setter and getter
     */

    public String getSymbol(){
        return symbol;
    }
}
