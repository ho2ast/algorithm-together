package graph_and_traversal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * <p> 시작 정점에 시작하여 각 정점을 너비 우선 탐색으로 방문할 때 정점의 방문 순서를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/24445"/>Baekjoon_24445 알고리즘 수업 - 너비 우선 탐색 2</a>
 */
public class Level4 {

  static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  static int[] visited;
  /**
   * <p> 너비 우선 탐색을 구현하여 처리한다.
   * <p> 단, 정점의 인접 정점의 방문은 내림차순으로 방문한다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int R = Integer.parseInt(st.nextToken());

    visited = new int[N + 1];

    for (int i = 0; i <= N; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      graph.get(u).add(v);
      graph.get(v).add(u);
    }

    graph.forEach(array -> array.sort((o1, o2) -> o2 - o1));

    bfs(R);

    for (int i = 1; i < visited.length; i++) {
      bw.write(String.valueOf(visited[i]));
      bw.newLine();
    }

    bw.flush();
    bw.close();
    br.close();
  }

  private static void bfs(int start) {
    ArrayList<Integer> queue = new ArrayList<>();
    int count = 1;
    visited[start] = count++;
    queue.add(start);

    while (!queue.isEmpty()) {
      int node = queue.get(0);
      queue.remove(0);

      for (int i = 0; i < graph.get(node).size(); i++) {
        int nextNode = graph.get(node).get(i);

        if (visited[nextNode] != 0) {
          continue;
        }

        visited[nextNode] = count++;
        queue.add(nextNode);
      }
    }
  }
}
