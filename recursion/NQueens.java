package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NQueens {

    /*
      Platform : LeetCode

      Question : N-Queens

      Pattern  : Recursion + Backtracking

      Approach :
      Row-wise Backtracking with Hashing

      Idea :
      - Place one queen in each row.
      - For every column in the current row,
        check whether placing a queen is safe.
      - Use three hash arrays to check
        conflicts in O(1):
          • Column
          • Upper Diagonal
          • Lower Diagonal
      - If the position is safe:
          • Place the queen.
          • Mark the column and diagonals.
          • Recur for the next row.
      - After returning, remove the queen
        and unmark the column and diagonals
        (Backtracking).
      - When all queens are placed,
        store the current board.

      Time Complexity :
      O(N!)

      Space Complexity :
      O(N²)

      (Board + Hash Arrays +
      Recursive Call Stack)
    */

    private List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];

        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        int[] col = new int[n];
        int[] upperDiagonal = new int[2 * n - 1];
        int[] lowerDiagonal = new int[2 * n - 1];

        solve(0, board, col, upperDiagonal, lowerDiagonal, n);

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

        for (int c = 0; c < n; c++) {

            // Safe Position
            if (col[c] == 0 &&
                lowerDiagonal[row + c] == 0 &&
                upperDiagonal[n - 1 + row - c] == 0) {

                // Place Queen
                board[row][c] = 'Q';

                col[c] = 1;
                lowerDiagonal[row + c] = 1;
                upperDiagonal[n - 1 + row - c] = 1;

                // Recursive Call
                solve(row + 1, board,
                      col,
                      upperDiagonal,
                      lowerDiagonal,
                      n);

                // Backtrack
                board[row][c] = '.';

                col[c] = 0;
                lowerDiagonal[row + c] = 0;
                upperDiagonal[n - 1 + row - c] = 0;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        NQueens obj = new NQueens();

        List<List<String>> ans = obj.solveNQueens(n);

        for (List<String> board : ans) {

            for (String row : board) {
                System.out.println(row);
            }

            System.out.println();
        }

        sc.close();
    }
}