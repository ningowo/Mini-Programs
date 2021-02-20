package CS5004.HW2;

import java.util.Random;
import java.util.Scanner;

public class TheGameofPig {

    int humanPoints = 0;
    int pcPoints = 0;
    boolean flag = true; // true - human, flase - pc

    Random random = new Random();
    Scanner scan = new Scanner(System.in);

    public void game() {

        while (true) {
            System.out.println("-Human's turn");
            humanRound();
            if (humanPoints >= 100) {
                System.out.println("Human wins!");
                break;
            }
            System.out.println("\n-Computer's turn");
            pcRound();
            if (pcPoints >= 100) {
                System.out.println("Computer wins!");
                break;
            }

        }
    }

    private void humanRound() {
        int r = 2;
        int roundPoint = 0;

        while (humanPoints < 100 && r != 1) {
            r = random.nextInt(6) + 1;
            System.out.println("Human rolls " + r);
            System.out.printf("Human points: %d, Conputer points: %d\n", humanPoints, pcPoints);

            if (r == 1) break; // when rolls 1, ends without points
            roundPoint += r; // continue with points

            System.out.println("Please input “r” to roll again or “h” to hold");
            // if hold, add all points and ends
            if (scan.next().charAt(0) == 'h') {
                humanPoints += roundPoint;
                break;
            }
            // else roll again

        } // end while
    }

    private void pcRound() {
        int r = 2;
        int roundPoint = 0;

        while (pcPoints < 100 && r != 1) {
            r = random.nextInt(6) + 1;

            if (r == 1) break; // when rolls 1, ends without points
            roundPoint += r; // else continue with points

            if (roundPoint >= 20) {
                pcPoints += roundPoint;
                break;
            }

        } // end while
    }


    public static void main(String[] args) {
        TheGameofPig p = new TheGameofPig();
        TheGameofPig.game();
    }
}
