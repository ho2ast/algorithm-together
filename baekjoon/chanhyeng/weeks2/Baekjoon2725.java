package baekjoon.chanhyeng.weeks2;

import java.io.*;

/**
 * <p> 정수 n이 주어 질 때 좌표평면에서 (0,0)에서 보이는 좌표의 개수를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/2725"/>Baekjoon_2725 보이는 점의 개수</a>
 */
public class Baekjoon2725 {
  /**
   * <p> (x, y)의 좌표 값이 2로 나누어 떨어 지지 않으면 된다?
   * <p> 대칭이므로 (0,0) ~ (n,n)으로 대각선을 기준으로 나눈 후 한쪽만 구한다.
   * <p> (1,1), (1,0), (0,1)은 디폴트로 포함한다.
   * <p> 2로 나누어 떨어지지 않는 경우는 틀림.
   * <p> 그럼 두 수중 하나라도 소수일 경우?
   * <p> 또한 (0,1)과 (x, 1)은 모두 포함되므로 1 + n + (count *2)를 해준다.
   * <p> 안풀려서 접근법만 찾아봄.. 분모와 분자가 서로소 관계여야 하고 최대공약수가 1이어야 한다.
   * <p> 저장하는 방식의 차이
   * <p> 배열을 지정해놓고 해당 좌표의 크기에 해당하는 값을 넣어준다. arr[n] = arr[n - 1] + count*2
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int c = Integer.parseInt(br.readLine());

//    boolean[] isPrimeNumber = new boolean[1001];

//    for (int i = 2; i < 1001; i++) {
//      if (!isPrimeNumber[i]) {
//        for (int j = i * i; j < 1001; j += i) {
//          isPrimeNumber[j] = true;
//        }
//      }
//    }

    int[] numArr = new int[c];
    for (int i = 0; i < c; i++) {
      numArr[i] = Integer.parseInt(br.readLine());
    }

    int[] countArr = new int[1001];
    countArr[1] = 3;

    for (int x = 2; x < 1001; x++) {
      int count = 0;
      // 대각선 기준으로 아래쪽만 계산하므로 y값을 x보다 작은것으로 제한
      for (int y = 1; y < x; y++) {
        int gcd = 0;
        for (int j = 1; j <= y; j++) {
          if (x % j == 0 && y % j == 0) {
            gcd = gcd < j ? j : gcd;
          }
        }
        if (gcd == 1) {
          count++;
        }
      }

      countArr[x] = countArr[x - 1] + (count * 2);
    }

    for (int i = 0; i < c; i++) {
      bw.write(String.valueOf(countArr[numArr[i]]));
      bw.newLine();
    }

    bw.flush();
    bw.close();
    br.close();
  }
}
