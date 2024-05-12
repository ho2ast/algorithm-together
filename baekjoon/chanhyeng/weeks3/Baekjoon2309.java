package baekjoon.chanhyeng.weeks3;

import java.io.*;
import java.util.Arrays;

/**
 * <p> 난쟁이 중 키들의 합이 100일 수 있는 경우의 수를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/2309"/>Baekjoon_2309 일곱 난쟁이</a>
 */
public class Baekjoon2309 {

  /**
   * <p> 9개의 숫자의 합 중 2개의 숫자의 합을 뺀 후 구한다.
   * <p> 2024-05-13
   * <p> 완전탐색으로 문제를 해결 했었는데 투포인터 문제로 돌아왔다.
   * <p> 완전 탐색의 경우 9개 숫자의 합을 구한 후 두개의 인덱스의 값의 합을 빼서 구했다.
   * <p> 투 포인터의 경우 어떻게 해야할까?
   * <p> 완전 탐색으로 경우 9난쟁이의 합을 구한 후 이중 Loop를 이용하여 두명의 난쟁이들의 키를 빼면서 계산했다..
   * <p> 하지만 투포인터를 사용할 경우 첫번재 마지막 인덱스를 포인터로 잡고 모든 난쟁이 키 합에서 포인터 인덱스의 합을 구해서 빼준다.
   * <p> 뺀값이 100이면 일치하므로 스탑.
   * <p> 크면 s를 늘리고 작으면 e를 줄인다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[] small = new int[9];
    for (int i = 0; i < 9; i++) {
      small[i] = Integer.parseInt(br.readLine());
    }
//    int[] small = {20,
//        7,
//        23,
//        19,
//        10,
//        15,
//        25,
//        8,
//        13};

    int sum = 0;
    boolean flag = false;

    for (int i = 0; i < 9; i++) {
      sum += small[i];
    }

    Arrays.sort(small);

    // 완전 탐색
//    int index1 = -1;
//    int index2 = -1;
//    for (int i = 0; i < 9; i++) {
//      for (int j = i + 1; j < 9; j++) {
//        index1 = i;
//        index2 = j;
//        int tempSum = sum - small[index1] - small[index2];
//        if (tempSum == 100) {
//          flag = true;
//          break;
//        }
//      }
//
//      if (flag) {
//        break;
//      }
//    }

//    for (int i = 0; i < 9; i++) {
//      if (i != index1 && i != index2) {
//        bw.write(String.valueOf(small[i]));
//        bw.newLine();
//      }
//    }

    // 투포인터
    int s = 0;
    int e = 8;

    while (s < e) {
      int sub = sum - (small[s] + small[e]);
      if (sub == 100) {
        break;
      } else if (sub > 100) {
        s++;
      } else {
        e--;
      }
    }

    for (int i = 0; i < 9; i++) {
      if (i != s && i != e) {
        bw.write(String.valueOf(small[i]));
        bw.newLine();
      }
    }

    bw.flush();
    bw.close();
    br.close();
  }
}
