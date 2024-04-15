package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> 2차원 배열이 주어지고 해당 배열의 값들이 간선으로 연결되어 있는 경우 중심이 되는 값을 찾으세요.
 * <p> 문제 바로가기:  <a href="https://leetcode.com/problems/find-center-of-star-graph/description/"/>1791. Find Center of Star Graph</a>
 */
public class No1791FindCenterOfStarGraph {

  /**
   * <p>모든 원소들은 중심의 숫자를 하나를 가진다.
   * <p>각 배열의 숫자를 리스트에 추가 한 후 같은 숫자가 하나라도 나올 경우 해당 값이 중심값이 되므로 리턴한다.
   */
  public int findCenter(int[][] edges) {
    List<Integer> numList = new ArrayList<>();
    int result = -1;
    boolean flag = false;

    for (int i = 0; i < edges.length; i++) {
      for (int j = 0; j < edges[i].length; j++) {
        int num = edges[i][j];
        if (numList.contains(num)) {
          result = num;
          flag = true;
          break;
        } else {
          numList.add(num);
        }
      }

      if (flag) {
        break;
      }
    }
    return result;
  }
}
