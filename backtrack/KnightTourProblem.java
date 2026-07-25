package backtrack;

import java.util.ArrayList;
import java.util.Arrays;

public class KnightTourProblem {

    /*
      Platform : GeeksforGeeks

      Question : The Knight's Tour Problem

      Pattern  : Backtracking

      Approach :
      DFS + Backtracking

      Idea :
      - Start the knight from the
        top-left cell (0, 0).
      - Mark the starting cell
        with move number 0.
      - At every step, try all
        8 possible knight moves.
      - Move only to a cell that is:
          1. Inside the board.
          2. Not visited.
      - Mark the current move number.
      - Recursively continue with
        the next move.
      - If all cells are visited,
        the tour is complete.
      - If no move leads to a
        solution, remove the move
        (Backtrack) and try the
        next possible move.

      Time Complexity :
      O(8^(N²))

      Space Complexity :
      O(N²)

      (Chess Board +
       Recursive Call Stack)
    */

    int[] dr = {-2, -1, 1, 2, 2, 1, -1, -2};

    int[] dc = {1, 2, 2, 1, -1, -2, -2, -1};

    public ArrayList<ArrayList<Integer>> knightTour(int n) {

        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], -1);
        }

        // Starting Position
        board[0][0] = 0;

        if (!solve(board, 0, 0, 1, n)) {
            return new ArrayList<>();
        }

        ArrayList<ArrayList<Integer>> ans =
                new ArrayList<>();

        for (int i = 0; i < n; i++) {

            ArrayList<Integer> row =
                    new ArrayList<>();

            for (int j = 0; j < n; j++) {
                row.add(board[i][j]);
            }

            ans.add(row);
        }

        return ans;
    }

    private boolean solve(int[][] board,
                          int row,
                          int col,
                          int move,
                          int n) {

        // All Cells Visited
        if (move == n * n) {
            return true;
        }

        // Try All 8 Knight Moves
        for (int i = 0; i < 8; i++) {

            int newRow = row + dr[i];
            int newCol = col + dc[i];

            if (isSafe(board,
                       newRow,
                       newCol,
                       n)) {

                // Place Move
                board[newRow][newCol] = move;

                // Explore
                if (solve(board,
                          newRow,
                          newCol,
                          move + 1,
                          n)) {

                    return true;
                }

                // Backtrack
                board[newRow][newCol] = -1;
            }
        }

        return false;
    }

    private boolean isSafe(int[][] board,
                           int row,
                           int col,
                           int n) {

        return row >= 0 &&
               row < n &&
               col >= 0 &&
               col < n &&
               board[row][col] == -1;
    }

    public static void main(String[] args) {

        KnightTourProblem obj =
                new KnightTourProblem();

        int n = 5;

        ArrayList<ArrayList<Integer>> result =
                obj.knightTour(n);

        if (result.isEmpty()) {

            System.out.println("No Solution Exists");

        } else {

            System.out.println("Knight Tour:");

            for (ArrayList<Integer> row : result) {
                System.out.println(row);
            }
        }
    }
}