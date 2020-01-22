package com.justatechie.battleship;

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
       for (int k = 1; k < 11; k++){
           System.out.print("\t" + k);
       }
       System.out.println();

        int letters = 65;

        for(int i = 0; i < 10; i++) {  //column
            char letter = (char)letters;
            System.out.print(letter + "\t");
            letters = letters + 1;
            for (int j = 0; j < 10; j++) { //row
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }

    }


    public void insertShip(String coordinate1, String coordinate2){
        char firstColumnChar = coordinate1.charAt(0);
        int firstRowNumber = coordinate1.charAt(1);
        char lastColumnChar = coordinate2.charAt(0);
        int lastRowNumber = coordinate2.charAt(1);

        int firstColumnNumber = checkColumn(firstColumnChar);
        int lastColumnNumber = checkColumn(lastColumnChar);

        boolean columnSame = checkSame(firstColumnNumber, lastColumnNumber);
        boolean rowSame = checkSame(firstRowNumber, lastRowNumber);

    }

    public int checkColumn(char column){
        int num = -1;

        switch (column){
            case 1: column = 'A';
            num = 0;
            break;

            case 2: column = 'B';
            num = 1;
            break;

            case 3: column = 'C';
            num = 2;
            break;

            case 4: column = 'D';
            num = 3;
            break;

            case 5: column = 'E';
            num = 4;
            break;

            case 6: column = 'F';
            num = 5;
            break;

            case 7: column = 'G';
            num = 6;
            break;

            case 8: column = 'H';
            num = 7;
            break;

            case 9: column = 'I';
            num = 8;
            break;

            case 10: column = 'J';
            num = 9;
            break;

            default: column = 'K';
            break;
        }
        return num;
    }

    public boolean checkSame(int num1, int num2){
        boolean direction = false;

        if (num1 == num2){
            direction = true;
        }

        return direction;

    }







}
