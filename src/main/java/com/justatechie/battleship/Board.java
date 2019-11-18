package com.justatechie.battleship;

com.justatechie.battleship.Ship;

/**
*
*/
public class Board {

    protected final static String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    protected final static int defaultSize = 10;
    protected final static String coordinatePattern = "^(?i)[a-z][0-9]$";

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
     * Construct the {@link board} with the set {@link size}. Fills the board grid
     * with hypens.
     */
    protected void init() {
        this.board = new char[10][10];

        // Fill board grid with defaults `-`
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = '-';
            }
        }

    }

    /**
     * Validates that a {@link Ship} can be added at the given start/end locations.
     * 
     * @param ship
     * @param start
     * @param end
     * @return `true` if the ship placement is valid
     */
    protected boolean validatePlacement(Ship ship, String start, String end) {

        // Validate coordinates
        if (!(start.matches(Board.coordinatePattern) || end.matches(Board.coordinatePattern))) {
            return false;
        }

        boolean col = start.charAt(0) == end.charAt(0);
        boolean row = start.charAt(1) == start.charAt(1);
        // validate that points are straight && are not the same point
        if (col ^ row /* col XOR row */) {
            return false;
        }

        // Validate distance
        int dist;
        if (col) {
            dist = Integer.parseInt(start.substring(1, 2)) - Integer.parseInt(end.substring(1, 2));
        } else {
            dist = Board.alpha.indexOf(start.charAt(0)) - Board.alpha.indexOf(end.charAt(0));
        }

        // TODO! deny overlapping with other ships

        return Math.abs(dist) == ship.getLength();

    }

    public addShip(Ship ship, String start, String end) {
        
    }

    public void printBoard() {

        // Print col names
        for (int k = 0; k < 10; k++) {
            System.out.print("\t" + Board.alpha.charAt(k));
        }
        System.out.println();

        // TODO? convert unicode values into letters.

        for (int i = 0; i < 10; i++) { // column
            System.out.print(i + 1 + "\t");
            for (int j = 0; j < 10; j++) { // row
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public char[][] getBoard() {
        return this.board;
    }

}
