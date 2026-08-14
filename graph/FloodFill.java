package graph;

public class FloodFill {

    /*
      Platform : LeetCode

      Question : Flood Fill

      Pattern  : Graph Traversal

      Approach :
      Depth First Search (DFS)

      Idea :
      - Store the original color of
        the starting cell.
      - If oldColor and newColor are
        the same, return the image.
      - Start DFS from the given
        starting row and column.
      - Check whether the current
        cell is inside the matrix.
      - If the cell does not have
        the old color, stop.
      - Change the current cell to
        the new color.
      - Recursively visit all four
        directions:
          Up, Down, Left, Right.

      Time Complexity :
      O(m * n)

      Space Complexity :
      O(m * n)

      (Recursive Call Stack)
    */

    public int[][] floodFill(int[][] image,
                             int sr,
                             int sc,
                             int color) {

        int oldColor =
                image[sr][sc];

        if (oldColor == color) {
            return image;
        }

        dfs(image,
            sr,
            sc,
            oldColor,
            color);

        return image;
    }

    public void dfs(int[][] image,int row,int col,int oldColor,int newColor) {

        if (row < 0|| row >= image.length|| col < 0|| col >= image[0].length) {

            return;
        }

        if (image[row][col] != oldColor) {
            return;
        }

        image[row][col] = newColor;

        dfs(image,
            row - 1,
            col,
            oldColor,
            newColor);

        dfs(image,
            row + 1,
            col,
            oldColor,
            newColor);

        dfs(image,
            row,
            col - 1,
            oldColor,
            newColor);

        dfs(image,
            row,
            col + 1,
            oldColor,
            newColor);
    }

    public static void main(String[] args) {

        FloodFill obj =
                new FloodFill();

        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };

        int sr = 1;
        int sc = 1;
        int color = 2;

        int[][] result =
                obj.floodFill(image,
                              sr,
                              sc,
                              color);

        System.out.println(
                "Flood Filled Image :");

        for (int i = 0;
             i < result.length;
             i++) {

            for (int j = 0;
                 j < result[0].length;
                 j++) {

                System.out.print(
                        result[i][j] + " ");
            }

            System.out.println();
        }
    }
}