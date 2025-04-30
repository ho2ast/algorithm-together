package leetcode.medium;

/**
 * <p> 정수 배열이 주어질 때, 배열의 원소를 변경하고, 범위가 주어질 때 배열의 구간합을 구하세요.
 * <p> 문제 바로가기: <a href="https://leetcode.com/problems/range-sum-query-mutable/description/" />307. Range Sum Query - Mutable</a>
 */
public class No912SortAnArray {

  public static void main(String[] args) {
    int[] arr = {5,2,3,1};
    int[] ints = sortArray(arr);
    for (int a : ints) {
      System.out.println(a + " ");
    }
  }


  public static int[] sortArray(int[] nums) {
    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < nums.length - i; j++) {
        if (nums[j] > nums[j + 1]) {
          int temp = nums[j];
          nums[j] = nums[j + 1];
          nums[j + 1] = temp;
        }

      }
    }

    return nums;
  }
}
