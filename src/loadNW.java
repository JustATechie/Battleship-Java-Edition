
/**
 *
 */
public class loadNW {
    char[][] board = new char[10][10];

    /**
     * default constructor
     */
    loadNW(){

    }

    public void loadBoard(){
        for(int i = 0; i< 10; i++){
            for(int j = 0; j < 10; j++){
                board[i][j] = '-';
            }
        }
    }

    public void printBoard(){
        int letters = 60;

        for (int k = 0; k < 10; k++){
            letters = letters + 1;
            System.out.print("\t" + letters);
        }
        System.out.println();

        //TODO: convert unicode values into letters.


        for(int i = 0; i < 10; i++) {  //column
            System.out.print(i + 1 + "\t");
            for (int j = 0; j < 10; j++) { //row
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void insertShip(String coordinate1, String coordinate2){




    }







}
