package baekjoon.implement;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * <p> 숫자의 개수.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/2577"/>Baekjoon_2577 숫자의 개수</a>
 */
public class Baekjoon2577 {
  /**
   * map에 0부터9까지 키로 잡고 0으로 세팅한다.
   * 곱합 수를 반복문 돌면서 해당 숫자를 map에서 꺼내서 1을 더해준다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n1 = Integer.parseInt(br.readLine());
    int n2 = Integer.parseInt(br.readLine());
    int n3 = Integer.parseInt(br.readLine());

    int result = n1 * n2 * n3;
    Map<Character, Integer> characterIntegerMap = getCharacterIntegerMap(result);

    characterIntegerMap.forEach((key, value) -> System.out.println(value));

    br.close();
  }

  private static Map<Character, Integer> getCharacterIntegerMap(int result) {
    String strResult = String.valueOf(result);

    Map<Character, Integer> characterIntegerMap = new HashMap<>();
    characterIntegerMap.put('0', 0);
    characterIntegerMap.put('1', 0);
    characterIntegerMap.put('2', 0);
    characterIntegerMap.put('3', 0);
    characterIntegerMap.put('4', 0);
    characterIntegerMap.put('5', 0);
    characterIntegerMap.put('6', 0);
    characterIntegerMap.put('7', 0);
    characterIntegerMap.put('8', 0);
    characterIntegerMap.put('9', 0);

    for (int i = 0; i < strResult.length(); i++) {
      char c = strResult.charAt(i);
      characterIntegerMap.put(c, characterIntegerMap.get(c) + 1);
    }
    return characterIntegerMap;
  }
}
