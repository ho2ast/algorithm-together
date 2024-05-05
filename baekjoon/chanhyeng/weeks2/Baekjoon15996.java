package baekjoon.chanhyeng.weeks2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * <p> 정수와 소수가 주어질 떄 소수의 몇 제곱을 해야 정수가 나누어 떨어지는지 구하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/15996"/>Baekjoon_15996 팩토리얼 나누기</a>
 */
public class Baekjoon15996 {
  /**
   * <p> 소수로 팩토리얼 나누기를 해준다.
   * <p> 주어진 소수 a로 나누고 나누어 떨어질 경우 +1을 한다.
   * <p> n ~ 1 까지 반복이 돈 후 a의 거듭제곱을 구해 위의 과정을 반복한다.
   * <p> 거듭제곱 값이 최대값이 넘어가면 중단, 그때의 카운트가 a의 개수이다.
   * <p> 근데 n이 2의 31승까지 이므로 잘못 하면 시간 초과가 될 수 있다.
   * <p> 위의 방법은 n까지 a의 배수가 몇개 인지 구하면 되므로 n / a를 하여 몪을 더해주는 식으로 계산해봐도 될 거 같다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int a = Integer.parseInt(st.nextToken());

    int count = 0;

    for (int i = a; i <= n; i *= a) {
      if (i < 0) {
        break;
      }
      count += n / i;
    }

    bw.write(String.valueOf(count));
    bw.flush();
    bw.close();
    br.close();
  }
}
