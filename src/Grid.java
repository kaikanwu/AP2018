public class Grid implements Runnable {
    int columns;
    int rows;
    int count=0;
    public Grid(int columns, int rows){
        this.columns = columns;
        this.rows = rows;
    }

    @Override
    public void run() {
        drawGrid();
    }

    public void drawGrid(){
        while (count < 30){
            System.out.println("-----------------------------------------");

            //
            for (int i = 0; i <rows ; i++) {
                for (int j = 0; j < columns+1; j++) {
                    System.out.print("|" + " ");
                }
                System.out.println("");

            }

            System.out.println("-----------------------------------------");
            System.out.println(count);
            count++;

            //draw every 20 milliseconds
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
