package baekjoon.dynamic_programming_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p> 재귀호출과 동적 프로그래밍 방식으로 피보나치 수열을 구 때 연산 횟수를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/24416"/>Baekjoon_24416 알고리즘 수업 - 피보나치 수 1</a>
 */
public class Level1 {
  static int recursiveCount = 0;
  static int dpCount = 0;
  /**
   * <p> 재귀호출과 동적 프로그래밍 방법으로 피보나치 수를 구하는 알고리즘을 각각 구현 후 구한다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    fibonacciRecursive(n);
    fibonacciDP(n);

    System.out.println(recursiveCount + " " + dpCount);
  }

  static public int fibonacciRecursive(int n) {
    if (n == 1 || n == 2) {
      recursiveCount++;
      return 1;
    } else {
      return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
  }

  static public int fibonacciDP(int n) {
    int[] arr = new int[n + 1];
    arr[1] = 1;
    arr[2] = 1;

    for (int i = 3; i <= n; i++) {
      dpCount++;
      arr[i] = arr[i - 1] + arr[i - 2];
    }

    return arr[n];
  }
}
