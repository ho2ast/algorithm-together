package leetcode.medium;

import java.util.Arrays;

/**
 * <p> 인터벌 시작과 끝의 배열이 주어질 때 인터벌들이 안겹칠 수 있는 최소한의 삭제 수를 구하세요.
 * <p> 문제 바로가기: <a href="https://leetcode.com/problems/non-overlapping-intervals/description/" />435. Non-overlapping Intervals</a>
 */
public class No435NonOverlappingIntervals {

  public int eraseOverlapIntervals(int[][] intervals) {

    Arrays.sort(intervals, (o1, o2) -> {
      if (o1[1] == o2[1]) {
        return o2[0] - o1[0];
      }
      return o1[1] - o2[1];
    });

    int result = 1;
    int endValue = intervals[0][1];

    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] >= endValue) {
        result++;
        endValue = intervals[i][1];
      }
    }

    return intervals.length - result;
  }
}
