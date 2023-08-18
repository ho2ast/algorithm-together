package leetcode.easy;

/**
 * <p> 정수형 배열이 주어질 때, 배열을 정수로 나타낸 값에 1을 더한 후 반환 하세요.
 * <p> 문제 바로가기: <a href="https://leetcode.com/problems/plus-one/" />66. Plus One</a>
 */
public class No66PlusOne {
  public static void main(String[] args) {
    int[] a = {8, 9, 9, 9};
    for (int z : plusOne(a)) {
      System.out.println(z);
    }
  }

  /**
   * <p>배열을 정수로 변환 후 1을 더하는 문제이기 때문에 가장 마지막 자리만 확인 해주면 된다.
   * <p>문제는 9가 주어질 경우이다. 9에 1을 더하면 앞 자리수에 1씩 올림을 해야한다.
   * <p>배열의 뒷자리 부터 반복문을 돌며 9가 아닌 경우 해당 자리에 1을 더한 후 반환 하며
   * <p>9인 경우 해당 자리를 0으로 바꿔주고 앞자리 수로 넘어가 작업을 반복해준다.
   */
  public static int[] plusOne(int[] digits) {
    for (int i = digits.length - 1; i > -1; i--) {
      if (digits[i] != 9) {
        digits[i]++;
        return digits;
      } else {
        digits[i] = 0;
      }
    }

    digits = new int[digits.length + 1];
    digits[0] = 1;
    return digits;
  }
}
