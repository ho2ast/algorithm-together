package baekjoon.implement;

import java.io.*;


/**
 * <p> 유진수가 맞는지 아닌지 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/1009"/>Baekjoon_1356 유진수</a>
 */
public class Baekjoon1356 {
  /**
   * 앞수의 곱, 뒷수의 곱을 따로 계산 해준다.
   * 앞수의 곲은 무조건 0부터 시작이고 end는 1씩 늘어나게 된다.
   * 뒷수의 곱은 앞수 end + 1부터 시작이고 end는 무조건 마지막 수이다.
   * 그리고 마지막 앞수까지의 곱만 계산해도 되므로 전체 반복 사이클은 사이즈 - 1로 설정했다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String s = br.readLine();
    String result = "NO";

    for (int i = 0; i < s.length() - 1; i++) {

      int front = multiple(s, 0, i);
      int back = multiple(s, i + 1, s.length() - 1);

      if (front == back) {
        result = "YES";
        break;
      }
    }


    bw.write(result);
    bw.flush();
    bw.close();
    br.close();
  }

  public static int multiple(String s, int start, int end) {
    int result = 1;
    for (int i = start; i <= end; i++) {
      result *= Integer.parseInt(String.valueOf(s.charAt(i)));
    }

    return result;
  }
}
