package baekjoon.chanhyeng.weeks5;

import java.io.*;
import java.util.StringTokenizer;

/**
 * <p> 일차원 배열이 주어졌을 때 구간 합을 구하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/11659"/>Baekjoon_11659 구간 합 구하기 4</a>
 */
public class Baekjoon11659 {
  /**
   * <p> 완전탐색으로 풀 경우 m*n^2으로 시간초과가 발생하게 된다.
   * <p> 메모이제이션할 배열을 하나 만들고 누적합을 구한 후 저장한다.
   * <p> 이후 점화식 arr[j] - arr[i - 1]
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[] arr = new int[n];
    int[] dp = new int[n + 1];

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 1; i < dp.length; i++) {
      dp[i] = dp[i - 1] + arr[i - 1];
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int j = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      bw.write(String.valueOf(dp[k] - dp[j - 1]));
      bw.newLine();
    }

    bw.flush();
    bw.close();
    br.close();
  }
}
