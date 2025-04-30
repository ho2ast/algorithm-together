package baekjoon;

import java.io.*;

/**
 * <p> 로또 번호 집합 S와 그 개수 k가 주어졌을 때 로또 번호를 고를 수 있는 모든 경우의 수를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/6603"/>Baekjoon_6603 로또</a>
 */
public class Baekjoon6603 {

  /**
   * 주어진 번호 중 6개를 고르는 경우의 수를 생각하면 된다.
   * k-6만큼을 제외 한 후 계산을 해준다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//    bw.write(String.valueOf());
    bw.flush();
    bw.close();
    br.close();
  }
}
