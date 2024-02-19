package leetcode.medium;

/**
 * <p> 2차원 배열이 주어 질 때 로봇이 이동할 수 있는 경우의 수를 구하세요.
 * <p> 문제 바로가기: <a href="https://leetcode.com/problems/unique-paths/description/" />62. Unique Paths</a>
 */
public class No62UniquePaths {

  public static void main(String[] args) {
    uniquePaths(3, 2);
  }

  /**
   * <p> 2차원 배열에서 오른쪽 또는 아랫쪽으로만 움직일 수 있다.
   * <p> DP를 이용하여 경우의 수를 구한다.
   * <p> 첫번째 열과 첫번째 행을 1로 초기화한 m*n 배열을 사용한다.
   */
  public static int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];

    for (int i = 0; i < n; i++) {
      dp[0][i] = 1;
    }

    for (int i = 0; i < m; i++) {
      dp[i][0] = 1;
    }

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (dp[i][j] != 1) {
          dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
      }
    }
    return dp[m - 1][n - 1];
  }
}
