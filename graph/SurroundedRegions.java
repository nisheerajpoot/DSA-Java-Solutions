package graph;

public class SurroundedRegions {

    /*
      Platform : LeetCode

      Question : Surrounded Regions

      Pattern  : Graph Traversal

      Approach :
      Depth First Search (DFS)

      Idea :
      - Traverse all boundary cells.
      - If a boundary cell contains
        'O', start DFS from it.
      - Mark all connected boundary
        'O' cells as 'S'.
      - These cells cannot be
        surrounded by 'X'.
      - After DFS:
          'O' -> 'X'
          'S' -> 'O'

      Time Complexity :
      O(rows * cols)

      Space Complexity :
      O(rows * cols)

      (Recursive Call Stack)
    */

    public void solve(char[][] board) {

        int rows =board.length;

        int cols =board[0].length;

        // Check First and Last Row
        for (int col = 0;
             col < cols;
             col++) {

            if (board[0][col] == 'O') {
                dfs(board,0,col);
            }

            if (board[rows - 1][col] == 'O') {

                dfs(board,rows - 1,
                    col);
            }
        }

        // Check First and Last Column
        for (int row = 0;
             row < rows;
             row++) {

            if (board[row][0] == 'O') {

                dfs(board,
                    row,
                    0);
            }

            if (board[row][cols - 1] == 'O') {

                dfs(board,
                    row,
                    cols - 1);
            }
        }

        // Convert Cells
        for (int row = 0;
             row < rows;
             row++) {

            for (int col = 0;
                 col < cols;
                 col++) {

                if (board[row][col] == 'O') {

                    board[row][col] = 'X';
                }

                else if (board[row][col] == 'S') {

                    board[row][col] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board,
                    int row,
                    int col) {

        if (row < 0
                || row >= board.length
                || col < 0
                || col >= board[0].length) {

            return;
        }

        if (board[row][col] != 'O') {

            return;
        }

        board[row][col] = 'S';

        dfs(board,
            row - 1,
            col);

        dfs(board,
            row + 1,
            col);

        dfs(board,
            row,
            col - 1);

        dfs(board,
            row,
            col + 1);
    }

    public static void main(String[] args) {

        SurroundedRegions obj =
                new SurroundedRegions();

        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        obj.solve(board);

        System.out.println(
                "Updated Board :");

        for (int row = 0;
             row < board.length;
             row++) {

            for (int col = 0;
                 col < board[0].length;
                 col++) {

                System.out.print(
                        board[row][col] + " ");
            }

            System.out.println();
        }
    }
}