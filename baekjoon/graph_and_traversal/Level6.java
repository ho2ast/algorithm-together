package baekjoon.graph_and_traversal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * <p> DFS와 BFS로 그래프를 탐색한 순서를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/1260"/>Baekjoon_1260 DFS와 BFS</a>
 */
public class Level6 {

  static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  static ArrayList<Integer> visitDFS = new ArrayList<>();
  static ArrayList<Integer> visitBFS = new ArrayList<>();
  /**
   * <p> DFS와 BFS를 각각 구현한다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int V = Integer.parseInt(st.nextToken());

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

    // 오름차순으로 방문하기 때문에 정렬
    graph.forEach(array -> array.sort(((o1, o2) -> o1 - o2)));

    dfs(V);
    bfs(V);

    for (int num : visitDFS) {
      bw.write(String.valueOf(num));
      bw.append(" ");
    }
    bw.newLine();
    for (int num : visitBFS) {
      bw.write(String.valueOf(num));
      bw.append(" ");
    }

    bw.flush();
    bw.close();
    br.close();
  }

  private static void dfs(int start) {
    visitDFS.add(start);

    for (int i = 0; i < graph.get(start).size(); i++) {
      int nextNode = graph.get(start).get(i);

      if (!visitDFS.contains(nextNode)) {
        dfs(nextNode);
      }
    }
  }

  private static void bfs(int start) {
    Queue<Integer> queue = new LinkedList<>();
    visitBFS.add(start);
    queue.offer(start);

    while (!queue.isEmpty()) {
      int node = queue.poll();
      for (int i = 0; i < graph.get(node).size(); i++) {
        int nextNode = graph.get(node).get(i);
        if (!visitBFS.contains(nextNode)) {
          visitBFS.add(nextNode);
          queue.offer(nextNode);
        }
      }
    }
  }
}
