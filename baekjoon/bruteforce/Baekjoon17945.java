package baekjoon.bruteforce;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * <p> 이차방정식의 근을 구하여 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/17945"/>Baekjoon_17945 통학의 신</a>
 */
public class Baekjoon17945 {
  /**
   * x^2 + 2Ax + B = 0 주어진 이차 방정에 A와 B값을 대입하여 문제를 해결한다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());

    Set<Integer> result = new HashSet<>();
    for (int i = -1000; i <= 1000; i++) {
      if ((i * i) + (2 * A * i) + B == 0) {
        result.add(i);
      }
    }

    List<Integer> list = result.stream().sorted().collect(java.util.stream.Collectors.toList());
    StringBuilder sb = new StringBuilder();
    for (int num : list) {
      sb.append(num);
      sb.append(" ");
    }

    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
}
