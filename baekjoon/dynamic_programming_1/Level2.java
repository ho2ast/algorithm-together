package baekjoon.dynamic_programming_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <p> 재귀함수 w(a, b, c)가 주어질 때 w(a, b, c)를 출력 하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/9184"/>Baekjoon_9184 신나는 함수 실행</a>
 */
public class Level2 {
  static int[][][] dp = new int[21][21][21];
  /**
   * <p>주어진 재귀함수를 직접 구현하여 출력한다.
   * <p>동적계획법에서 중요한 메모이제이션을 이용하여 해결한다.
   * <p>조건에서 세 수 중 하나라도 0보다 작으면 1을 반환하고, 20보다 크면 w(20, 20, 20)을 반환한다.
   * <p>따라서 int[21][21][21]의 배열에 값을 저장해두고 이미 값이 저장되어 있으면 꺼내 쓰도록 한다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    while(true) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      if (a == -1 && b == -1 && c == -1) {
        break;
      }

      int result = w(a, b, c);
      sb.append(String.format("w(%d, %d, %d) = %d", a, b, c, result)).append("\n");
    }
    System.out.println(sb);
  }

  private static int w(int a, int b, int c) {
    if (0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20 && dp[a][b][c] != 0) {
      return dp[a][b][c];
    }

    if (a <= 0 || b <= 0 || c <= 0) {
      return 1;
    }

    if (a > 20 || b > 20 || c > 20) {
      return dp[20][20][20] = w(20, 20, 20);
    }

    if (a < b && b < c) {
      return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
    }

    return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
  }
}
