package programmers.stackandqueue;

import java.util.Stack;

/**
 * <p> 주식 가격이 배열로 주어질 때 가격이 떨어지지 않은 시간을 구하세요.
 * <p> 문제 바로가기: <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42584" />주식가격</a>
 */
public class StockPrice {

  public static void main(String[] args) {
    int[] arr = {2,2,3,1,5};

    for (int i : solution(arr)) {
      System.out.println(i);
    }

  }

  public static int[] solution(int[] prices) {
    int[] answer = new int[prices.length];
    Stack<Integer> priceIndex = new Stack<>();

    for (int i = 0; i < prices.length; i++) {
      int currentPrice = prices[i];

      if (!priceIndex.empty()) {
        while (!priceIndex.empty() && prices[priceIndex.peek()] > currentPrice) {
          answer[priceIndex.peek()] = i - priceIndex.pop();
        }
      }
      priceIndex.push(i);
    }

    while (!priceIndex.empty()) {
      int temp = priceIndex.pop();
      answer[temp] = prices.length - temp - 1;
    }

    return answer;
  }
}
