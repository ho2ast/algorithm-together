package leetcode.easy;

/**
 * <p> 주어진 계단을 오를 수 있는 모든 경우의 수를 구하세요.
 * <p> 문제 바로가기: <a href="https://leetcode.com/problems/climbing-stairs/" />70. Climbing Stairs</a>
 */
public class No70ClimbingStairs {

  public static void main(String[] args) {
    System.out.println(climbStairs(1));

  }

  /**
   * <p>주어진 계단(n)을 오를 수 있는 방법의 경우의 수를 구해야 한다.
   * <p>계단은 한번에 1칸 또는 2칸을 오를 수 있다.
   * <p>즉, 1과 2를 사용하여 합이 n이 되는 경우의 수를 구하면 된다.
   * <p>한가지 힌트를 얻었다. 1칸 또는 2칸을 이동한 후 남은 계단의 수의 방법은 알 수 있다. like 피보나치
   * <p>예를 들어 계단이 3칸(n = 3)인 경우 첫 이동을 1칸으로 하면 남은 칸은 2칸이고, 2칸이동 후 남은 칸은 1칸이다.
   * <p>2칸의 경우의 수는 2, 1칸의 경우의 수는 1 이다. 이 둘을 합치면 n = 3일 때의 경우의 수를 알 수 있다.
   * <p>피보나치의 수를 구하는 방식과 비슷하다. 재귀 방식으로도 풀 수 있지만 TLE가 발생 할 수 있다.
   */
  public static int climbStairs(int n) {
    int a = 0;
    int b = 1;

    for (int i = 0; i < n; i++) {
      int c = a;
      a = b;
      b = c + b;
    }
    return b;
  }
}
