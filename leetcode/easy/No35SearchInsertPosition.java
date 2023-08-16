package leetcode.easy;

/**
 * <p> 정렬된 정수 배열이 주어지고, 정수가 주어질 때 정수가 들어갈 인덱스를 구하세요.
 * <p> 문제 바로가기: <a href="https://leetcode.com/problems/search-insert-position/" />35. Search Insert Position</a>
 */
public class No35SearchInsertPosition {

  public static void main(String[] args) {

  }

  /**
   * <p>반복문을 돌며 배열 값이 target 보다 같거나 커질 때 인덱스를 반환 해준다.
   */
  public int searchInsert(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] >= target) {
        return i;
      }
    }
    return nums.length;
  }
}
