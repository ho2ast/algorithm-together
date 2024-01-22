package leetcode.medium;

import java.util.Stack;

/**
 * <p> 후위 표기법으로 식이 주어질 때 결과 값을 출력하세요.
 * <p> 문제 바로가기: <a href="https://leetcode.com/problems/evaluate-reverse-polish-notation/description/" />150. Evaluate Reverse Polish Notation</a>
 */
public class No150EvaluateReversePolishNotation {

  public static void main(String[] args) {
    String[] s = {"2", "1", "+", "3", "*"};

    System.out.println(evalRPN(s));
  }

  /**
   * <p> 후위표기법으로 주어질 경우 피연산자가 나올 경우 stack에 push하고
   * <p> 연산자가 나올 경우 직전 두 개의 피연산자를 pop()하여 연산자로 계산 하면 된다.
   * <p> 계산한 결과값은 다시 stack에 push 해준다.
   * <p> 나눗셈과 뺄셈이 나올 경우 피연산자의 순서가 중요하므로 두개의 피연산자를 pop할 때 변수로 저장 하여 사용한다.
   */
  public static int evalRPN(String[] tokens) {
    Stack<String> stack = new Stack<>();
    int sum = 0;

    if (tokens.length == 1) {
      return Integer.parseInt(tokens[0]);
    }

    for (String token : tokens) {
      switch (token) {
        case "*" -> {
          sum = Integer.parseInt(stack.pop()) * Integer.parseInt(stack.pop());
          stack.push(String.valueOf(sum));
        }
        case "/" -> {
          int int1 = Integer.parseInt(stack.pop());
          int int2 = Integer.parseInt(stack.pop());

          sum = int2 / int1;
          stack.push(String.valueOf(sum));
        }
        case "+" -> {
          sum = Integer.parseInt(stack.pop()) + Integer.parseInt(stack.pop());
          stack.push(String.valueOf(sum));
        }
        case "-" -> {
          int int1 = Integer.parseInt(stack.pop());
          int int2 = Integer.parseInt(stack.pop());

          sum = int2 - int1;
          stack.push(String.valueOf(sum));
        }
        default -> stack.push(token);
      }
    }

    return sum;
  }
}
