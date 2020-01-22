package com.justatechie.battleship;

import java.io.IOException;
import java.util.Scanner;

/*
 * @author Louis DiBernardo
 */
public class Main {

    public static void main(final String[] args) throws IOException {
        final Scanner sc = new Scanner(System.in);
        final Board board = new Board();

        board.printConsole();

        board.addShip(new Ship.Carrier(), "A1", "A5");
        board.addShip(new Ship.Submarine(), "H1", "J1");
        board.addShip(new Ship.Battleship(), "F9", "F6");
        board.addShip(new Ship.Destroyer(), "A10", "C10");
        board.addShip(new Ship.PatrolBoat(), "J9", "J10");

        board.printConsole();

        // System.out.println(
        // "Player one, please input your ship locations. One ship at a time with the \n
        // first coordinate and the last coordinate like so: A1 A3");
        // final String coordinate1 = sc.next();
        // final String coordinate2 = sc.next();

        // System.out.println(coordinate1 + " " + coordinate2);

        /*
         * Scanner sc = new Scanner(System.in); FileInputStream in = new
         * FileInputStream("highScore.txt");
         *
         * Load loadShips = new Load();
         *
         * if(loadShips.getPlayerCount() == 1){ System.out.println("hi"); }
         *
         * else{ System.out.println("hello");
         *
         * }
         */

    }

}
