package baekjoon.dynamic_programming_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <p> 임의의 정수 수열이 주어질 경우 연속된 수를 선택 하여 만들 수 있는 최대 합을 출력 하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/1912"/>Baekjoon_1912 연속 합</a>
 */
public class Level5 {
  /**
   * <p>메모이제이션을 이용하여 이전까지 탐색했던 값과 현재 위치의 값을 비교 하여 큰 값을 저장 해준다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    br.close();

    int[] arr = new int[n];
    Integer[] dp = new Integer[n];

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    dp[0] = arr[0];
    int max = arr[0];

    for (int i = 1; i < n; i++) {
      dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
      max = Math.max(max, dp[i]);
    }

    System.out.println(max);
  }
}
