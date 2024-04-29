package baekjoon.chanhyeng.weeks2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * <p> 두 수 A와 B가 주어질 때 사이의 소수중 3일 포함하는 숫자의 개수를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/6219"/>Baekjoon_6219 소수의 자격</a>
 */
public class Baekjoon6219 {

  /**
   * <p>에라토스테네스의 체를 이용하여 소수를 구한 후 해당 숫자의 범위 중 주어진 숫자가 포홤되는지 확인한다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int d = Integer.parseInt(st.nextToken());

    int result = 0;

    boolean[] isPrimeNum = new boolean[b + 1];
    isPrimeNum[0] = true;
    isPrimeNum[1] = true;

    for (int i = 2; i * i <= b; i++) {
      if (!isPrimeNum[i]) {
        for (int j = i * i; j <= b; j += i) {
          isPrimeNum[j] = true;
        }
      }
    }

    for (int i = a; i <= b; i++) {
      if (!isPrimeNum[i]) {
        if (String.valueOf(i).contains(String.valueOf(d))) {
          result++;
        }
      }
    }

    bw.write(String.valueOf(result));
    bw.flush();
    bw.close();
    br.close();
  }
}
