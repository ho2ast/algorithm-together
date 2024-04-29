package baekjoon.chanhyeng.weeks1;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * <p> 정수 n이 주어질 때 1부터 반복하지 않는 수를 쓰면 n번째 오는 수를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/7696"/>Baekjoon_7696 반복하지 않는 수</a>
 */
public class Baekjoon7696 {
  /**
   * <p> 1부터 시작하여 두 번 이상 반복되는 수는 제외하고 증가될 때 n번째 숫자를 출력해야 한다.
   * <p> 가장 먼저 떠오르는 방법은 각 숫자를 {@link String#toCharArray()}하여 각 숫자를 비교하는 것이다.
   * <p> 하지만 이 방법을 쓰면 시간 복잡도는 n^2이므로 최악의 경우 백만의 제곱이 되므로 시간 초과가 될 것이다.
   * <p> 문자열을 쪼개서 Set에 넣고 중복을 제거한 후 길이를 확인한다면? 이것도 n^2???...
   * <p> 바로 메로리 초과...
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String nStr;

    while (!(nStr = br.readLine()).equals("0")) {
      int n = Integer.parseInt(nStr);
      int index = 1;
      int num = 0;

      while (index - 1 != n) {
        num++;
        Set<Character> set = new HashSet<>();
        String s = String.valueOf(num);
        int length = s.length();

        for (int j = 0; j < length; j++) {
          set.add(s.charAt(j));
        }

        if (length == set.size()) {
          index++;
        }
      }

      bw.write(String.valueOf(num));
      bw.newLine();
    }

    bw.flush();
    bw.close();
    br.close();
  }
}
