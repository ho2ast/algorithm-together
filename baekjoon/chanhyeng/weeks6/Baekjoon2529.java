package baekjoon.chanhyeng.weeks6;

import java.io.*;
import java.util.StringTokenizer;

/**
 * <p> 부등호가 주어질 때 해당 부등호를 만족하는 최대 정수와 최소 정수를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/2529"/>Baekjoon_2529 부등호</a>
 */
public class Baekjoon2529 {
  static int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
  static int K;
  static String[] arr;
  static int max = Integer.MIN_VALUE;
  static int min = Integer.MAX_VALUE;
  static StringBuilder value;

  /**
   * <p> 완전탐색을 돌면서 해당 부등호를 만족한다면 재귀를 호출하여 다음 숫자로 넘어가도록 한다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    K = Integer.parseInt(br.readLine());
    arr = new String[K];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < K; i++) {
      arr[i] = st.nextToken();
    }

    for (int i = 0; i < 10; i++) {
      search(0, i, (1 << 10));
    }

    bw.write(String.valueOf(max));
    bw.newLine();
    bw.write(String.valueOf(min));
    bw.flush();
    bw.close();
    br.close();
//    System.out.println(Integer.toBinaryString(((1 << 10) | 1 << 9) & 1 << 9));
  }

  static void search(int idx, int start, int visit) {
    if (start > 9 || start < 0 || (visit & 1 << start) > 0) {
      return;
    }

    if (idx == K) {
      max = Math.max(max, Integer.parseInt(value.toString()));
      min = Math.min(min, Integer.parseInt(value.toString()));
      return;
    }

    if (idx == 0) {
      value = new StringBuilder();
    }

    if (arr[idx].equals("<")) {
      value.append(nums[start]);
      search(++idx, start + 1, visit | 1 << start);
    } else {
      value.append(nums[start]);
      search(++idx, start - 1, visit | 1 << start);
    }
  }
}
