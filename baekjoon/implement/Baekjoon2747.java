package baekjoon.implement;

import java.io.*;

/**
 * <p> n이 주어졌을 때 n번째 피보나치 수를 구하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/2747"/>Baekjoon_2747 피보나치 수</a>
 */
public class Baekjoon2747 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    int[] fibonacci = new int[n + 1];

    fibonacci[0] = 0;
    fibonacci[1] = 1;

    for (int i = 2; i < n + 1; i++) {
      fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
    }

    bw.write(String.valueOf(fibonacci[n]));
    bw.flush();
    bw.close();
    br.close();
  }
}
