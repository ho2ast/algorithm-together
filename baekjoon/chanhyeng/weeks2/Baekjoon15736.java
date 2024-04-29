package baekjoon.chanhyeng.weeks2;

import java.io.*;

/**
 * <p> 깃발 개수 N이 주어질 때 N번째까지 진행 후 백색이 위로 놓인 깃발의 갯수를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/15736"/>Baekjoon_15736 청기 백기</a>
 */
public class Baekjoon15736 {
  /**
   * <p> 청/백기는 해당 숫자의 약수만큼 뒤집는다.
   * <p> 해당 숫자 약수의 개수가 홀수 인지 짝수인지만 구한 후 해당 숫자의 초기 깃발 색에 더 해주면 된다.
   * <p> 숫자의 약수가 홀수 인 경우는 1과 소수의 제곱만 홀수 이고 나머지는 약수가 모두 짝수 개이다.
   * <p> 약수가 홀수 인 경우는 제곱근의 경우이다.
   * <p> 제곱수의 갯수를 세어주면된다.
   * <p> 제곱근의 개수를 세어주고 제곱근이 n보다 커지면 종료한다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int result = 1;
    int n = Integer.parseInt(br.readLine());

    for (int i = 2; i <= n; i++) {
      if ((i * i) <= n) {
        result++;
      } else {
        break;
      }
    }

    bw.write(String.valueOf(result));
    bw.flush();
    bw.close();
    br.close();
  }
}
