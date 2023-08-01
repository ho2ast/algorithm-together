package dynamic_programming_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p> 지원이가 만들 수 있는 타일의 2진 수열의 개수를 15746으로 나눈 나머지를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/1904"/>Baekjoon_1904 01타일</a>
 */
public class Level3 {
  static int[] dp = new int[1_000_001];

  /**
   * <p>주어진 N길이 만큼 만들 수 있는 수를 구한다.
   * <p>00타일을 몇 번 쓸 수 있는지 확인 한다. 남은 자리수 만큼 1을 쓸 수 있는 경우의 수를 구한다.
   * <p>N = 1 / 1
   * <p>N = 2 / 2
   * <p>N = 3 / 3
   * <p>N = 4 / 5
   * <p>N = 5 / 8
   * <p>N = 6 / 13
   * <p>위의 규칙을 보면 피보나치 수열처럼 앞의 두항의 합이 현재 항의 값이 되는 것을 알 수 있다.
   * <p>해당 규칙을 이용하여 재귀적으로 풀거나 반복문을 통해 문제를 해결할 수 있다.
   * <p>또한 모듈러의 법칙에 의해 (A+B)%C = (A%C + B%C)%C가 성립하므로 나머지값을 저장하여 사용해도 문제가 없다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    br.close();

    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 2;

    for (int i = 3; i < dp.length; i++) {
      dp[i] = -1;
    }

    System.out.println(tile(N));
    System.out.println(tileLoop(N));
  }

  private static int tile(int n) {
    if (dp[n] == -1) {
      dp[n] = (tile(n - 1) + tile(n - 2)) % 15746;
    }

    return dp[n];
  }

  private static int tileLoop(int n) {
    if (n == 1) {
      return 1;
    }

    if (n == 2) {
      return 2;
    }

    int val1 = 1;
    int val2 = 2;
    int sum = 0;

    for (int i = 2; i < n; i++) {
      sum = (val1 + val2) % 15746;
      val1 = val2;
      val2 = sum;
    }

    return sum;
  }
}
