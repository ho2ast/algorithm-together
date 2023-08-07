package baekjoon.graph_and_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * <p> 수빈과 동생의 위치가 주어졌을 때, 수빈이가 동생에게 갈 수 있는 가장 빠른 초를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/1697"/>Baekjoon_1697 숨바꼭</a>
 */
public class Level10 {
  static int[] visited = new int[100001];
  static int K;
  /**
   * <p>크기가 최대값 + 1인 배열을 만든 후 출발 인덱스에 1초를 추가해준다.(배열의 기본값이 0이므로 구분하기 쉽게)
   * <p>수빈이가 이동할 수 있는 경우의 수 3가지를 정한 후 이동할 위치가 일정 조건(위치 > -1, 위치 < 100000, 해당 위치 인덱스 값 = 0)을
   * <p>만족할 경우 해당 위치를 queue에 넣은 후 해당 위치를 인덱스로 방문 시간 배열에 이전 위치 값 +1 을 넣어준다.
   * <p>queue에 들어간 인덱스 순서대로 돌며 시간을 추가해준다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    br.close();

    int N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    System.out.println(bfs(N));
  }

  private static int bfs(int start) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(start);
    visited[start] = 1;

    while (!queue.isEmpty()) {
      int point = queue.poll();

      if (visited[K] != 0) {
        return visited[K] - 1;
      }

      if (point - 1 > -1 && visited[point - 1] == 0) {
        queue.offer(point - 1);
        visited[point - 1] = visited[point] + 1;
      }
      if (point + 1 < 100001 && visited[point + 1] == 0) {
        queue.offer(point + 1);
        visited[point + 1] = visited[point] + 1;
      }
      if (point * 2 < 100001 && visited[point * 2] == 0) {
        queue.offer(point * 2);
        visited[point * 2] = visited[point] + 1;
      }
    }
    return -1;
  }
}
