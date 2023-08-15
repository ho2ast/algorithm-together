package leetcode.easy;

/**
 * <p> 문자열 haystack이 주어지고 다른 문자열 needle이 주어질 때 needle 이 haystack 포함될 때 시작 index를 구하세요.
 * <p> 문제 바로가기: <a href="https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/" />28. Find the Index of the First Occurrence in a String</a>
 */
public class No28FindTheIndexOfTheFirstOccurrenceInAString {
  public static void main(String[] args) {
    System.out.println(strStr("leetcode", "leeto"));
  }

  /**
   * <p>{@link String#contains(CharSequence)} 함수를 이용해 needle이 포함되어 있는지 여부를 확인한다.
   * <p>포함되어 있으면 {@link String#indexOf(String)} 함수를 이용해 needle의 시작 index를 출력하고
   * <p>포함되어 있지 않으면 -1을 출력한다.
   */
  public static int strStr(String haystack, String needle) {
    return haystack.contains(needle) ? haystack.indexOf(needle) : -1;
  }
}
