package leetcode.easy;

import java.util.Arrays;

/**
 * <p> 비 내림차순의 두 정수 배열이 주어질 때, 두 배열을 merge하세요.
 * <p> 문제 바로가기: <a href="https://leetcode.com/problems/merge-sorted-array/" />88. Merge Sorted Array</a>
 */
public class No88MergeSortedArray {

  public static void main(String[] args) {
    int[] num1 = {1};
    int[] num2 = {};
    int m = 1;
    int n = 0;

    merge(num1, m, num2, n);
  }

  /**
   * <p> 두 배열 중 합쳐야 할 배열은 num2이다. 즉, n > 0 이상 일 경우에만 merge 작업을 진행하면 된다.
   * <p> n만큼 num1에는 0으로 초기화되어 있을 것이다. num2를 num1에 채운 후 정렬 알고리즘을 쓰면 어떨까?
   * <p> 하지만 너무 느리고 메모리도 많이 잡아 먹는다. 새로운 방법을 찾아보자.
   * <p>
   */
  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    if (n != 0) {
      for (int i = 0; i < n; i++) {
        nums1[i + m] = nums2[i];
      }

    }

    Arrays.sort(nums1);
  }
}
