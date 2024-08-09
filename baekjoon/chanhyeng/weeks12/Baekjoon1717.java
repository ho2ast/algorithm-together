package baekjoon.chanhyeng.weeks12;

import java.io.*;
import java.util.StringTokenizer;

/**
 * <p> 주어지는 두 수가 같은 집합에 포함되어 있는지 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/1717"/>Baekjoon_1717 집합의 표현</a>
 */
public class Baekjoon1717 {
  static int[] parent;
  /**
   * 유니온 파인드를 이용해서 문제를 해결해보자.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    parent = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      parent[i] = i;
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int operation = Integer.parseInt(st.nextToken());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      if (operation == 1) {
        if (find(a) == find(b)) {
          bw.write("YES");
        } else {
          bw.write("NO");
        }
        bw.newLine();
      } else {
        union(a,b);
      }
    }

    bw.flush();
    bw.close();
    br.close();
  }

  static int find(int a) {
    if (parent[a] == a) {
      return a;
    }

    return parent[a] = find(parent[a]);
  }

  static void union(int a, int b) {
    a = find(a);
    b = find(b);

    if (a < b) {
      parent[b] = a;
    } else {
      parent[a] = b;
    }
  }
}
