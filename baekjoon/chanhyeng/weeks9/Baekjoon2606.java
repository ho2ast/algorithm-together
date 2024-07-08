package baekjoon.chanhyeng.weeks9;

import java.io.*;
import java.util.*;

/**
 * <p> 1번 컴퓨터를 통해 몇 대의 컴퓨터가 바이러스에 걸리는지 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/2606"/>Baekjoon_2606 바이러스</a>
 */
public class Baekjoon2606 {

  static List<List<Integer>> graph = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int c = Integer.parseInt(br.readLine());
    int n = Integer.parseInt(br.readLine());

    for (int i = 0; i <= c; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      graph.get(a).add(b);
      graph.get(b).add(a);
    }

    bw.write(String.valueOf(bfs(c)));
    bw.flush();
    bw.close();
    br.close();
  }

  static int bfs(int c) {
    int result = 0;

    Queue<List<Integer>> queue = new ArrayDeque<>();
    boolean[] visited = new boolean[c + 1];
    visited[1] = true;
    queue.add(graph.get(1));

    while (!queue.isEmpty()) {
      List<Integer> poll = queue.poll();

      for (int i = 0; i < poll.size(); i++) {
        if (!visited[poll.get(i)]) {
          visited[poll.get(i)] = true;
          queue.add(graph.get(poll.get(i)));
          result++;
        }
      }
    }

    return result;
  }
}
