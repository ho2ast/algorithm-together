package baekjoon.chanhyeng.weeks2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * <p> 이항계수가 주어질 떄 끝자리 0이 몇개 인지 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/2004"/>Baekjoon_2004 조합 0의 개수</a>
 */
public class Baekjoon2004 {

  /**
   * <p> 0의 개수는 10의 개수에 의해 결정
   * <p> 따라서 10이 나와야 하는 2*5이므로 2와 5가 몇 개 있는지 풀면된다.
   * <p> 팩토리얼의 소인수 개수는 소수로 해당 수로 나누고 몫, 해당 수를 제곱해서 나눈 몫...
   * <p> 이런식으로 피제수보다 작거나 같을 떄까지 반복하면 해당 소수가 몇개 인지 나온다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    long[] up = new long[2];

    for (int i = 0; i < 3; i++) {
      if (i == 0) {
        up = pf(n);
      } else if (i == 1) {
        long[] down = pf(n - m);
        up[0] -= down[0];
        up[1] -= down[1];
      } else if (m != 0){
        long[] down = pf(m);
        up[0] -= down[0];
        up[1] -= down[1];
      }
    }

    bw.write(String.valueOf(Math.min(up[0], up[1])));
    bw.flush();
    bw.close();
    br.close();
  }

  public static long[] pf(long num) {
    long[] nums = {2, 5};
    long[] result = new long[2];

    for (int i = 0; i < 2; i++) {
      long n = nums[i];
      while (n <= num) {
        result[i] = result[i] + (num / n);
        n = n * nums[i];
      }
    }
    return result;
  }
}
