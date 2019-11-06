package hk.edu.polyu.comp.comp2021.jungle.model;
import java.util.Scanner;

public class Prompt {
    /*This class is designed to print some message by static only.*/
    public static void setHomePlayer() {
        System.out.println("Please input home player's name: ");
    }

    public static void setAwayPlayer() {
        System.out.println("Please input away player's name: ");
    }

    public static void newOrLoad() {
        System.out.println("Do you want to continue previously saved game? (Y/N) ");
    }
    public static void overWriteOrNo() {
        System.out.println("A save file already exists, do you want to overwrite? (Y/N) ");
    }

    public static void notSaved() {
        System.out.println("The file is not saved");
    }

    public static void waitingInput() { System.out.println("Waiting for next input..."); }

    public static String getInput() {
        Prompt.waitingInput();
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        //s.close();
        System.out.println(input);
        return input;
    }



    public static void printBoard(Jungle j) {
        Piece[][] board = j.getBoard().clone();
        String X = "  A        B        C        D        E        F        G        ";
        String[] Y = {"1|", "2|", "3|", "4|", "5|", "6|", "7|", "8|", "9|"};
        StringBuilder s;
        for (int y = 8; y >= 0; y--){
            s = new StringBuilder();
            s.append(Y[y]);
            for (int x = 0; x < 7; x++)  {
                if (board[x][y] == null) {
                    if (Jungle.isWater(new Location(x,y))) s.append(Jungle.waterToString());
                    else s.append(Jungle.grassToString());
                }
                else s.append(board[x][y].toString());
            }
            System.out.println(s.toString());
        }
        System.out.println(X);
    }

    public static void win(String winner) {
        System.out.printf("%s wins the game!\n", winner);
    }
}
