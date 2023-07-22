package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * <p> 루트 없는 트리가 주어질 때, 각 노드의 부모를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/11725"/>Baekjoon_11725 트리의 부모 찾기</a>
 */
public class Level1 {
  static boolean[] visited;
  static int[] parentArray;
  static ArrayList<ArrayList<Integer>> numbers = new ArrayList<>();
  /**
   * <p>주어진 노드대로 트리를 만든다.
   * <p>DFS를 이용하여 부모 노드를 찾아 배열에 저정한다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());
    visited = new boolean[N + 1];
    parentArray = new int[N + 1];

    for (int i = 0; i < N + 1; i++) {
      numbers.add(new ArrayList<>());
    }

    for (int i = 0; i < N - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int node1 = Integer.parseInt(st.nextToken());
      int node2 = Integer.parseInt(st.nextToken());

      numbers.get(node1).add(node2);
      numbers.get(node2).add(node1);
    }

    Queue<Integer> queue = new LinkedList<>();
    queue.offer(1);

    while (!queue.isEmpty()) {
      int parent = queue.poll();
      ArrayList<Integer> child = numbers.get(parent);
      for (int i = 0; i < child.size(); i++) {
        int children = child.get(i);
        if (!visited[children]) {
          visited[children] = true;
          parentArray[children] = parent;
          queue.add(children);
        }
      }
    }

    for (int i = 2; i < parentArray.length; i++) {
      System.out.println(parentArray[i]);
    }
  }
}
