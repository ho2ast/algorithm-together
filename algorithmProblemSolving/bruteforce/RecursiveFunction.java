package algorithmProblemSolving.bruteforce;

public class RecursiveFunction {

  public static void main(String[] args) {
    System.out.println(sum(10));
    System.out.println(recursiveSum(10));
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
}
