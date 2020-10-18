package CS5004.HW5;

import java.util.Scanner;

public class TicGame {

    public static void main(String[] args) {
        int playTime = 0;
        String turn = "X";
        Scanner scan = new Scanner(System.in);

        System.out.println("Let's start the tic-tac-toe!");
        Board board = new Board();
        board.show();

        while (true) {
            // not check for first 4 times because no winner until third round
            if (playTime++ > 4 && board.checkWin() != null) {
                    System.out.println("\n" + board.checkWin() + " wins! Congratulations!");
                    return;
                }

            // the code below will run for each user in turn
            System.out.printf("-----------------%s's turn------------------\n", turn);

            // let user continuously input unless the input is valid
            do System.out.println("Please enter the position you choose");
            while (!board.setBoard(scan.nextInt(), turn));

            board.show();

            turn = turn.equals("O") ? "X" : "O";
        }

    }


}
