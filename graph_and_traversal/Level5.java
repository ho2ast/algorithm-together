package graph_and_traversal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * <p> 컴퓨터가 연결된 네트워크가 주어질 때 바이러스에 감염된 컴퓨터의 수를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/2606"/>Baekjoon_2606 바이러스</a>
 */
public class Level5 {

  static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  static boolean[] visited;
  /**
   * <p> 네트워크에 연결된 컴퓨터는 그래프로 볼 수 있다.
   * <p> 연결된 컴퓨터를 그래프로 만든 후 DFS나 BFS를 이용하여 연결된 컴퓨터의 수를 구한다.
   * <p> 그 후 1번 컴퓨터를 제외한 후 방문했던 컴퓨터의 수를 출력한다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int result = 0;

    int computerCount = Integer.parseInt(br.readLine());
    int connectedCount = Integer.parseInt(br.readLine());

    for (int i = 0; i <= computerCount; i++) {
      graph.add(new ArrayList<>());
    }

    visited = new boolean[computerCount + 1];

    for (int i = 0; i < connectedCount; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      graph.get(u).add(v);
      graph.get(v).add(u);
    }

    dfs(1);

    for (int i = 2; i < visited.length; i++) {
      if (visited[i]) {
        result++;
      }
    }

    bw.write(String.valueOf(result));
    bw.flush();
    bw.close();
    br.close();
  }

  private static void dfs(int start) {
    visited[start] = true;

    for (int i = 0; i < graph.get(start).size(); i++) {
      int childNode = graph.get(start).get(i);
      if (!visited[childNode]) {
        dfs(childNode);
      }
    }
  }
}
