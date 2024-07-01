package baekjoon.chanhyeng.weeks8;

import java.io.*;

/**
 * <p> 계단 오르기 규칙에 맞게 오를 떄 가장 높은 점수를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/2579"/>Baekjoon_2579 계단 오르기</a>
 */
public class Baekjoon2579 {
  /**
   * <p> 조건에서 마지막 계단은 무조건 밟아야 한다.
   * <p> 또한 조건에서 최대 2개의 연속된 계단을 밟을 수 있다고 하였으니
   * <p> 마지막 계단을 n으로 두면 마지막 계딴을 밟을 수 있는 경우는 (n-1)번째 계단을 밟거나 (n-2)번째 계단을 밟고 오는 경우이다.
   * <p> n-1번째에 서 올라온 경우 n-1번째 계단을 이용하면 연속된 계단이므로 n-3에서 n-1로 올라왔음을 알 수 있다.
   * <p> 따라서 계단 점수 배열과 각 계단의 최대점수를 저장해두는 배열을 두고점화식을 세워 계산한다.
   * <p> dp[n] = max(dp[n-2] + stair[n], dp[n-3] + stair[n-1] + stair[n])이 된다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int[] stair = new int[n + 1];
    int[] dp = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      stair[i] = Integer.parseInt(br.readLine());
    }

    if (n < 3) {
      int sum = 0;
      for (int i = 0; i <= n; i++) {
        sum += stair[i];
      }
      bw.write(String.valueOf(sum));
      bw.flush();
      bw.close();
      return;
    }

    // dp[3]까지는 직접 구해서 저장해줘야 나머지 계산이 가능하다.
    dp[1] = stair[1];
    dp[2] = stair[1] + stair[2];
    dp[3] = Math.max(stair[1] + stair[3], stair[2] + stair[3]);

    for (int i = 4; i <= n; i++) {
      dp[i] = Math.max(dp[i - 3] + stair[i - 1] + stair[i], dp[i - 2] + stair[i]);
    }

    bw.write(String.valueOf(dp[n]));
    bw.flush();
    bw.close();
    br.close();
  }
}
