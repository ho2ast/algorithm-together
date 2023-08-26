package algorithmProblemSolving.bruteforce;

import java.util.ArrayList;
import java.util.List;

public class RecursiveFunction {

  public static void main(String[] args) {
    System.out.println(sum(10));
    System.out.println(recursiveSum(10));

    pick(7, new ArrayList<>(), 4);
  }

  /**
   * <p>반복 함수를 이용한 1부터 n까지의 합
   */
  public static int sum(int n) {
    int sum = 0;

    for (int i = 0; i <= n; i++) {
      sum += i;
    }

    return sum;
  }

  /**
   * <p>재귀 함수르르 이용한 1부터 n까지의 합
   * <p>1부터 n까지 중 n을 제외한 후 자기 자신을 호출 n을 제거하지 않고 1을 제거하면 해결할 수 없다
   * <p>n이 1이 되었을 때는 더이상 쪼갤 수 없기 때문에 답을 반환해야 한다. 쪼개지지 않은 작업을 재귀 함수의 기저 사례라고 한다.
   */
  public static int recursiveSum(int n) {
    if (n == 1) return 1;
    return n + recursiveSum(n - 1);
  }

  /**
   * <p>0부터 차례대로 번호가 매겨진 n의 원소중 j개를 고르는 모든 경우의 수를 구한다.
   * <p>n -> 전체 원소의 수
   * <p>picked -> 지금까지 고른 원소들의 번호
   * <p>toPick -> 더 고를 원소의 수
   */
  public static void pick(int n, List<Integer> picked, int toPick) {
    if (toPick == 0) {
      for (Integer pickedNum : picked) {
        System.out.print(pickedNum);
      }
      System.out.println();
      return;

    }

    int smallest = picked.isEmpty() ? 0 : picked.get(picked.size() - 1) + 1;

    for (int next = smallest; next < n; ++next) {
      picked.add(next);
      pick(n, picked, toPick - 1);
      picked.remove(picked.size() - 1);
    }
  }
}
