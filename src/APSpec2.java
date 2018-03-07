public class APSpec2 {
    public static void main(String[] args){
        int rows = 10;
        int columns =20;

        /*
         * 1. make the grid square, each grid square should be a object!
         */

        GridSquare[][] gridSquares = new GridSquare[rows][columns];


        //make each grid square to be a object.
        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j < columns ; j++) {
                gridSquares[i][j] = new GridSquare();

            }

        }




    }
}
