package leetcode.easy;

import java.util.Stack;

/**
 * <p> 두개의 stack을 이용하여 queue를 구현하세요.
 * <p> 문제 바로가기: <a href="https://leetcode.com/problems/implement-queue-using-stacks/description/" />232. Implement Queue using Stacks</a>
 */
public class No232ImplementQueueUsingStacks {


}


/**
 * <p> 두 개의 스택에서 push되는 값들은 stack1에 모두 저장한다.
 * <p> 그 후 pop()이나 peek()이 수행 될때마다 loop를 돌며 stack1의 값을 모두 pop()하여 stack2에 push() 한다.
 * <p> 그럴 경우 stack1에 쌓인 역순으로 stack2에 쌓이게 되므로 선입선출이 가능하다.
 * <p> 그 후 stack2에서 pop()이나 peek()을 수행한다.
 * <p> 해당 작업 종료 후 loop를 돌면 stack2 pop()하며 stack1에 다시 push()해준다.
 */
class MyQueue {

  private final Stack<Integer> stack1;
  private final Stack<Integer> stack2;

  public MyQueue() {
    this.stack1 = new Stack<>();
    this.stack2 = new Stack<>();
  }

  public void push(int x) {
    stack1.push(x);
  }

  public int pop() {
    while (!stack1.empty()) {
      stack2.push(stack1.pop());
    }

    int result = stack2.pop();

    while (!stack2.empty()) {
      stack1.push(stack2.pop());
    }

    return result;
  }

  public int peek() {
    while (!stack1.empty()) {
      stack2.push(stack1.pop());
    }

    int result = stack2.peek();

    while (!stack2.empty()) {
      stack1.push(stack2.pop());
    }

    return result;
  }

  public boolean empty() {
    return stack1.isEmpty() && stack2.isEmpty();
  }
}