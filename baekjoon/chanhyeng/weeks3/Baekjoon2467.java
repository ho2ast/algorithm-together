package baekjoon.chanhyeng.weeks3;

import java.io.*;
import java.util.StringTokenizer;

/**
 * <p> 용액의 특성이 주어질 때 합이 가장 0에 가까운 두 용액을 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/2467"/>Baekjoon_2467 용액</a>
 */
public class Baekjoon2467 {
  /**
   * <p> 용액의 특성을 배열로 저장한다.
   * <p> 두 용액의 합을 구해야 하므로 완전탐색으로 접근 해보자.
   * <p> 모든 경우의 수를 구해야 한다. 이중 루프를 이용하여 구해야 하므로 시간 복잡도는 n^2. n의 최대값은 100,000이므로 1초의 시간제한을 초과한다.
   * <p> 투포인터로 접근해보자.
   * <p> 양쪽 끝 인덱스를 s와 e로 잡아서 시작한다.
   * <p> 두 수의 합을 절대값으로 바꾼 후 전역 변수 min값에 저장하고 해당 인덱스도 저장한다.
   * <p> 그리고 두 수의 합이 0보다 크면 e를 줄이고 0보다 작으면 a를 늘린다.
   * <p> 그 후 두 수의 합을 구해서 이전에 저장한 min값과 비교 후 작으면 min값과 index 변경.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int min = Integer.MAX_VALUE;
    int[] index = new int[2];

    int s = 0;
    int e = n - 1;

    while (s < e) {
      int sum = arr[s] + arr[e];
      int absSum = Math.abs(sum);

      if (absSum < min) {
        min = absSum;
        index[0] = s;
        index[1] = e;
      }

      if (sum < 0) {
        s++;
      } else {
        e--;
      }
    }


    bw.write(arr[index[0]] + " " + arr[index[1]]);
    bw.flush();
    bw.close();
    br.close();
  }
}
