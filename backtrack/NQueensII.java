package backtrack;

import java.util.Arrays;

public class NQueensII {

    /*
      Platform : LeetCode

      Question : N-Queens II

      Pattern  : Backtracking

      Approach :
      Place Queen Row by Row

      Idea :
      - Place one queen in each row.
      - Try placing the queen in
        every column of the current row.
      - Before placing, check whether
        the position is safe.
      - A position is safe if there is
        no queen in:
          1. Same Column
          2. Upper Left Diagonal
          3. Upper Right Diagonal
      - If the position is safe,
        place the queen and move
        to the next row.
      - Remove the queen after
        recursion (Backtrack).
      - When queens are placed in
        all rows, increase the count.

      Time Complexity :
      O(N!)

      Space Complexity :
      O(N²)

      (Chess Board +
       Recursive Call Stack)
    */

    int count = 0;

    public int totalNQueens(int n) {

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        backtrack(board, 0, n);

        return count;
    }

    private void backtrack(char[][] board,
                           int row,
                           int n) {

        // Base Case
        if (row == n) {

            count++;

            return;
        }

        // Try Every Column
        for (int col = 0; col < n; col++) {

            if (isSafe(board, row, col, n)) {

                // Place Queen
                board[row][col] = 'Q';

                // Explore
                backtrack(board,
                          row + 1,
                          n);

                // Backtrack
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(char[][] board,
                           int row,
                           int col,
                           int n) {

        // Check Same Column
        for (int i = 0; i < row; i++) {

            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check Upper Left Diagonal
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0;
             i--, j--) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check Upper Right Diagonal
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n;
             i--, j++) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        NQueensII obj = new NQueensII();

        int n = 4;

        int result = obj.totalNQueens(n);

        System.out.println("Total Valid Arrangements : " + result);
    }
}