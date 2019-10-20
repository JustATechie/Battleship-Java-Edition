/*
 *
 *  @author Louis DiBernardo
 *
 */

import java.io.IOException;
import java.util.Scanner;
import java.io.FileInputStream;

public class Main {
    

    public static void main(String[]args) throws IOException{
        Scanner sc = new Scanner(System.in);
        loadNW load = new loadNW();
        //shipPieces player1 = new shipPieces();
        //shipPieces player2 = new shipPieces();
        
        load.loadBoard();
        load.printBoard();

        System.out.println("Player one, please input your ship locations. One ship at a time with the \n" +
                "first coordinate and the last coordinate like so: A1 A3");
        String coordinate1 = sc.next();
        String coordinate2 = sc.next();

        System.out.println(coordinate1 + " " + coordinate2);







        
        
        
        /*
        Scanner sc = new Scanner(System.in);
        FileInputStream in = new FileInputStream("highScore.txt");

        Load loadShips = new Load();

        if(loadShips.getPlayerCount() == 1){
            System.out.println("hi");
        }

        else{
            System.out.println("hello");

        }
*/



    }

}
