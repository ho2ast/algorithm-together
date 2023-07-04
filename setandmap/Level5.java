package setandmap;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * <p> 주어진 카드 중 상근이가 가지고 있는 카드가 몇개인지 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/10816"/>Baekjoon_10816 숫자 카드 2/a>
 */
public class Level5 {
  /**
   * <p> 상근이가 가진 숫자를 {@link java.util.Map}의 key로 value를 카운트로 저장한다.
   * <p> 저장 시 {@link Map#getOrDefault(Object, Object)}를 이용하여 저장한다.
   * <p> 그 후 주어지는 카드를 key로 찾아 value값을 출력한다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    StringBuilder sb = new StringBuilder();
    Map<Integer, Integer> map = new HashMap<>();
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int number = Integer.parseInt(st.nextToken());
      map.put(number, map.getOrDefault(number, 0) + 1);
    }

    int M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      int number = Integer.parseInt(st.nextToken());
      bw.write(map.getOrDefault(number, 0) + " ");
    }

    bw.flush();
    bw.close();
    br.close();
//    System.out.println(sb);
  }
}
