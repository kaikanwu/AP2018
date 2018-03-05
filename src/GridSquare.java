import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*
Only one car can be in any one grid square
 */
public class GridSquare {
    private ReentrantLock lock = new ReentrantLock();
    private Condition occupied = lock.newCondition();
    private boolean isOccupied = false;
    private String symbol = "| ";





    public String getSymbol(){
        return symbol;
    }
}
