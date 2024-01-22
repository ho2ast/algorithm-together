package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> 정수가 주어질 때 해당 정수가 팰린드롬(거꾸로 읽어도 동일)인지 반환 하세요.
 * <p> 문제 바로가기:  <a href="https://leetcode.com/problems/valid-parentheses/description/" />9. Palindrome Number</a>
 */
public class No20ValidParenthesesWithArray {
  public static void main(String[] args) {
    String s = "()";
    isValid(s);
  }

  /**
   * <p> 괄호는 무조건 짝이 맞아야 한다. [,(가 나왔으면 ),]이 순서대로 나와야한다.
   * <p> 그러므로 여는 괄호가 나왔을 떄 해당하는 닫는 괄호를 스택에 넣고 해당 괄호가 나왔을 때 스택에서 꺼내서 동일 할 경우 삭제.
   * <p> 다른 경우는 유효하지 않은 괄호이므로 바로 false를 return 해준다.
   */
  public static boolean isValid(String s) {
    List<Character> stack = new ArrayList<>();

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(')
        stack.add(')');
      else if (s.charAt(i) == '{')
        stack.add('}');
      else if (s.charAt(i) == '[')
        stack.add(']');
      else if (stack.isEmpty() || stack.remove(stack.size() - 1) != s.charAt(i))
        return false;
    }

    return stack.isEmpty();
  }
}
