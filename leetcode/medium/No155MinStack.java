package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> Stack class가 주어질 때 push, pop, top, getMin을 구현하시오.
 * <p> 문제 바로가기: <a href="https://leetcode.com/problems/min-stack/description/" />155. Min Stack</a>
 */
public class No155MinStack {
}

/**
 * <p> stack의 기본적인 기능을 구현 후 getMin()은 스택을 순환하며 최소값을 찾아 반환한다.
 */
class MinStack {

  private final List<Integer> stack;

  public MinStack() {
    this.stack = new ArrayList<>();
  }

  public void push(int val) {
    stack.add(val);
  }

  public void pop() {
    stack.remove(stack.size() - 1);
  }

  public int top() {
    return stack.get(stack.size() - 1);
  }

  public int getMin() {
    int min = stack.get(0);

    for (int i = 1; i < stack.size(); i++) {
      Integer i1 = stack.get(i);
      if (min > i1) {
        min = i1;
      }
    }

    return min;
  }
}
