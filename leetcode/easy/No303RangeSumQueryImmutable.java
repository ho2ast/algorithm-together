package leetcode.easy;

/**
 * <p> 정수 배열이 주어지고, 범위가 주어질 때 구간합을 구하세요.
 * <p> 문제 바로가기: <a href="https://leetcode.com/problems/range-sum-query-immutable/description/" />303. Range Sum Query - Immutable</a>
 */
public class No303RangeSumQueryImmutable {

  static int[] array = new int[]{1, 4, -6};


  public static void main(String[] args) {
    NumArray numArray = new NumArray(array);

    numArray.sumRange(1, 1);
  }
}


/**
 * <p>해당 클래스의 멤버변수로 배열을 설정해두고 생성자로 배열을 설정 해준 후 반복문을 통해 범위의 합을 구해준다.
 * <p>누적합을 구한 후 구간합을 구해 준다.
 */
class NumArray {

  private final int[] nums;
  private final int[] prefixSums;

  public NumArray(int[] nums) {
    this.nums = nums;
    this.prefixSums = new int[nums.length + 1];

    for (int i = 0; i < nums.length; i++) {
      prefixSums[i + 1] = prefixSums[i] + nums[i];
    }
  }

  public int sumRange(int left, int right) {
    if (left == right) {
      return nums[left];
    }
    return left == 0 ? prefixSums[++right] : prefixSums[++right] - prefixSums[left];
  }
}