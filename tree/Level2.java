package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * <p> 트리가 주어질 때 트리의 지름을 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/1167"/>Baekjoon_1167 트리의 지름</a>
 */
public class Level2 {
  static ArrayList<Node>[] tree;
  static boolean[] visitCheck;
  static int max = 0;
  static int farNode = 0;
  static int V;
  /**
   * <p>주어 진 정점과 간선, 정점까지의 거리를 {@link java.util.ArrayList<java.util.Map>} 형태로 저장한다.
   * <p>또한 정점의 방문 여부를 나타내는 배열을 생성하여 방문처리를 해준다.
   * <p>트리의 지름은 임의의 정점 x에서 가장 먼 정점 y를 찾는다.
   * <p>그 후 정점 y와 가장 먼 정점과의 경로가 트리의 지름이 된다..
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    V = Integer.parseInt(br.readLine());

    tree = new ArrayList[V + 1];
    visitCheck = new boolean[V + 1];

    for (int i = 0; i < V; i++) {
      st = new StringTokenizer(br.readLine());
      int node = Integer.parseInt(st.nextToken());
      int v = (st.countTokens() - 1) / 2;
      tree[node] = new ArrayList<>();

      while (v-- > 0) {
        int connectedVertex = Integer.parseInt(st.nextToken());
        int distance = Integer.parseInt(st.nextToken());

        tree[node].add(new Node(connectedVertex, distance));
      }
    }

    dfs(1, 0);
    visitCheck = new boolean[V + 1];
    dfs(farNode, 0);

    System.out.println(max);
  }

  static void dfs(int node, int sum) {
    visitCheck[node] = true;
    if (max < sum) {
      max = sum;
      farNode = node;
    }
    ArrayList<Node> nodeList = tree[node];

    for (int i = 0; i < nodeList.size(); i++) {
      Node nodes = nodeList.get(i);
      int nextNode = nodes.node;
      if (!visitCheck[nextNode]) {
        dfs(nextNode, sum + nodes.weight);
      }
    }
  }

  static class Node {
    int node;
    int weight;

    public Node(int node, int weight) {
      this.node = node;
      this.weight = weight;
    }
  }
}
