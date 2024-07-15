package baekjoon.chanhyeng.weeks9;

import java.io.*;
import java.util.*;

/**
 * <p> 두 사람의 번호가 주어질 때 두 사람의 촌수를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/2644"/>Baekjoon_2644 촌수계산</a>
 */
public class Baekjoon2644 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int num = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int start = Integer.parseInt(st.nextToken());
    int end = Integer.parseInt(st.nextToken());

    int m = Integer.parseInt(br.readLine());

    List<List<Integer>> graph = new ArrayList<>();

    for (int i = 0; i <= num; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      graph.get(a).add(b);
      graph.get(b).add(a);
    }
    int[] bfs = bfs(graph, end, start);
    bw.write(String.valueOf(bfs == null ? -1 : bfs[start]));
    bw.flush();
    bw.close();
    br.close();
  }

  public static int[] bfs(List<List<Integer>> graph, int start, int end) {
    Queue<Integer> q = new ArrayDeque<>();
    boolean[] visited = new boolean[graph.size() + 1];
    int[] dist = new int[graph.size() + 1];

    q.add(start);
    visited[start] = true;

    while (!q.isEmpty()) {
      Integer cur = q.poll();

      for (Integer next : graph.get(cur)) {
        if (!visited[next]) {
          dist[next] = dist[cur] + 1;
          if (next == end) {
            return dist;
          } else {
            visited[next] = true;
            q.add(next);
          }
        }
      }
    }

    return null;
  }
}
