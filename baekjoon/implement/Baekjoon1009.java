package baekjoon.implement;

import java.io.*;
import java.util.StringTokenizer;

/**
 * <p> 데이터의 개수가 주어 졌을 때 마지막 데이터는 몇 번째 컴퓨터가 처리하는지 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/1009"/>Baekjoon_1009 분산처리</a>
 */
public class Baekjoon1009 {
  /**
   * 주어진 데이터의 총 개수를 계산한다.
   * 하지만 그냥 제곱을 구할 경우 범위가 벗어 난다.
   * 데이터의 처리 컴퓨터는 마지막 1의자리 수만 알면 된다.
   * 따라서 제곱을 구할 때 1의 자리만 알면 되므로 제곱을 하면서 mod 10값을 저장한 후 구한다.
   * 이렇게 하면 result값이 마지막 데이터를 처리할 컴퓨터 번호를 의미한다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int t = Integer.parseInt(br.readLine());

    for (int i = 0; i < t; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      int result = a;

      for (int j = 2; j <= b; j++) {
        result = (result * a) % 10;
      }

      bw.write(String.valueOf(result == 0 ? 10 : result));
      bw.newLine();
    }

    bw.flush();
    bw.close();
    br.close();
  }
}
