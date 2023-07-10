package graph_and_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * <p> 시작 정점에 시작하여 정점을 방문할 때 정점의 방문 순서를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/24479"/>Baekjoon_24479 알고리즘 수업 - 깊이 우선 탐색 1</a>
 */
public class Level1 {
  static int[] visited;
  static int count = 1;
  static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  /**
   * <p> 의사 결정 코드에 나온 대로 구현 후 정점 방문 순서를 출력한다.
   * <p> 이차원 배열을 사용했을 경우 메모리 초과가 나옴.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int R = Integer.parseInt(st.nextToken());

    visited = new int[N + 1];

    for (int i = 0; i <= N; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 1; i <= M; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      // 양방향이므로 양쪽에 추가
      graph.get(u).add(v);
      graph.get(v).add(u);
    }
    br.close();

    graph.forEach(array -> array.sort((Comparator.comparingInt(o -> o))));

    dfs(R);

    for (int i = 1; i < visited.length; i++) {
      sb.append(visited[i]).append("\n");
    }
    System.out.println(sb);
  }

  private static void dfs(int start) {
    visited[start] = count;

    for (int i = 0; i < graph.get(start).size(); i++) {
      int adjacent = graph.get(start).get(i);
      if (visited[adjacent] == 0) {
        count++;
        dfs(adjacent);
      }
    }
  }
}
