package baekjoon.chanhyeng.weeks12;

import java.io.*;
import java.util.StringTokenizer;

/**
 * <p> 방향 없는 그래프가 주어 졌을 때 연결 요소의 개수를 구하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/11724"/>Baekjoon_11724 연결 요소의 개수</a>
 */
public class Baekjoon11724 {
  static int[] parent;
  /**
   * <p> 유니온 파인드를 이용해서 풀어보자.
   */
  public static void main(String[] args) throws IOException {
    int result = 0;

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    parent = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      parent[i] = i;
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      union(a, b);
    }

    for (int i = 1; i <= N; i++) {
      find(i);
    }

    for (int i = 1 ; i <= N ; i++) {
      for (int j = 1 ; j <= N ; j++) {
        if (parent[j] == i) {
          result++;
          break;
        }
      }
    }

    bw.write(String.valueOf(result));
    bw.flush();
    bw.close();
    br.close();
  }

  static int find(int a) {
    if (a == parent[a]) {
      return a;
    }

    return parent[a] = find(parent[a]);
  }

  static void union(int a, int b) {
    int pa = find(a);
    int pb = find(b);

    if (pa == pb) {
      return;
    }

    if (pa < pb) {
      parent[pb] = pa;
    } else {
      parent[pa] = pb;
    }
  }
}
