import java.util.*;
public class TicTacToe{
    public static boolean checkWin(char player) {
    // Check rows
    for (int i = 0; i < 3; i++) {
        if (board[i][0] == player && board[i][1] == player && board[i][2] == player)
            return true;
    }

    // Check columns
    for (int j = 0; j < 3; j++) {
        if (board[0][j] == player && board[1][j] == player && board[2][j] == player)
            return true;
    }

    // Check diagonals
    if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
        return true;

    if (board[0][2] == player && board[1][1] == player && board[2][0] == player)
        return true;

    return false;
}
public static boolean isBoardFull() {
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (board[i][j] == ' ')
                return false;
        }
    }
    return true;
}

    static char[][] board = {
        { ' ', ' ', ' ' },
        { ' ', ' ', ' ' },
        { ' ', ' ', ' ' }
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    char currentPlayer = 'X';

    while (true) {
        printBoard();
        System.out.println("Player " + currentPlayer + ", enter your position (1-9): ");
        int position = sc.nextInt();

        if (position < 1 || position > 9) {
            System.out.println("Invalid position. Try again.");
            continue;
        }

        int row = (position - 1) / 3;
        int col = (position - 1) % 3;

        if (board[row][col] != ' ') {
            System.out.println("Position already taken. Try again.");
            continue;
        }

        board[row][col] = currentPlayer;

        // ✅ Check if current player wins
        if (checkWin(currentPlayer)) {
            printBoard();
            System.out.println("🎉 Player " + currentPlayer + " wins!");
            break;
        }

        // ✅ Check for draw
        if (isBoardFull()) {
            printBoard();
            System.out.println("It's a draw!");
            break;
        }

        // 🔁 Switch players
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    sc.close(); // good practice
    }

    public static void printBoard(){
        System.out.println("-------------");
        for(int i = 0 ; i < 3 ; i++){
            System.out.print("| ");
            for(int j = 0 ; j < 3 ; j++){
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
}