/**
 * class DrawGrid: draw the grid every 20 milliseconds
 * @author 2327942w
 */
public class DrawGrid implements Runnable {
    private int count=0;
    private int runTime = 2000;
    private GridSquare[][] gridSquares;
    private StringBuilder stringBuilder;

    /**
     * constructor
     *
     * @param gridSquares
     */
    public DrawGrid(GridSquare[][] gridSquares){
        this.gridSquares = gridSquares;
    }


    /**
     * override the run method
     */
    @Override
    public void run() {
        drawGrid();
    }


    /**
     * method to draw the grid
     */
    private void drawGrid(){
        // draw 2000 time
        while (count < runTime){
            stringBuilder = new StringBuilder();
            stringBuilder.append("-----------------------------------------" +"\r\n");
            //get the symbol from each grid square
            for (int i = 0; i <gridSquares.length ; i++) {
                for (int j = 0; j < gridSquares[i].length; j++) {
                    stringBuilder.append(gridSquares[i][j].getSymbol());
                }
                stringBuilder.append("|");
                stringBuilder.append("\r\n");

            }

            stringBuilder.append("-----------------------------------------" +"\r\n");
            System.out.println(stringBuilder);
            count++;
//            System.out.println(count + "\r\n" + "\r\n");

            //draw every 20 milliseconds
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }





}
