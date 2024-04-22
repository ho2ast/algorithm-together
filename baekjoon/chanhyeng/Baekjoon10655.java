package baekjoon.chanhyeng;

import java.io.*;
import java.util.StringTokenizer;

/**
 * <p> 마라톤 체크포인트 좌표가 주어 질 때 한 개의 체크포인트를 건너 뛰고 갈 수 있는 최단 거리를 구하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/10655"/>Baekjoon_10655 마라톤 1</a>
 */
public class Baekjoon10655 {

  /**
   * <p> 체크 포인트의 개수가 주어지고 각 체크포인트의 좌표가 주어진다.
   * <p> 각 좌표의 숫자를 x, y 배열에 넣어준다.
   * <p> 첫번재와 마지막 체크포인트는 무조건 지나야 하므로 제외.
   * <p> 중간에 있는 체크포인트만 하나씩 지운 다음 계산하여 최소값을 찾으면 된다.
   * <p> 첫번째 반복문에서 제외해야할 체크포인트 1 ~ N-1를 지정해준다.
   * <p> 두번째 반복문에서 실제로 계산을 해준다. 0 ~ N-1까지.
   * <p> 현재 인덱스와 다음 인덱스의 값을 빼야 하므로 현재 인덱스가 제외해야할 인덱스 인경우 continue;
   * <p> 현재 인덱스 + 1가 제외 해야 할 인덱스인 경우 제외 해야 할 인덱스의 다음 인덱스의 값과 더해주면 된다.
   * <p> 시간복잡도는 (n-2) * (n-1) 이므로 n^2 된다.
   * <p> n은 십만으므로 최악의 경우 100억건인데.. 한 번 해보자...
   * <p> 바로 시간초과...
   * <p> 생각을 바꿔서.. x와, y 배열에 저장 후 모든 x, y의 거리를 구한 후 제외할 체크포인트의 인덱스의 값을 빼준다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    int checkPoint = Integer.parseInt(br.readLine());
    int[] x = new int[checkPoint];
    int[] y = new int[checkPoint];

    int result = Integer.MAX_VALUE;

    for (int i = 0; i < checkPoint; i++) {
      st = new StringTokenizer(br.readLine());
      x[i] = Integer.parseInt(st.nextToken());
      y[i] = Integer.parseInt(st.nextToken());
    }

    // 시간초과
//    for (int i = 1; i < checkPoint - 1; i++) {
//      int distance = 0;
//      for (int j = 0; j < checkPoint - 1; j++) {
//        if (i == j) {
//          continue;
//        }
//
//        if (i == j + 1) {
//          distance += Math.abs(x[j] - x[i + 1]);
//          distance += Math.abs(y[j] - y[i + 1]);
//        } else {
//          distance += Math.abs(x[j] - x[j + 1]);
//          distance += Math.abs(y[j] - y[j + 1]);
//        }
//      }
//
//      result = result < distance ? result : distance;
//    }

    int xSum = 0;
    int ySum = 0;
    for (int i = 0; i < checkPoint - 1; i++) {
      xSum += Math.abs(x[i] - x[i + 1]);
      ySum += Math.abs(y[i] - y[i + 1]);
    }

    for (int i = 1; i < checkPoint - 1; i++) {
      int sum = (xSum - Math.abs(x[i - 1] - x[i]) - Math.abs(x[i] - x[i + 1]) + Math.abs(x[i - 1] - x[i + 1])) + (ySum - Math.abs(y[i - 1] - y[i]) - Math.abs(y[i] - y[i + 1]) + Math.abs(y[i - 1] - y[i + 1]));
      result = Math.min(result, sum);
    }

    bw.write(String.valueOf(result));
    bw.flush();
    bw.close();
    br.close();
  }
}
