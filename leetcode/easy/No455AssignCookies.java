package leetcode.easy;

import java.util.Arrays;

/**
 * <p> 2개의 배열이 주어 질 때 쿠키 분배의 최대값을 출력하세요.
 * <p> 문제 바로가기: <a href="https://leetcode.com/problems/assign-cookies" />455. Assign Cookies</a>
 */
public class No455AssignCookies {

  public int findContentChildren(int[] g, int[] s) {
    int result = 0;

    Arrays.sort(g);
    Arrays.sort(s);

    for (int i = g.length - 1; i > -1; i--) {
      for (int j = s.length - 1; j > -1; j--) {
        if (g[i] <= s[j]) {
          result++;
          break;
        }
      }
    }

    return result;
  }
}
