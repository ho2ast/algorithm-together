package baekjoon.chanhyeng.weeks2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * <p> 주어진 좌표의 범위에서 주어진 수의 점을 지나는 선분의 개수를 출력하세.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/16970"/>Baekjoon_16970 정수 좌표의 개수</a>
 */
public class Baekjoon16970 {
  /**
   * <p> 우선 찾은 규칙대로 풀어본다.
   * <p> 기울기가 1인 경우 x2 - x1 + 1이 지나는 점의 개수.
   * <p> x == 0 or y == 0일 때는 0이 아닌 값 + 1.
   * <p> 이외의 경우에는 x2 - x1 , y2 - y1 중 큰 값의 약수의 개수 + 1을 해준다.
   * <p> x1, x2, y1, y2에 대한 for문을 돌아야 하므로 50^4이다 이는 2초내 가능.
   * <p> 바로 실패..
   * <p>
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int result = 0;

    int xMax = Integer.parseInt(st.nextToken());
    int yMax = Integer.parseInt(st.nextToken());
    int coordinateCount = Integer.parseInt(st.nextToken());

    for (int x1 = 0; x1 <= xMax; x1++) {
      for (int y1 = 0; y1 <= yMax; y1++) {
        for (int x2 = 0; x2 <= xMax; x2++) {
          for (int y2 = 0; y2 <= yMax; y2++) {
//            if ((Math.abs(y2 - y1) == Math.abs(x2 - x1)) && Math.abs(x2 - x1) + 1 == coordinateCount) {
//              result++;
//            } else if ((x1 == 0 && x2 == 0) && (Math.abs(y2 - y1) + 1 == coordinateCount)) {
//              result++;
//            } else if ((y1 == 0 && y2 == 0) && (Math.abs(x2 - x1) + 1 == coordinateCount)) {
//              result++;
//            } else {
//              int max = Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1));
//              int c = 0;
//              for (int i = 1; i <= Math.sqrt(max); i++) {
//                if (max % i == 0) {
//                  c++;
//                }
//              }
//              if ((c * 2) + 1 == coordinateCount) {
//                result++;
//              }
//            }
            if (gcd(Math.abs(x2 - x1), Math.abs(y2 - y1)) + 1 == coordinateCount) {
              result++;
            }
          }
        }
      }
    }

    bw.write(String.valueOf(result / 2));
    bw.flush();
    bw.close();
    br.close();
  }

  public static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }

    return gcd(b, a % b);
  }
}
