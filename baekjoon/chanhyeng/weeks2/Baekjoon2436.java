package baekjoon.chanhyeng.weeks2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * <p> 두 정수가 주어질 때 두 정수를 최대공약수 최소공배수로 가지는 수를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/2436"/>Baekjoon_2436 공약수</a>
 */
public class Baekjoon2436 {
  /**
   * <p> 최소공배수는 (a * b) / 최대공약수 이다.
   * <p> 최소공배수 * 최대공약수 = a * b 라고 볼 수 있다.
   * <p> 그럼 최소의 두 수를 구하면 되나..?
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int gcd = Integer.parseInt(st.nextToken());
    int lcd = Integer.parseInt(st.nextToken());

    int temp = gcd * lcd;

    int result = Integer.MAX_VALUE;

    int a = 0;
    int b = 0;

    for (int i = 1; i <= temp / 2; i++) {
      if (temp % i == 0) {
        int tempA = i;
        int tempB = temp / i;
        int tempSum = tempA + tempB;
        if (tempSum < result) {
          result = tempSum;
          a = tempA;
          b = tempB;
        }
      }
    }


    bw.write(String.valueOf(a));
    bw.write(" ");
    bw.write(String.valueOf(b));
    bw.flush();
    bw.close();
    br.close();
  }
}
