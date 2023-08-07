package baekjoon.dynamic_programming_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <p> 모든 집을 규칙에 따라 색칠하는 최소 비용을 구하여 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/1149"/>Baekjoon_1149 RGB 거리</a>
 */
public class Level6 {
  final static int RED = 0;
  final static int GREED = 1;
  final static int BLUE = 2;
  static int[][] colorCost;
  static int[][] DP;
  /**
   * <p>첫 번째로 집의 개수가 주어지고, 그 다음 줄 부터 각각의 집의 색에 따른 색칠 비용이 주어진다(순서는 빨강, 초록, 파랑).
   * <p>주어진 색칠 비용을 저장하기 위한 배열을 만든다 int[집의개수][3].
   * <p>주어진 모든 경우의 비용을 저장할 수 있는 배열 DP를 동일하게 만들어 준다. int[집의개수][3].
   * <p>DP를 이용하여 해당 색상을 선택했을 때 선택할 수 있는 집들의 색상의 비용을 DP에 저장한다.
   */
  public static void main(String[] args) {
    try (
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    ) {
      int n = Integer.parseInt(br.readLine());
      colorCost = new int[n][3];
      DP = new int[n][3];


      for (int i = 0; i < n; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        colorCost[i][RED] = Integer.parseInt(st.nextToken());
        colorCost[i][GREED] = Integer.parseInt(st.nextToken());
        colorCost[i][BLUE] = Integer.parseInt(st.nextToken());
      }

      // DP의 첫번째 값(집)은 각 색상비용의 첫번째 값으로 초기화
      DP[0][RED] = colorCost[0][RED];
      DP[0][GREED] = colorCost[0][GREED];
      DP[0][BLUE] = colorCost[0][BLUE];


      System.out.print(Math.min(Paint_cost(n - 1, RED), Math.min(Paint_cost(n - 1, GREED), Paint_cost(n - 1, BLUE))));
      System.out.println(1);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static int Paint_cost(int N, int color) {

    if (DP[N][color] == 0) {
      if (color == RED) {
        DP[N][RED] = Math.min(Paint_cost(N - 1, GREED), Paint_cost(N - 1, BLUE)) + colorCost[N][RED];
      } else if (color == GREED) {
        DP[N][GREED] = Math.min(Paint_cost(N - 1, RED), Paint_cost(N - 1, BLUE)) + colorCost[N][GREED];
      } else {
        DP[N][BLUE] = Math.min(Paint_cost(N - 1, RED), Paint_cost(N - 1, GREED)) + colorCost[N][BLUE];
      }
    }

    return DP[N][color];
  }
}
