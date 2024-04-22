package baekjoon.chanhyeng;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * <p> 정수 M개가 주어졌을 때 모든 두수의 쌍의 최대 공약수를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/9417"/>Baekjoon_9417 최대 GCD</a>
 */
public class Baekjoon9417 {
  /**
   * <p> 두 수의 최대 공약수는 브루트 포스, 유클리드 호제법을 이용할 수 있다.
   * <p> 여기서는 브루트 포스를 이요하여 풀어본다.
   * <p> 두 수중 작은 수를 기준으로 잡고 두 수를 나누어 둘다 모두 나누어 떨어 질때까지 기준을 1씩 빼며 반복을 돈다.
   * <p> 주어진 정수 M개의 조합은 1번과 2~M번, 2번과 3~M번, 3번과 4~M번 .... M-1~M번까지 반복문을 돌며 구한다.
   * <p> 따라서 시간복잡도는 두번의 for문을 돌고 최대공약수를 구할때 반복문을 사용 때문에 M^3으로 볼 수 있다.
   * <p> 테스트 케이스의 수는 최대 99이고.
   * <p> M의 범위는 1 < M < 100이므로 99의 네제곱이므로 약 100의 네제곱으로 계산해도 1억건 이므로 1초의 시간제한 걸리지 않는다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    int caseNum = Integer.parseInt(br.readLine());

    for (int i = 0; i < caseNum; i++) {
      st = new StringTokenizer(br.readLine());
      List<Integer> nums = new ArrayList<>();

      while (st.hasMoreTokens()) {
        nums.add(Integer.parseInt(st.nextToken()));
      }

      int result = -1;
      int numsSize = nums.size();
      for (int j = 0; j < numsSize; j++) {
        for (int k = j + 1; k < numsSize; k++) {
          int a = nums.get(j);
          int b = nums.get(k);
          int min = a < b ? a : b;
          for (int l = min; l > 0; l--) {
            if (a % l == 0 && b % l == 0) {
              result = result > l ? result : l;
              break;
            }
          }
        }
      }

      bw.write(String.valueOf(result));
      bw.newLine();
    }

    bw.flush();
    bw.close();
    br.close();
  }
}
