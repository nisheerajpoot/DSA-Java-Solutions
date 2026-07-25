package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    /*
      Platform : LeetCode

      Question : N-Queens

      Pattern  : Backtracking

      Approach :
      Optimized Backtracking
      (Using Column and Diagonal Arrays)

      Idea :
      - Place one queen in each row.
      - Instead of checking the entire
        board, maintain three arrays:
          1. Column Array
          2. Upper Diagonal Array
          3. Lower Diagonal Array
      - If a position is safe,
        place the queen.
      - Mark the corresponding
        column and diagonals as used.
      - Recursively place queens
        in the next row.
      - After recursion, remove the
        queen and unmark the arrays
        (Backtrack).
      - When queens are placed in
        all rows, convert the board
        into a list of strings and
        store it.

      Time Complexity :
      O(N!)

      Space Complexity :
      O(N²)

      (Chess Board +
       Helper Arrays +
       Recursive Call Stack)
    */

    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];

        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        int[] col = new int[n];

        int[] upperDiagonal = new int[2 * n - 1];

        int[] lowerDiagonal = new int[2 * n - 1];

        solve(0,
              board,
              col,
              upperDiagonal,
              lowerDiagonal,
              n);

        return ans;
    }

    private void solve(int row,
                       char[][] board,
                       int[] col,
                       int[] upperDiagonal,
                       int[] lowerDiagonal,
                       int n) {

        // Base Case
        if (row == n) {

            List<String> temp = new ArrayList<>();

            for (char[] r : board) {
                temp.add(new String(r));
            }

            ans.add(temp);

            return;
        }

        // Try Every Column
        for (int currentCol = 0;
             currentCol < n;
             currentCol++) {

            if (col[currentCol] == 0 &&
                lowerDiagonal[row + currentCol] == 0 &&
                upperDiagonal[n - 1 + row - currentCol] == 0) {

                // Place Queen
                board[row][currentCol] = 'Q';

                col[currentCol] = 1;
                lowerDiagonal[row + currentCol] = 1;
                upperDiagonal[n - 1 + row - currentCol] = 1;

                // Explore
                solve(row + 1,
                      board,
                      col,
                      upperDiagonal,
                      lowerDiagonal,
                      n);

                // Backtrack
                board[row][currentCol] = '.';

                col[currentCol] = 0;
                lowerDiagonal[row + currentCol] = 0;
                upperDiagonal[n - 1 + row - currentCol] = 0;
            }
        }
    }

    public static void main(String[] args) {

        NQueens obj = new NQueens();

        int n = 4;

        List<List<String>> result =
                obj.solveNQueens(n);

        System.out.println("All Possible Solutions:");

        for (List<String> board : result) {

            for (String row : board) {
                System.out.println(row);
            }

            System.out.println();
        }
    }
}