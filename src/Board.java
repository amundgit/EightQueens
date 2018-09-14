public class Board {

    private Boolean[][] matrix = new Boolean[8][8];

    public Board(){
        fillMatrix();
    }


    private void fillMatrix(){
        for (int i = 0; i<8;i++){
            for (int j = 0; j<8;j++){
                matrix[i][j] = false;
            }
        }
    }

    public boolean findQueens(int x){


        for(int y = 0; y < matrix.length; y++){

            if(allowed(x, y)){
                matrix[x][y]=true;

                if(x == matrix.length-1 || findQueens(x+1)){

                    return true;
                }
                matrix[x][y]=false;
            }
        }
        return false;
    }

    private Boolean allowed(int x, int y) {

        for(int i = 0; i <= x; i++){
            if (matrix[i][y] || (i <= y && matrix[x-i][y-i]) || (y+i < matrix.length && matrix[x-i][y+i])){
                return false;
            }
        }
        return true;
    }


    public void printBoard(){
        for(int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++){
                if(matrix[i][j]){
                    System.out.printf("X ");
                }
                else{
                    System.out.printf("o ");
                }
            }
            System.out.println("");
        }
    }



}
