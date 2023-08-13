package leetcode.easy;

/**
 * <p> 비 내림차순으로 정렬된 정수형 배열에서 중복된 수를 제거한 후 배열의 길이를 반환 하세요.
 * <p> 문제 바로가기:  <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/" />26. Remove Duplicates from Sorted Array</a>
 */
public class No26RemoveDuplicatesFromSortedArray {

  public static void main(String[] args) {
    int[] nums = {0,0,1,1,1,2,2,3,3,4};
    System.out.println(removeDuplicates(nums));
  }

  /**
   * <p>비오름차순 배열이므로 첫번째 요소를 currNum 값으로 두고 현재 값에서 떨어진 정도를 나타내는 offset 변수를 하나 둔다.
   * <p>반복문의 index 1부터 시작하고 currNum 과 nums[i]를 비교하여 같으면 offset++; 처리를 해준다.
   * <p>만약 두 값이 다를 경우 i 부터 offset까지의 거리를 빼준 위치에 nums[i]값을 넣어준다.
   * <p>또한 중복되지 않는 원소의 개수를 알 수 있는 count값을 더해주고 currNum값을 nums[i]로 바꿔준다.
   */
  public static int removeDuplicates(int[] nums) {
    int count = 1;

    int currNum = nums[0];
    int offset = 0;

    for (int i = 1; i < nums.length; i++) {
      if (currNum != nums[i]) {
        count++;
        nums[i - offset] = nums[i];
        currNum = nums[i];
      } else {
        offset++;
      }
    }

    return count;
  }
}
