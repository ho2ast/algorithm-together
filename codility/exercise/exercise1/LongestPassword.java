package codility.exercise.exercise1;

/**
 * <p> 패스워드 문자열이 주어질 때 조건이 통과하는 패스워드 중 가장 긴 패스워드의 길이를 출력하세요.
 * <p> 문제 바로가기: <a href="https://app.codility.com/programmers/trainings/1/longest_password/"/>Codility - LongestPassword</a>
 */
public class LongestPassword {
  public static void main(String[] args) {
    String a = "test 5 a0A pass007 ?xy1";
    Solution solution = new Solution();
    int result = solution.solution(a);

    System.out.println("result = " + result);
  }
}

class Solution {
  /**
   * <p> 아스키코드
   * <p> 0 ~ 9 (48 ~ 57)
   * <p> A ~ Z (65 ~ 90)
   * <p> a ~ z (97 ~ 122)
   */
  public int solution(String S) {
    String[] passwords = S.split(" ");
    int max = Integer.MIN_VALUE;

    for (int i = 0; i < passwords.length; i++) {
      String password = passwords[i];
      if (!password.matches("^[a-zA-Z0-9]*$")) {
        continue;
      }

      int digits = 0;
      int letters = 0;

      for (int j = 0; j < password.length(); j++) {
        if (65 <= password.charAt(j) && password.charAt(j) <=122) {
          letters++;
        } else if (48 <= password.charAt(j) && password.charAt(j) <= 57) {
          digits++;
        }
      }

      if (letters % 2 == 0 && digits % 2 == 1) {
        max = Math.max(max, password.length());
      }
    }

    return max;
  }
}
