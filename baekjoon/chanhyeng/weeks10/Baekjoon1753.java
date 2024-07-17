package baekjoon.chanhyeng.weeks10;

import java.io.*;
import java.util.*;

/**
 * <p> 방향 그래프에서 시작 정점에서 다른 모든 정점까지의 최단거리를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/1753"/>Baekjoon_1753 최단경로</a>
 */
public class Baekjoon1753 {
  static List<List<Node>> graph = new ArrayList<>();
  static int[] dist;

  static class Node implements Comparable<Node> {
    int v;
    int w;

    public Node(int v, int w) {
      this.v = v;
      this.w = w;
    }

    @Override
    public int compareTo(Node n) {
      return this.w - n.w;
    }
  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(br.readLine());

    dist = new int[V + 1];
    Arrays.fill(dist, Integer.MAX_VALUE);

    for (int i = 1; i <= V; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());

      graph.get(u).add(new Node(v, w));
    }

    for (int i = 1; i <= V; i++) {
      Collections.sort(graph.get(i));
    }

    bw.write(String.valueOf());
    bw.flush();
    bw.close();
    br.close();
  }

  static int[] dijkstra(int K) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    boolean[] visited = new boolean[K + 1];

    pq.offer(new Node(K, 0));
    while (!pq.isEmpty()) {
      Node poll = pq.poll();


    }
  }

}
