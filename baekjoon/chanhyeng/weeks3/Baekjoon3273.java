package baekjoon.chanhyeng.weeks3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * <p> 배열이 주어 질 때 ai + aj가 특정 값을 만족 하는 쌍을 구하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/3273"/>Baekjoon_3273 두 수의 합</a>
 */
public class Baekjoon3273 {
  /**
   * <p> 문제에서 ai + aj가 주어진 정수인 쌍을 구하라 했으므로
   * <p> 완전 탐색으로 접근 했을 경우 배열의 크기가 십만이고, 두개의 인덱스를 이용해야 하므로 시간 복잡도가 n^2이므로 안될거 같지만 도전...
   * <p> 바로 시간 초과!! 배운 투포인터를 이용하여 만들어보자..
   * <p> 일단 정렬을 해준다.
   * <p> 그리고 처음과 끝에 인덱스를 두고 두 수의 합을 구한다.
   * <p> 합이 같으면 result++하고 마지막 인덱스를 줄인다.
   * <p> 합이 크면 끝값을 줄이고 작으면 시작 인덱스를 올린다.
   * <p> 양끝이 같은 경우 break
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    int result = 0;

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    st = new StringTokenizer(br.readLine());
    int x = Integer.parseInt(br.readLine());

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

//    완전탐색 접근 - 실패
//    for (int i = 0; i < n - 1; i++) {
//      for (int j = i + 1; j < n; j++) {
//        if (arr[i] + arr[j] == x) {
//          result++;
//        }
//      }
//    }
    Arrays.sort(arr);

    int s = 0;
    int e = n - 1;
    while (s != e) {
      if (arr[s] + arr[e] == x) {
        result++;
        e--;
      } else if (arr[s] + arr[e] > x) {
        e--;
      } else if (arr[s] + arr[e] < x) {
        s++;
      }
    }

    bw.write(String.valueOf(result));
    bw.flush();
    bw.close();
    br.close();
  }
}
