package baekjoon.chanhyeng;

import java.io.*;
import java.util.Arrays;

/**
 * <p> 난쟁이 중 키들의 합이 100일 수 있는 경우의 수를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/2309"/>Baekjoon_2309 일곱 난쟁이</a>
 */
public class Baekjoon2309 {

  /**
   * <p>9개의 숫자의 합 중 2개의 숫자의 합을 뺀 후 구한다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//    int[] small = new int[9];
//    for (int i = 0; i < 9; i++) {
//      small[i] = Integer.parseInt(br.readLine());
//    }
    int[] small = {20,
        7,
        23,
        19,
        10,
        15,
        25,
        8,
        13};

    int sum = 0;
    int index1 = -1;
    int index2 = -1;
    boolean flag = false;

    for (int i = 0; i < 9; i++) {
      sum += small[i];
    }

    Arrays.sort(small);

    for (int i = 0; i < 9; i++) {
      for (int j = i + 1; j < 9; j++) {
        index1 = i;
        index2 = j;
        int tempSum = sum - small[index1] - small[index2];
        if (tempSum == 100) {
          flag = true;
          break;
        }
      }

      if (flag) {
        break;
      }
    }

    for (int i = 0; i < 9; i++) {
      if (i != index1 && i != index2) {
        bw.write(String.valueOf(small[i]));
        bw.newLine();
      }
    }

    bw.flush();
    bw.close();
    br.close();
  }
}
