package leetcode.easy;

/**
 * <p> 정수가 주어질 때 해당 정수가 팰린드롬(거꾸로 읽어도 동일)인지 반환 하세요.
 * <p> 문제 바로가기:  <a href="https://leetcode.com/problems/palindrome-number/" />9. Palindrome Number</a>
 */
public class No9PalindromeNumber {
  /**
   * <p>주어진 정수를 문자열로 변환 후 해당 수를 거꾸로 만든 후 비교한다.
   * <p>거꾸로 변환 하는 방법은 {@link String#length()}이용하여 길이만큼 loop를 돌며
   * <p>맨 뒷자리부터 {@link StringBuilder}에 저장한 후 비교한다.
   */
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.isPalindrome(-121));
  }
}

class Solution {
  public boolean isPalindrome(int x) {
    StringBuilder palindrome = new StringBuilder();
    String strX = String.valueOf(x);

    for (int i = strX.length() - 1; i > -1; i--) {
      palindrome.append(strX.charAt(i));
    }

    return strX.contentEquals(palindrome);
  }
}
