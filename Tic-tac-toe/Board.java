package CS5004.HW5;

public class Board {
    static String[] board = new String[10]; // leave 0 empty

    public Board() {
        for (int i = 1; i < board.length; i++) {
            board[i] = Integer.toString(i);
        }
    }

    public boolean setBoard (int i, String s) {
        if (i < 1 || i > 9) {
            System.out.println("Invalid input, please enter again ;)");
            return false;
        }
        if (board[i].equals("X") || board[i].equals("O")) {
            System.out.println("Sorry, this place has already been chosen, please choose another one.");
            return false;
        }
        board[i] = s;
        return true;
    }

    public void show() {
        for (int i = 1; i < board.length; i++) {
            System.out.print(board[i] + "  ");
            if ((i) % 3 == 0) System.out.println();
        }
    }

    public String checkWin() {
        for (int i = 1; i < 4; i++) { // check column
            if (board[i].equals(board[i + 3]) && board[i].equals(board[i + 6])) return board[i];
        }
        for (int i = 1; i < 8; i+=3) { // check row
            if (board[i].equals(board[i + 1]) && board[i].equals(board[i + 2])) return board[i];
        }
        // check diagonal
        if ((board[1].equals(board[5]) && board[1].equals(board[9])) ||
                (board[3].equals(board[5]) && board[3].equals(board[7]))) {
            return board[5];
        }
        return null;
    }
}




