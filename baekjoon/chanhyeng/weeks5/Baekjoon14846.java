package baekjoon.chanhyeng.weeks5;

import java.io.*;
import java.util.StringTokenizer;

/**
 * <p> 행렬이 주어지고 쿼리가 주어질 때 해당 쿼리에 해당하는 범위이 행렬에서 서로 다른 정수의 개수를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/14846"/>Baekjoon_14846 직사각형과 쿼리</a>
 */
public class Baekjoon14846 {
  /**
   * <p> 이 문제는 도저히 해결책을 도출할 수 없어 검색해서 접근법을 찾아 보았다.
   * <p> 접근법을 보아도 이해가 되지 않아 약 2일에 걸쳐 보고 또 보고 써보면서 이해를 했다.
   * <p> 2차원 배열에 각 좌표에 해당하는 자연수의 개수를 누적합을 이용해서 저장한 후 문제를 해결하는 것이었다.
   * <p> 해당 좌표까지 자연수의 개수의 누적합을 3차원 배열을 통해 저장한다.
   * <p> x, y 까지의 누적합을 만들때 사용한 점화식은 dp[x-1][y][k] + dp[x][y-1][k] - dp[x-1][y-1][k]를 이용했다.
   * <p> 그 후 주어진 좌표(x2, y2)에 해당하는 자연수들의 누적합을 배열에 저장한다.
   * <p> 그리고 시작좌표(x1, y1)에 해당 하지 않는 누적합들은 뺴줘야 하므로 - dp[x2][y1 - 1][k] - dp[x2][y1 - 1] + dp[x1 - 1][y1 -1][k]를 해준다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    int[][][] dp = new int[N+1][N+1][11];

    for(int i=1;i<=N;i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j=1;j<=N;j++) {
        int num = Integer.parseInt(st.nextToken());
        for(int k=1;k<=10;k++) {
          dp[i][j][k] = dp[i-1][j][k] + dp[i][j-1][k] - dp[i-1][j-1][k];
        }
        dp[i][j][num]++;
      }
    }

    int Q = Integer.parseInt(br.readLine());

    for (int i = 0; i < Q; i++) {
      int result = 0;
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      int[] temp = new int[11];

      for (int j = 1; j < 11; j++) {
        temp[j] = dp[x2][y2][j];
      }

      for (int j = 1; j < 11; j++) {
        temp[j] = temp[j] - dp[x2][y1 - 1][j] - dp[x1 - 1][y2][j] + dp[x1 - 1][y1 - 1][j];
      }

      for (int j = 1; j < 11; j++) {
        if (temp[j] > 0) {
          result++;
        }
      }

      bw.write(String.valueOf(result));
      bw.newLine();
    }

    bw.flush();
    bw.close();
    br.close();
  }
}
