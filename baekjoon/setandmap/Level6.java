package baekjoon.setandmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * <p> 듣도보도 못한 사람을 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/1764"/>Baekjoon_1764 듣보잡</a>
 */
public class Level6 {
  /**
   * <p> 듣도 못한 사람의 수와 보도 못한 사람의 수 중 적은 쪽을 선택하여 해당 이름을
   * <p> {@link java.util.Map}에 저장 한다.
   * <p> 그 후 loop를 돌며 map에 저장 되어 있는지 확인하여 있으면 출력한다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    Map<String, Boolean> map = new HashMap<>();
    List<String> arr = new ArrayList<>();
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    for (int i = 0; i < N; i++) {
      map.put(br.readLine(), true);
    }

    for (int i = 0; i < M; i++) {
      String name = br.readLine();
      if (map.containsKey(name)) {
        arr.add(name);
      }
    }

    arr.sort(String::compareTo);
    br.close();

    System.out.println(arr.size());
    arr.forEach(System.out::println);
  }
}
