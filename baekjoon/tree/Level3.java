package baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * <p> 트리가 주어질 때 트리의 지름을 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/1967"/>Baekjoon_1967 트리의 지름</a>
 */
public class Level3 {
  static ArrayList<Node>[] tree;
  static boolean[] visitCheck;
  static int maxDiameter = 0;
  static int farNode = 0;
  /**
   * <p>트리의 두 노드과 가중치가 주어지므로 {@link datastructure.list.arraylist.ArrayList[]} 에 해당 노드를 인덱스로 하여,
   * <p>노드와 가중치를 넣어 {@link Node} 객체를 추가한다.
   * <p>그 후 dfs를 임의의 노드(1)에서 가장 먼 노드를 구한다. 즉, 해당 노드까지의 가중치의 합이 가장 큰 노드이다.
   * <p>가장 먼 노드를 구한 후 해당 노드에서 가중치가 가장 큰 노드를 구하면 트리의 지름을 구할 수 있다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int n = Integer.parseInt(br.readLine());

    if (n == 1) {
      System.out.println(0);
      return;
    }

    tree = new ArrayList[n + 1];
    for (int i = 1; i < n + 1; i++) {
      tree[i] = new ArrayList<>();
    }

    for (int i = 1; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      int node1 = Integer.parseInt(st.nextToken());
      int node2 = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());

      tree[node1].add(new Node(node2, weight));
      tree[node2].add(new Node(node1, weight));
    }

    visitCheck = new boolean[n + 1];
    dfs(1, 0);

    visitCheck = new boolean[n + 1];
    dfs(farNode, 0);

    System.out.println(maxDiameter);
  }

  private static void dfs(int n, int sum) {
    visitCheck[n] = true;
    ArrayList<Node> nodeList = tree[n];

    if (maxDiameter < sum) {
      maxDiameter = sum;
      farNode = n;
    }

    for (int i = 0; i < nodeList.size(); i++) {
      Node node = nodeList.get(i);
      if (!visitCheck[node.node]) {
        dfs(node.node, sum + node.weight);
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
