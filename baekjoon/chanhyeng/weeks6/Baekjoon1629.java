package baekjoon.chanhyeng.weeks6;

import java.io.*;
import java.util.StringTokenizer;

/**
 * <p> 자연수 A를 B번 곱한수의 나머지를 출력하세요..
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/1629"/>Baekjoon_1629 곱셈</a>
 */
public class Baekjoon1629 {
  static long result = 0;

  /**
   * <p> 모듈러 공식을 이용한다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    long A = Long.parseLong(st.nextToken());
    long B = Long.parseLong(st.nextToken());
    long C = Long.parseLong(st.nextToken());

    ;

    bw.write(String.valueOf(search(A, B, C)));
    bw.flush();
    bw.close();
    br.close();
  }

  static long search(long A, long B, long C) {
    if (B == 1) {
      return A % C;
    }

    long temp = search(A, B / 2, C);

    if (B % 2 == 1) {
      return (temp * temp % C) * A % C;
    }

    return temp * temp % C;
  }
}
