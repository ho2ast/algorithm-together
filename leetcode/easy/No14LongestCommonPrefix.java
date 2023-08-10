package leetcode.easy;

import java.util.Arrays;

/**
 * <p> 주어진 문자열 배열에서 가장 긴 접두사를 출력하세요.
 * <p> 문제 바로가기: <a href="https://leetcode.com/problems/longest-common-prefix/" />14. Longest Common Prefix</a>
 */
public class No14LongestCommonPrefix {
  public static void main(String[] args) {
    String[] strArr = {"flower","flow","flight"};
    System.out.println(longestCommonPrefix(strArr));
  }

  /**
   * <p>주어진 문자열 배열들의 공통된 접두사를 찾는 문제이기 때문에 하나의 문자열을 선택하여 한 글자씩 비교를 한다.
   * <p>하나라도 맞지 않는 문자열이 나오면 비교를 종료하고 출력해준다.
   * <p>아래 솔루션은 고수님들의 풀이법을 사용하여 해결한다.
   * <p>주어진 문자열 배열은 사전순으로 정렬해준다.
   * <p>정렬한 뒤 첫번째 요소와 마지막 요소를 꺼내온 뒤.
   * <p>정수 인덱스를 만든 뒤 해당 while문을 돌며 두 인덱스 위치의 문자를 비교해준다.
   * <p>같은 경우 인덱스에 1을 더해주고 다른 경우 중지한다.
   */
  public static String longestCommonPrefix1(String[] strs) {
    String firstString = strs[0];
    StringBuilder prefix = new StringBuilder();
    boolean flag = true;

    for (int i = 0; i < firstString.length(); i++) {
      prefix.append(firstString.charAt(i));

      for (int j = 1; j < strs.length; j++) {
        if (!strs[j].startsWith(prefix.toString())) {
          prefix.deleteCharAt(prefix.length() - 1);
          flag = false;
          break;
        }
      }

      if (!flag) {
        break;
      }
    }

    return prefix.toString();
  }

  public static String longestCommonPrefix(String[] strs) {
    Arrays.sort(strs);

    String str1 = strs[0];
    String str2 = strs[strs.length - 1];
    int index = 0;

    while (index < str1.length() && index < str2.length()) {
      if (str1.charAt(index) == str2.charAt(index)) {
        index++;
      } else {
        break;
      }
    }

    return str1.substring(0, index);
  }
}
