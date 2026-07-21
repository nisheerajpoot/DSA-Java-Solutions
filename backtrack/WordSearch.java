package backtrack;

public class WordSearch {

    /*
      Platform : LeetCode

      Question : Word Search

      Pattern  : Backtracking

      Approach :
      DFS + Backtracking

      Idea :
      - Start DFS from every cell
        of the board.
      - If the current character
        matches the required
        character in the word,
        continue searching.
      - Mark the current cell as
        visited so it cannot be
        reused in the same path.
      - Explore all four directions:
          1. Up
          2. Down
          3. Left
          4. Right
      - Restore the original
        character after recursion
        (Backtrack).
      - If all characters of the
        word are matched, return
        true.

      Time Complexity :
      O(m × n × 4ᴸ)

      Space Complexity :
      O(L)

      (Recursive Call Stack)

      Where :
      m = Number of Rows
      n = Number of Columns
      L = Length of the Word
    */

    public boolean exist(char[][] board,
                         String word) {

        int rows = board.length;
        int cols = board[0].length;

        // Try Every Starting Cell
        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {

                if (dfs(board,
                        word,
                        row,
                        col,
                        0)) {

                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board,
                        String word,
                        int row,
                        int col,
                        int index) {

        // All Characters Matched
        if (index == word.length()) {
            return true;
        }

        // Invalid Cell
        if (row < 0 ||
            col < 0 ||
            row >= board.length ||
            col >= board[0].length) {

            return false;
        }

        // Character Does Not Match
        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        // Mark as Visited
        char temp = board[row][col];
        board[row][col] = '#';

        // Explore Four Directions
        boolean found =
                dfs(board, word, row - 1, col, index + 1) || // Up
                dfs(board, word, row + 1, col, index + 1) || // Down
                dfs(board, word, row, col - 1, index + 1) || // Left
                dfs(board, word, row, col + 1, index + 1);   // Right

        // Backtrack
        board[row][col] = temp;

        return found;
    }

    public static void main(String[] args) {

        WordSearch obj = new WordSearch();

        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String word = "ABCCED";

        boolean result = obj.exist(board, word);

        System.out.println("Word Exists : " + result);
    }
}