package baekjoon.chanhyeng.weeks6;

import java.io.*;
import java.util.StringTokenizer;

/**
 * <p> 배열이 주어지고 정수가 주어질 때 부분 수열의 합이 정수가 되는 경우의 수를 출력하세.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/1182"/>Baekjoon_1182 부분수열의 합</a>
 */
public class Baekjoon1182 {

  static int result = 0;
  static int N = 0;
  static int S = 0;
  static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());
    arr = new int[N];

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    search(0, 0);

    bw.write(String.valueOf(result));
    bw.flush();
    bw.close();
    br.close();
  }

  public static void search(int idx, int sum) {
    if (idx == N) {
      return;
    }

    int includeSum = sum + arr[idx];

    if (includeSum == S) {
      result++;
    }

    search(idx + 1, includeSum);
    search(idx + 1, sum);
  }
}
