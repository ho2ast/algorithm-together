package baekjoon.chanhyeng.weeks5;

import java.io.*;
import java.util.StringTokenizer;

/**
 * <p> 배열이 주어질 때 주어진 구간까지의 합이 가장 큰 수를 출력하세요..
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/2559"/>Baekjoon_2559 수열</a>
 */
public class Baekjoon2559 {
  /**
   * <p> 누적합을 배열(dp)에 저장한다. 저장은 0번째 인덱스를 0으로 두고 1번째 인덕스부터 합을 저장한다.
   * <p> 그 후 k번째 인덱스부터 시작하여 dp[k] - dp[k - 1] 값을 구해 최대값 변수에 저장한 후 max함수를 이용하여 구해준다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[] tempArr = new int[n];
    int[] dp = new int[n + 1];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      tempArr[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 1; i < dp.length; i++) {
      dp[i] = dp[i - 1] + tempArr[i - 1];
    }

    int result = Integer.MIN_VALUE;
    for (int i = k; i < n + 1; i++) {
      result = Math.max(result, dp[i] - dp[i - k]);
    }

    bw.write(String.valueOf(result));
    bw.flush();
    bw.close();
    br.close();
  }
}
