package com.justatechie.battleship;

public class Board {

    protected final static String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    protected final static int defaultSize = 10;
    protected final static String coordinatePattern = "^(?i)[a-z][0-9]{1,10}$";
    protected final int size;
    protected char[][] board;
    protected int startLetter;
    protected int startNumber;
    protected int endLetter;
    protected int endNumber;

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

    protected void coordinateOrientationCheck (String start, String end){
        start = start.toUpperCase();
        end = end.toUpperCase();
        startLetter = Board.alpha.indexOf(Character.toString(start.charAt(0)));
        startNumber = Integer.parseInt(start.substring(1)) - 1;
        endLetter = Board.alpha.indexOf(Character.toString(end.charAt(0)));
        endNumber = Integer.parseInt(end.substring(1)) - 1;

        if(startLetter > endLetter || startNumber > endNumber){
            if(startLetter > endLetter){
                int tempLetter = startLetter;
                startLetter = endLetter;
                endLetter = tempLetter;
            }
            else{
                int tempNumber = startNumber;
                startNumber = endNumber;
                endNumber = tempNumber;
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
        // Validate coordinates are within grid.
        if (!(start.matches(Board.coordinatePattern) || end.matches(Board.coordinatePattern))) {
            throw new IllegalArgumentException();
        }

        // validate that points are straight && are not the same point
        boolean col = startLetter == endLetter;
        boolean row = startNumber == endNumber;
        if (col == row /* col XOR row */) {
            throw new IllegalArgumentException("Row=" + row + " & Col=" + col);
        }

        // Validate distance
        int dist;
        if (col) {
            dist = startNumber - endNumber;
        }

        else {
            dist = startLetter - endLetter;
        }

        if (Math.abs(dist) + 1 != ship.getLength()) {
            throw new IllegalArgumentException("Coordinate length does not match ship length!");
        }

        /*
         * Check for possible collisions
         */
        if (col) {
            for(int a = 0; a <= ship.getLength() - 1; a++){
                if (board[startNumber + a][startLetter] != '-'){
                    throw new IllegalArgumentException("Ships overlap! This one is the problem: " + ship.getName());
                }
            }
        }

        else {
            for(int a = 0; a <= ship.getLength() - 1; a++){
                if (board[startNumber][startLetter + a] != '-'){
                    throw new IllegalArgumentException("Ships overlap! This one is the problem:" + ship.getName());
                }
            }
        }
    }

    public void addShip(Ship ship, String start, String end) {
        coordinateOrientationCheck(start, end);
        validatePlacement(ship, start, end);
        boolean col = startLetter == endLetter;

        if (col) {
            int c = startLetter;
            int s = startNumber;
            int e = endNumber;
            for (; s <= e; s++) {
                this.board[s][c] = ship.getSymbol();
            }
        }

        else {
            int r = startNumber;
            int s = startLetter;
            int e = endLetter;
            for (; s <= e; s++) {
                this.board[r][s] = ship.getSymbol();
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
        System.out.println();
    }

    public char[][] getBoard() {
        return this.board;
    }

}
