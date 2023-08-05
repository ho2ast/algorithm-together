package dynamic_programming_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p> 모든 집을 규칙에 따라 색칠하는 최소 비용을 구하여 출력하세.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/1149"/>Baekjoon_1149 RGB 거</a>
 */
public class Level6 {
  /**
   * <p>첫 번째로 집의 개수가 주어지고, 그 다음 줄 부터 각각의 집의 색에 따른 색칠 비용이 주어진다(순서는 빨강, 초록, 파랑).
   * <p>집의 개수와 길이가 같은 메모이제이션용 배열을 만든다.
   * <p>집의 개수 만큼 반복을 하며 색칠한다.
   * <p>규칙에 맞게 색칠을 하며 해당 집이 어떤 색으로 색칠 하였는지 메모이제이션 배열에 저장(색상은 순서대로 주어지므로 1, 2, 3 중 하나로 로 저장)
   * <p>첫 번째 집은 세 가지 색상 중 최소 비용인 색상으로 색칠 한다.
   * <p>이 후 주어진 규칙에 따라 같은 색으로는 연속해서 색칠 할수 없기 때문에
   * <p>이전 집에서 칠했던 색상을 제외한 후 남은 색상 중 최소 값으로 색칠.
   */
  public static void main(String[] args) {
    try (
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    ) {
      int cost = 0;
      int n = Integer.parseInt(br.readLine());
      int[] coloredArr = new int[n];

      for (int i = 0; i < n; i++) {
        String[] costArr = br.readLine().split(" ");
        if (i != 0) {
          costArr[coloredArr[i - 1] - 1] = "0";
        }
        int minCostIndex = getMinCostIndex(costArr);
        cost += Integer.parseInt(costArr[minCostIndex]);
        coloredArr[i] = minCostIndex + 1;
      }

      System.out.println(cost);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static int getMinCostIndex(String[] costArr) {
    int minCost = Integer.MAX_VALUE;
    int minCostIndex = -1;

    for (int j = 0; j < costArr.length; j++) {
      int currentCost = Integer.parseInt(costArr[j]);
      if (currentCost != 0 && minCost > currentCost) {
        minCost = currentCost;
        minCostIndex = j;
      }
    }

    return minCostIndex;
  }
}
