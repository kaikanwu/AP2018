public class DrawGrid implements Runnable {

    private int count=0;
    private int runTime = 2000;
    private GridSquare[][] gridSquares;
    private StringBuilder stringBuilder;

    public DrawGrid(GridSquare[][] gridSquares){
        this.gridSquares = gridSquares;
    }


    @Override
    public void run() {
        drawGrid();
    }

    /*
     * method: draw the grid
     */
    private void drawGrid(){
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
            System.out.println(count + "\r\n" + "\r\n");

            //draw every 20 milliseconds
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }





}
