package programmers.exhaustiveSearch;

/**
 * <p> 숫자들이 하나씩 주어질 때 조합할 수 있는 숫자들 중 소수가 몇 개 인지 구하세요.
 * <p> 문제 바로가기: <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42839" />소수찾기</a>
 */
public class FindPrimeNumber {

  /**
   * <p> 1. 주어진 숫자들로 만들 수 있는 가장 큰수를 구한다, 에라토스테네스 체를 이용하여 소수를 구한다.
   * <p> 2. 에라토스테네스 체를 이용하여 가장 큰수까지 소수를 구한 후, 조합한 숫자들이 몇개가 포함되는지 구한다.
   */
  public static int solution(String numbers) {
    int answer = 0;
    int[] numbersArr = new int[numbers.length()];

    for (int i = 0; i < numbers.length(); i++) {
      numbersArr[i] = numbers.charAt(0);
    }


    return answer;
  }
}
