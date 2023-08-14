package leetcode.easy;

/**
 * <p> 정수 배열이 주어지고 정수 k가 주어질 때, 배열에서 k를 제거 하고 k를 제외한 배열의 길이를 반환하세요.
 * <p> 문제 바로가기: <a href="https://leetcode.com/problems/remove-element/" />27. Remove Element</a>
 */
public class No27RemoveElement {
  public static void main(String[] args) {
    System.out.println(removeElement(new int[]{3, 2, 2, 3}, 3));
    System.out.println(removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    System.out.println(removeElement(new int[]{1}, 1));
    System.out.println(removeElement(new int[]{2}, 3));
  }

  /**
   * <p>count 변수를 0으로 초기화 한다.
   * <p>loop를 돌며 nums[i] != val 경우 nums[count]에 nums[i]를 대입하고 count++를 해준다.
   * <p>이는 val 값과 같은 수의 인덱스 자리에 같지 않은 수를 대입하여 배열을 재배치 하는 방법이다.
   */
  public static int removeElement(int[] nums, int val) {
    int count = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != val) {
        nums[count] = nums[i];
        count++;
      }
    }
    return count;
  }
}
