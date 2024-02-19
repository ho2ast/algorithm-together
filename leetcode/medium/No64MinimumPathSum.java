package leetcode.medium;

/**
 * <p> 2차원 배열이 주어 질 때 0, 0에서 m, n 까지 경로의 최소합을 구하세요.
 * <p> 문제 바로가기: <a href="https://leetcode.com/problems/minimum-path-sum/description/" />64. Minimum Path Sum</a>
 */
public class No64MinimumPathSum {

  /**
   * <p> 2차원 배열에서 오른쪽 또는 아랫쪽으로만 움직일 수 있다.
   * <p> 2차원 배열의 첫행과 첫열은 이전값으로 더해서 값을 넣어준다.
   * <p> 이전행 이전열값중 작은값으로 해당값과 더해준다.
   */
  public int minPathSum(int[][] grid) {
    for (int i = 1; i < grid.length; i++) {
      grid[i][0] += grid[i - 1][0];
    }

    for (int i = 1; i < grid[0].length; i++) {
      grid[0][i] += grid[0][i - 1];
    }

    for (int i = 1; i < grid.length; i++) {
      for (int j = 1; j < grid[i].length; j++) {
        grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
      }
    }
    return grid[grid.length - 1][grid[0].length - 1];
  }
}
