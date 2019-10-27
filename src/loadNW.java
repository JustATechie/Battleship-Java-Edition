public class loadNW {
    char[][] board = new char[10][10];

    /*
    *default constructor
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
        int letters = 65;

        for (int k = 0; k < 10; k++){
            char letter = (char)letters;
            System.out.print("\t" + letter);
            letters = letters + 1;
        }
        System.out.println();

        for(int i = 0; i < 10; i++) {  //column
            System.out.print(i + 1 + "\t");
            for (int j = 0; j < 10; j++) { //row
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void insertShip(String coordinate1, String coordinate2){
        char firstColumn = coordinate1.charAt(0);
        int firstNumber = coordinate1.charAt(1);

        char lastRow = coordinate2.charAt(0);
        int lastNumber = coordinate2.charAt(1);

        char test = (char)65;

        System.out.println(test);



    }







}
