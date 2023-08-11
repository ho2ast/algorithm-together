package leetcode.easy;

import java.util.Stack;

/**
 * <p> 주어지 괄호의 짝이 올바른지 출력하세요.
 * <p> 문제 바로가기: <a href="https://leetcode.com/problems/valid-parentheses/" />20. Valid Parentheses</a>
 */
public class No20ValidParentheses {

  public static void main(String[] args) {
    System.out.println(isValid("([]{[]}{})"));
  }

  /**
   * <p>괄호가 올바른 짝인지 확인 하기 위해서는 주어진 괄호를 {@link java.util.Stack}을 이용하여 해결한다.
   * <p>열리는 괄호가 괄호가 나오면 {@link java.util.Stack#push(Object)}를 하고,
   * <p>닫는 괄호 가 나오면 스택의 {@link Stack#peek()}을 이용하여 올바른 짝인지 확인하고 올바른 짝이면 {@link Stack#pop()}을 이용하여 제거한다.
   * <p>올바르지 않은 괄호의 짝이면 곧바로 false를 리턴한다.
   * <p>모든 괄호를 소모한 후 stack이 empty인지 확인한다.
   * <p>위의 문제해결 방법을 응용하여 흥미로운 방법을 발견하였다.
   * <p>여는 괄호가 나왔을 때 해당 괄호를 넣지 않고 짝이 되는 닫는 괄호를 stack에 넣은후 닫는 괄호가 나왔을 떄 같은 지 비교하는 방법이다.
   * <p>또 주어진 문자열을 {@link String#toCharArray()}를 이용하여 문자 배열을 만들어 이용한다.
   */
//  public static boolean isValid(String s) {
//    Stack<String> stack = new Stack<>();
//
//    for (int i = 0; i < s.length(); i++) {
//      String parentheses = String.valueOf(s.charAt(i));
//      if (parentheses.equals("(") || parentheses.equals("{") || parentheses.equals("[")) {
//        stack.push(parentheses);
//      } else {
//        if (stack.isEmpty()) {
//          return false;
//        }
//
//        String openingParentheses = stack.peek();
//        if (openingParentheses.equals("(") && !parentheses.equals(")")) {
//          return false;
//        } else if (openingParentheses.equals("{") && !parentheses.equals("}")) {
//          return false;
//        } else if (openingParentheses.equals("[") && !parentheses.equals("]")) {
//          return false;
//        }
//
//        stack.pop();
//      }
//    }
//
//    return stack.isEmpty();
//  }

  public static boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();

    for (char c : s.toCharArray()) {
      if (c == '(')
        stack.push(')');
      else if (c == '{')
        stack.push('}');
      else if (c == '[')
        stack.push(']');
      else if (stack.isEmpty() || stack.pop() != c)
        return false;
    }

    return stack.isEmpty();
  }
}
