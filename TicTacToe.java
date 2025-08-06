import java.util.Scanner;

public class TicTacToe {

    static char[][] board = {
        {' ', '|', ' ', '|', ' '},
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '},
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char currentPlayer = 'X';

        while (true) {
            printBoard();
            System.out.println("Player " + currentPlayer + ", enter your move (1-9): ");
            int move = scanner.nextInt();

            if (placeMove(move, currentPlayer)) {
                if (checkWinner(currentPlayer)) {
                    printBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                }

                if (isBoardFull()) {
                    printBoard();
                    System.out.println("It's a draw!");
                    break;
                }

                // Switch player
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }

        scanner.close();
    }

    // Print the board
    public static void printBoard() {
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    // Place the move on the board
    public static boolean placeMove(int pos, char symbol) {
        int row = 0, col = 0;

        switch (pos) {
            case 1: row = 0; col = 0; break;
            case 2: row = 0; col = 2; break;
            case 3: row = 0; col = 4; break;
            case 4: row = 2; col = 0; break;
            case 5: row = 2; col = 2; break;
            case 6: row = 2; col = 4; break;
            case 7: row = 4; col = 0; break;
            case 8: row = 4; col = 2; break;
            case 9: row = 4; col = 4; break;
            default: return false;
        }

        if (board[row][col] == ' ') {
            board[row][col] = symbol;
            return true;
        } else {
            return false;
        }
    }

    // Check for a winner
    public static boolean checkWinner(char symbol) {
        // Horizontal, vertical, diagonal
        return (
            (board[0][0] == symbol && board[0][2] == symbol && board[0][4] == symbol) ||
            (board[2][0] == symbol && board[2][2] == symbol && board[2][4] == symbol) ||
            (board[4][0] == symbol && board[4][2] == symbol && board[4][4] == symbol) ||

            (board[0][0] == symbol && board[2][0] == symbol && board[4][0] == symbol) ||
            (board[0][2] == symbol && board[2][2] == symbol && board[4][2] == symbol) ||
            (board[0][4] == symbol && board[2][4] == symbol && board[4][4] == symbol) ||

            (board[0][0] == symbol && board[2][2] == symbol && board[4][4] == symbol) ||
            (board[0][4] == symbol && board[2][2] == symbol && board[4][0] == symbol)
        );
    }

    // Check if board is full (draw)
    public static boolean isBoardFull() {
        for (int i = 0; i <= 4; i += 2) {
            for (int j = 0; j <= 4; j += 2) {
                if (board[i][j] == ' ') return false;
            }
        }
        return true;
    }
}
