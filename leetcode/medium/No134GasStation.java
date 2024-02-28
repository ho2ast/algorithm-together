package leetcode.medium;

/**
 * <p> gas와 cost 배열이 주어질 때 순환 할 수 있는지 출력하세요.
 * <p> 문제 바로가기: <a href="https://leetcode.com/problems/gas-station/" />134. Gas Station</a>
 */
public class No134GasStation {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int total = 0;
    int sum = 0;
    int start = 0;

    for (int i = 0; i < gas.length; i++) {
      sum += gas[i] - cost[i];
      total += gas[i] - cost[i];

      if (sum < 0) {
        sum = 0;
        start = i + 1;
      }
    }
    return total < 0 ? -1 : start;
  }
}
