package leetcode.easy;

import java.util.Map;

/**
 * <p> 로마 숫자를 integer 변환 하여 반환 하세요.
 * <p> 문제 바로가기: <a href="https://leetcode.com/problems/roman-to-integer/" />13. Roman to Integer</a>
 */
public class No13RomanToInteger {
  /**
   * <p>주어진 로마자의 규칙에 의하면 좌측에 있는 수는 우측에 있는 수보다 커야 한다.
   * <p>하지만 좌측에 있는 수가 작을 경우 우측의 수에서 좌측의 수를 뺀 값을 이용한다.
   * <p>로마수의 문자를 key, 값을 value로 하는 map에 저장 해놓은 후 주어진 로마자로 값을 꺼내 사용하도록 한다.
   */
  public static void main(String[] args) {
    System.out.println(romanToInt("MCMXCIV"));
  }

  static Map<String, Integer> romanNum = Map.of(
      "I", 1,
      "V", 5,
      "X", 10,
      "L", 50,
      "C", 100,
      "D", 500,
      "M", 1000
  );

  public static int romanToInt(String s) {
    int result = 0;

    for (int i = 0; i < s.length(); i++) {
      String curRoman = String.valueOf(s.charAt(i));
      int curNum = romanNum.get(curRoman);

      if (i != s.length() - 1) {
        String nextRoman = String.valueOf(s.charAt(i + 1));
        int nextNum = romanNum.get(nextRoman);

        if (curNum < nextNum) {
          result += nextNum - curNum;
          i++;
          continue;
        }
      }

      result +=curNum;
    }

    return result;
  }
}
