package leetcode.medium;

public class No200NumberOfIslands {

  public static void main(String[] args) {
    char[][] arr = {
        {'1', '1', '1', '1', '0'}
        ,
        {'1', '1', '0', '1', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '0', '0', '0'}
    };

    System.out.println(numIslands(arr));
  }

  private static final int[] axisX = {0, 0, -1, 1};
  private static final int[] axisY = {-1, 1, 0, 0};
  private static boolean[][] visited;

  public static int numIslands(char[][] grid) {
    int result = 0;
    visited = new boolean[grid.length][grid[0].length];

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == '1' && !visited[i][j]) {
          dfs(i, j, grid);
          result++;
        }
      }
    }

    return result;
  }

  public static void dfs(int y, int x, char[][] grid) {
    visited[y][x] = true;

    for (int i = 0; i < 4; i++) {
      int dirX = axisX[i] + x;
      int dirY = axisY[i] + y;

      if (dirX > -1 && dirY > -1 && dirX < grid[0].length && dirY < grid.length && grid[dirY][dirX] == '1' && !visited[dirY][dirX]) {
        dfs(dirY, dirX, grid);
      }
    }
  }
}
