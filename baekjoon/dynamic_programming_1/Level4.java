package baekjoon.dynamic_programming_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p> 파도반 수열이 주어 질 때 P(N)의 값을 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/9461"/>Baekjoon_9461 파도반 수열</a>
 */
public class Level4 {
  static long[] dp = new long[101];
  /**
   * <p>주어질 수열의 규칙을 찾아보자.
   * <p>1, 1, 1, 2, 2, 3, 4, 5, 7, 9
   * <p>위와 같이 수열이 주어 질 경우 규칙은 해당 위치의 수는 (N - 2) + (N - 3)이다.
   * <p>해당 규칙을 이용하여 문제를 해결할 수 있다.
   * <p>재귀 방식과 for loop를 이용하여 문제를 해결 해보자.
   * <p>재귀 방식을 이용할 때는 메모이제이션을 이용하여 해결할 수 있다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine());

    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 1;
    dp[3] = 1;

    for (int i = 0; i < n; i++) {
      sb.append(loop(Integer.parseInt(br.readLine()))).append("\n");
    }

    System.out.println(sb);
  }

  static private long recursive(int n) {
    if (n == 1 || n == 2 || n == 3) {
      return 1;
    }

    if (dp[n] == 0) {
      dp[n] = recursive(n - 2) + recursive(n - 3);
    }

    return dp[n];
  }

  static private long loop(int n) {
    if (n == 1 || n == 2 || n == 3) {
      return 1;
    }

    long sum = 0;
    long val1 = 1;
    long val2 = 1;
    long val3 = 1;

    for (int i = 3; i < n; i++) {
      sum = val1 + val2;
      val1 = val2;
      val2 = val3;
      val3 = sum;
    }

    return sum;
  }
}