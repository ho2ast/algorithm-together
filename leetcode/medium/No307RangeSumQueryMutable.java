package leetcode.medium;

/**
 * <p> 정수 배열이 주어질 때, 배열의 원소를 변경하고, 범위가 주어질 때 배열의 구간합을 구하세요.
 * <p> 문제 바로가기: <a href="https://leetcode.com/problems/range-sum-query-mutable/description/" />307. Range Sum Query - Mutable</a>
 */
public class No307RangeSumQueryMutable {
  public static void main(String[] args) {

  }
}

/**
 * <p> update는 단순히 해당 배열의 인덱스를 주어진 값으로 변경하면 된다.
 * <p> 하지만 sumRange의 경우 기존의 누적합을 통해 구간값을 구하게 되면
 * <p> 값이 변경될 때마다 새로 구해야 하므로 시간 초과가 된다.
 * <p> 새로운 방법을 통해 해당 구간의 합을 구할 수 있는 방법을 찾아야한다.
 * <p> 태혁님이 알려준 모든 합을 구한다음 범위 전까지의 값을 빼는 방법을 써보자..
 */
class NumArray {

  private final int[] nums;
//  private final int[] prefixSums;

  private int totalSum = 0;

  public NumArray(int[] nums) {
    this.nums = nums;
//    this.prefixSums = new int[nums.length + 1];

//    getPrefixSum();
    getTotalSum();
  }

//  public void getPrefixSum() {
//    for (int i = 0; i < nums.length; i++) {
//      prefixSums[i + 1] = prefixSums[i] + nums[i];
//    }
//  }

  public void getTotalSum() {
    totalSum = 0;
    for (int item : nums) {
      totalSum += item;
    }
  }

  public int sumRange(int left, int right) {
//    if (left == right) {
//      return nums[left];
//    }
//    return left == 0 ? prefixSums[++right] : prefixSums[++right] - prefixSums[left];
    int tempSum = totalSum;
    for (int i = 0; i < left; i++) {
      tempSum -= nums[i];
    }

    for (int i = nums.length - 1; i > right; i--) {
      tempSum -= nums[i];
    }

    return tempSum;
  }

  public void update(int index, int val) {
    nums[index] = val;
//    getPrefixSum();
    getTotalSum();
  }
}
