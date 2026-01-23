import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        char[][] board = new char[6][7];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = '.';
            }
        }

        char player = 'X';
        boolean playing = true;
        int turn = 0;
        while (playing == true) {
            // print board
            printBoard(board);
            // ask the current player what column to drop into
            System.out.println("Player " + player);
            System.out.println("Which column?");
            Scanner keyboard = new Scanner(System.in);
            int col = keyboard.nextInt();
            turn++;
            
            // change the board to reflect the player's action

            if (board[5][col] == '.') {
                board[5][col] = player;
            } else if (board[4][col] == '.') {
                board[4][col] = player;
            } else if (board[3][col] == '.') {
                board[3][col] = player;
            } else if (board[2][col] == '.') {
                board[2][col] = player;
            } else if (board[1][col] == '.') {
                board[1][col] = player;
            } else {
                System.out.println("Column full!");
                System.out.println("Pick again");
            }

            // determine if the current player won

            // backward diagonals
            char winner = '.';
            for (int startRow = 5; startRow < 2; startRow--) {
                for (int startCol = 0; startCol < 4; startCol++) {
                    char check = board[startRow][startCol];
                    if (check != '.' && check == board[startRow - 1][startCol + 1] &&
                            check == board[startRow - 2][startCol + 2] && check == board[startRow - 3][startCol + 3]) {
                        winner = check;
                        if (check != '.') {
                            printBoard(board);
                            System.out.println(player + " wins!");
                            playing = false;
                        }
                    }

                }

            }

            // forward diagonals
            winner = '.';
            for (int startRow = 0; startRow < 3; startRow++) {
                for (int startCol = 0; startCol < 4; startCol++) {
                    char check = board[startRow][startCol];
                    if (check != '.' && check == board[startRow + 1][startCol + 1] &&
                            check == board[startRow + 2][startCol + 2] && check == board[startRow + 3][startCol + 3]) {
                        winner = check;
                        if (check != '.') {
                            printBoard(board);
                            System.out.println(player + " wins!");
                            playing = false;
                        }
                    }

                }

            }

            // vertical check
            for (int startRow = 0; startRow < 3; startRow++) {
                for (int startCol = 0; startCol < 7; startCol++) {
                    char check = board[startRow][startCol];
                    if (check != '.' && check == board[startRow + 1][startCol] &&
                            check == board[startRow + 2][startCol] && check == board[startRow + 3][startCol]) {
                        winner = check;
                        if (check != '.') {
                            printBoard(board);
                            System.out.println(player + " wins!");
                            playing = false;
                        }
                    }
                }
            }

            // horizantal check
            for (int startRow = 0; startRow < 6; startRow++) {
                for (int startCol = 0; startCol < 4; startCol++) {
                    char check = board[startRow][startCol];
                    if (check != '.' && check == board[startRow][startCol + 1] &&
                            check == board[startRow][startCol + 2] && check == board[startRow][startCol + 3]) {
                        winner = check;
                        if (check != '.') {
                            printBoard(board);
                            System.out.println(player + " wins!");
                            playing = false;
                        }
                    }
                }
            }


    //draw
        if (turn == 42){
            System.out.println("It's a draw!");
        }

            // switch players
            if (player == 'X') {
                player = 'O';
            } else { // player must currently be O
                player = 'X';
            }
        }
    }

    public static void printBoard(char[][] b) {
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                System.out.print("|" + b[i][j]);
            }
            System.out.println("|");
        }

    }
}
