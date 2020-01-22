package com.justatechie.battleship;

public class Board {

    protected final static String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    protected final static int defaultSize = 10;
    protected final static String coordinatePattern = "^(?i)[a-z][0-9]{1,10}$";
    protected final int size;
    protected char[][] board;

    /**
     * default constructor
     */
    public Board() {
        this.size = Board.defaultSize;
        this.init();
    }

    public Board(int size) {
        this.size = size;
        this.init();
    }

    /**
     * Construct the {board} with the set {size}. Fills the board grid
     * with hyphens.
     */
    protected void init() {
        this.board = new char[this.size][this.size];

        // Fill board grid with defaults `-`
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                board[i][j] = '-';
            }
        }

    }

    /**
     * Validates that a {@link Ship} can be added at the given start/end locations.
     * 
     * @param ship ship
     * @param start starting coordinate
     * @param end ending coordinate
     * @throws IllegalArgumentException is invalid
     */
    protected void validatePlacement(Ship ship, String start, String end) {
        start = start.toUpperCase();
        end = end.toUpperCase();

        // Validate coordinates
        if (!(start.matches(Board.coordinatePattern) || end.matches(Board.coordinatePattern))) {
            throw new IllegalArgumentException();
        }

        boolean col = start.charAt(0) == end.charAt(0);
        boolean row = start.charAt(1) == end.charAt(1);
        // validate that points are straight && are not the same point
        if (col == row /* col XOR row */) {
            throw new IllegalArgumentException("Row=" + row + " & Col=" + col);
        }

        // Validate distance
        int dist;
        if (col) {
            dist = Integer.parseInt(start.substring(1)) - Integer.parseInt(end.substring(1));
        } else {
            dist = Board.alpha.indexOf(start.charAt(0)) - Board.alpha.indexOf(end.charAt(0));
        }

        if (Math.abs(dist) + 1 != ship.getLength()) {
            throw new IllegalArgumentException();
        }

        // TODO! deny overlapping with other ships
        boolean overlap = false;
        int startLetter = Board.alpha.indexOf(Character.toString(start.charAt(0)));
        int startNumber = Integer.parseInt(start.substring(1)) - 1;
        int endLetter = Board.alpha.indexOf(Character.toString(end.charAt(0)));
        int endNumber = Integer.parseInt(end.substring(1)) - 1;

        if(col) {
            //if(startLetter > startNumber) {
                for (int a = 0; a <= ship.getLength(); a++) {
                    if (board[endLetter][endNumber - a] != '-') {
                        throw new IllegalArgumentException("Ships overlap!");
                    }
                }
           // }
           /* else{
                for (int a = 0; a < ship.getLength(); a++) {
                    if (board[startLetter][startNumber + a] != '-') {
                        throw new IllegalArgumentException("Ships overlap!");
                    }
                }
            }
            */


        }
        else{
            //if(startLetter > startNumber) {
                for (int a = 0; a < ship.getLength(); a++) {
                    if (board[endLetter - a][endNumber] != '-') {
                        throw new IllegalArgumentException("Ships overlap!");
                    }
                }
          //  }

          /*  else{
                for (int a = 0; a < ship.getLength(); a++) {
                    if (board[startLetter + a][startNumber] != '-') {
                        throw new IllegalArgumentException("Ships overlap!");
                    }
                }
            }

           */

        }
    }

    public void addShip(Ship ship, String start, String end) {
        validatePlacement(ship, start, end);
        start = start.toUpperCase();
        end = end.toUpperCase();
        String startLetter = Character.toString(start.charAt(0));
        String startNumber = start.substring(1);
        String endLetter = Character.toString(end.charAt(0));
        String endNumber = end.substring(1);
        boolean col = startLetter.equals(endLetter);

        if (col) {
            int c = Board.alpha.indexOf(startLetter);
            int s = Integer.parseInt(startNumber) - 1;
            int e = Integer.parseInt(endNumber) - 1;

            if (s < e) {
                for (; s <= e; s++) {
                    this.board[s][c] = ship.getSymbol();
                }
            }

            else {
                for (; e <= s; e++) {
                    this.board[e][c] = ship.getSymbol();
                }
            }
        }

        else {
            int r = Integer.parseInt(startNumber) - 1;
            int s = Board.alpha.indexOf(startLetter);
            int e = Board.alpha.indexOf(endLetter);

            if (s < e) {
                for (; s <= e; s++) {
                    this.board[r][s] = ship.getSymbol();
                }
            }

            else {
                for (; e <= s; e++) {
                    this.board[r][e] = ship.getSymbol();
                }
            }
        }
    }

    public void printConsole() {

        // Print col names
        System.out.print("\t");
        for (int k = 0; k < this.size; k++) {
            System.out.print(Board.alpha.charAt(k) + "  ");
        }
        System.out.println();

        // TODO? convert unicode values into letters.

        for (int r = 0; r < this.size; r++) { // row

            System.out.print(r + 1 + "\t"); // Print row names

            for (int c = 0; c < this.size; c++) { // col

                String rSpacer = "  ";

                if (c < this.size - 1 && this.board[r][c] != '-' && this.board[r][c + 1] != '-') {
                    rSpacer = "--";
                }

                System.out.print(board[r][c] + rSpacer);

            }

            System.out.println();

        }
    }

    public char[][] getBoard() {
        return this.board;
    }

}
