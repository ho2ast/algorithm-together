package baekjoon.bruteforce;

import java.io.*;

/**
 * <p> 10000 이하의 셀프넘버를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/4673"/>Baekjoon_4673 셀프 넘버</a>
 */
public class Baekjoon4673 {
  /**
   * 어떤 숫자와 숫자의 각 자리수를 더해 새로운 수가 나올때 최초의 수를 새로운 수의 생성자라고 한다.
   * 셀프넘버는 생성자가 없는 숫자를 의미한다.
   * 이때 10000 이하의 셀프 넘버를 출력해야 한다.
   * 길이가 10001인 불린 배열을 생성해주고 1부터 자신과 자릿수를 더해서 나온 수의 인덱스에 true로 넣어준다.
   * 그럼 해당 인덱스에 해당 하는 수는 생성자가 있는 숫자가 되는것이다.
   */
  public static void main(String[] args) throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    boolean[] selfNumber = new boolean[10001];

    for (int i = 1; i < 10001; i++) {
      String s = String.valueOf(i);
      int len = s.length();

      int sum = i;
      for (int j = 0; j < len; j++) {
        sum += s.charAt(j) - '0';
      }
      if (sum > 10000) {
        continue;
      }
      selfNumber[sum] = true;
    }

    for (int i = 1; i < 10001; i++) {
      if (!selfNumber[i]) {
        bw.write(String.valueOf(i));
        bw.newLine();
      }
    }

    bw.flush();
    bw.close();
  }
}
