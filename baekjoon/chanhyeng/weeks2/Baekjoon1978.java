package baekjoon.chanhyeng.weeks2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * <p> 정수가 주어질 때 소수가 몇개인지 찾아서 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/1978"/>Baekjoon_1978 소수 찾기</a>
 */
public class Baekjoon1978 {
  /**
   * <p> 주어지는 수는 1000이하 이므로 에라토스테네스의 체를 이용하여 불리언 배열의 인덱스로 해당 숫자가 소수이면 true로 바꿔준다.
   * <p> 이후 주어진 수를 인덱스로 하여 배열에서 값을 찾아 true이면 카운트를 해준다.
   * <p> 시간 복잡도는 에라토스테네스의 체를 이용할 때 이중 루프를 돌기 때문에 약 1000의 제곱으로 볼 수 있다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int result = 0;

    int n = Integer.parseInt(br.readLine());
    boolean[] isPrimeNumber = new boolean[1001];

    isPrimeNumber[1] = true;
    for (int i = 2; i < 1001; i++) {
      if (!isPrimeNumber[i]) {
        int index = 2;
        while (i * index <= 1000) {
          isPrimeNumber[i * index] = true;
          index++;
        }
      }
    }

//    for (int i = 2; i * i < 1001; i++) {
//      if (!isPrimeNumber[i]) {
//        for (int j = i * i; j < 1001; j += i) {
//          isPrimeNumber[j] = true;
//        }
//      }
//    }

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      if (!isPrimeNumber[Integer.parseInt(st.nextToken())]) {
        result++;
      }
    }

    bw.write(String.valueOf(result));
    bw.flush();
    bw.close();
    br.close();
  }
}
