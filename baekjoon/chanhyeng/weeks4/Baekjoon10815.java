package baekjoon.chanhyeng.weeks4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * <p> 주어진 숫자 N개가 M개의 숫자에 있는지 없는지 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/10815"/>Baekjoon_10815 숫자 카드</a>
 */
public class Baekjoon10815 {
  /**
   * <p> 완전 탐색을 이용해보자.
   * <p> 상근이가 가지고 있는 숫자카드 배열로 loop를 돈다.
   * <p> m은 ArrayList에 저장 하여 contains 함수를 이용하여 판별해보자.
   * <p> contains함수도 결국 내부에서 for문을 이용하므로 이중 loop를 도는것과 동일하다.
   * <p> 따라서 시간복잡도가 n^2이므로 시간초과가 발생한다.
   * <p> 따라서 상근이 카드의 배열을 정렬해주고 이분 탐색 방법을 이용해본다.
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

    Arrays.sort(arr);

    int m = Integer.parseInt(br.readLine());

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      int num = Integer.parseInt(st.nextToken());
      int s = 0;
      int e = n - 1;

      boolean flag = false;
      while (s <= e) {
        int mid = (s + e) / 2;
        if (arr[mid] == num) {
          flag = true;
          break;
        } else if (arr[mid] > num) {
          e = mid - 1;
        } else if (arr[mid] < num) {
          s = mid + 1;
        }
      }

      bw.write(flag ? "1 " : "0 ");
    }

    bw.flush();
    bw.close();
    br.close();
  }
}
