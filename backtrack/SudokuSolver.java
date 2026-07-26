package backtrack;

import java.util.Arrays;

public class SudokuSolver {

    /*
      Platform : LeetCode

      Question : Sudoku Solver

      Pattern  : Backtracking

      Approach :
      Try Every Possible Number
      Using Backtracking

      Idea :
      - Traverse the Sudoku board.
      - Find the first empty cell
        represented by '.'.
      - Try placing digits from
        '1' to '9'.
      - Before placing a digit,
        check whether it is valid.
      - A digit is valid if it is
        not present in:
          1. Same Row
          2. Same Column
          3. Same 3 × 3 Subgrid
      - If valid, place the digit
        and recursively solve the
        remaining board.
      - If no digit works, remove
        the digit (Backtrack) and
        try the next one.
      - When no empty cells remain,
        the Sudoku is solved.

      Time Complexity :
      O(9^(Empty Cells))

      Space Complexity :
      O(Empty Cells)

      (Recursive Call Stack)
    */

    public void solveSudoku(char[][] board) {

        solve(board);
    }

    private boolean solve(char[][] board) {

        // Traverse Entire Board
        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                // Empty Cell Found
                if (board[row][col] == '.') {

                    // Try Digits 1 to 9
                    for (char ch = '1';
                         ch <= '9';
                         ch++) {

                        if (isValid(board,
                                    row,
                                    col,
                                    ch)) {

                            // Place Digit
                            board[row][col] = ch;

                            // Explore
                            if (solve(board)) {
                                return true;
                            }

                            // Backtrack
                            board[row][col] = '.';
                        }
                    }

                    // No Valid Digit Found
                    return false;
                }
            }
        }

        // Sudoku Solved
        return true;
    }

    private boolean isValid(char[][] board,
                            int row,
                            int col,
                            char ch) {

        // Check Row
        for (int i = 0; i < 9; i++) {

            if (board[row][i] == ch) {
                return false;
            }
        }

        // Check Column
        for (int i = 0; i < 9; i++) {

            if (board[i][col] == ch) {
                return false;
            }
        }

        // Check 3 × 3 Subgrid
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow;
             i < startRow + 3;
             i++) {

            for (int j = startCol;
                 j < startCol + 3;
                 j++) {

                if (board[i][j] == ch) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void printBoard(char[][] board) {

        for (char[] row : board) {

            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {

        SudokuSolver obj = new SudokuSolver();

        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println("Solved Sudoku:");

        obj.solveSudoku(board);

        printBoard(board);
    }
}