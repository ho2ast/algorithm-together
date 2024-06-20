package baekjoon.chanhyeng.weeks7;

import java.io.*;

/**
 * <p> 몇 번의 점수를 감소시켜야 하는지 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/2847"/>Baekjoon_2847 게임을 만든 동준이</a>
 */
public class Baekjoon2847 {
  /**
   * <p> 생각을 해보자.. 쉬운 레벨의 점수가 어려운 레벨의 점수보다 낮아야 한다.
   * <p> 순서는 레벨순으로 되어 있으므로, 가장 마지막 레벨의 점수가 최고점수가 되어야 한다.
   * <p> 이를 바탕으로 반복문으로 돌며 (n-1)번째 점수는 n번째 점수보다 1점만 낮아도 되므로
   * <p> 빼줘야 하는 점수를 arr[n] - (arr[n + 1] - 1)를 이용하여 감소시켜야 하는 점수를 알 수 있다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    int result = 0;

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    for (int i = N - 2; i > -1; i--) {
      if (arr[i] < arr[i + 1]) {
        continue;
      }

      result += arr[i] - (arr[i + 1] - 1);
      arr[i] = arr[i + 1] - 1;
    }


    bw.write(String.valueOf(result));
    bw.flush();
    bw.close();
    br.close();
  }
}
