package baekjoon.setandmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * <p> 문자열이 주어질 때 해당 문자열의 서로 다른 부분 문자열의 길이를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/11478"/>Baekjoon_11478 서로 다른 부분 문자열의 개수</a>
 */
public class Level8 {
  /**
   * <p> 1부터 문자열의 길이까지 loop를 돈다. (일부분으로 만들 문자열의 길이)
   * <p> loop 내부의 loop 돌며 문자의 일부분을 만들어 {@link java.util.Set}에 저장한다.
   * <p> 시작위치와 일부분으로 만들 문자열의 길이가 주어진 문자열의 size와 같을 떄 까지 반복해준다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Set<String> set = new HashSet<>();
    String word = br.readLine();
    br.close();

    for (int i = 1; i <= word.length(); i++) {
      int startIndex = 0;
      while (startIndex + i <= word.length()) {
        set.add(word.substring(startIndex, startIndex + i));
        startIndex++;
      }
    }

    System.out.println(set.size());
  }
}
