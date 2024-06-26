package baekjoon.chanhyeng.weeks8;

import java.io.*;
import java.util.Arrays;

/**
 * <p> n자리의 오르막수가 나올수 있는 경우의 수를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/11057"/>Baekjoon_11057 오르막 수</a>
 */
public class Baekjoon11057 {

  /**
   * <p> dp[n][i] = dp[n][i-1] + [n-1][i]
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    int result = 0;

    int[][] dp = new int[N + 1][10];
    dp[1][0] = 1;

    Arrays.fill(dp[1], 1);

    for (int i = 2; i <= N; i++) {
      dp[i][0] = 1;
      for (int j = 1; j < 10; j++) {
        dp[i][j] = (dp[i - 1][j] % 10007 + dp[i][j - 1] % 10007) % 10007;
      }
    }

    for (int i = 0; i < 10; i++) {
      result += dp[N][i];
    }

    bw.write(String.valueOf(result % 10007));
    bw.flush();
    bw.close();
    br.close();
  }
}
