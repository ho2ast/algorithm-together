package graph_and_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * <p> 주어진 토마토가 모두 익는데 걸리는 최소 일수를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/7576"/>Baekjoon_7576 토마토</a>
 */
public class Level12 {
  static int[][] tomatoMap;
  static boolean[][] visited;
  static int M;
  static int N;
  static int[] axisX = {0, 0, -1, 1};
  static int[] axisY = {1, -1, 0, 0};
  static Queue<int[]> queue = new LinkedList<>();
  static int maxDay;
  static int zeroCount = 0;
  /**
   * <p> 토마토를 이차원 배열인 tomatoMap에 추가해준다. 그와 동시에 방문 여부 확인용 이차원 배열 visited도 추가해준다.
   * <p> 초기 토마토가 1인 경우를 {@link java.util.Queue#add(Object)}에 추가해준다.
   * <p> 토마토가 0인 경우 zeroCount++ 해준다.
   * <p> 그 후 loop를 돌며 해당 토마토의 상화좌우의 토마토가 0인 경우
   * <p> tomatoMap 값을 기준 토마토 위치 값 + 1로 저장하고 queue에 추가 하고 방문 처리한다.
   * <p> 동시에 zeroCount-- 해준다.
   * <p> 모든 queue를 소비한 후 zeroCount가 0인 경우 maxDay, 아닌 경우 -1을 출력한다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    st = new StringTokenizer(br.readLine());

    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    tomatoMap = new int[N][M];
    visited = new boolean[N][M];

    for (int y = 0; y < N; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < M; x++) {
        int tomato = Integer.parseInt(st.nextToken());
        tomatoMap[y][x] = tomato;
        if (tomato == 1) {
          queue.add(new int[]{y, x});
        } else if (tomato == 0){
          zeroCount++;
        }

      }

    }

    if (zeroCount == 0) {
      System.out.println(0);
      return;
    }

    bfs(queue);

    if (zeroCount > 0) {
      System.out.println(-1);
    } else {
      System.out.println(maxDay - 1);
    }
  }

  private static void bfs(Queue<int[]> queue) {
    while (!queue.isEmpty()) {
      int[] tomato = queue.poll();
      int y = tomato[0];
      int x = tomato[1];

      visited[y][x] = true;

      for (int i = 0; i < 4; i++) {
        int dirX = x + axisX[i];
        int dirY = y + axisY[i];

        if (dirX > -1 && dirX < M && dirY > -1 && dirY < N && !visited[dirY][dirX] && tomatoMap[dirY][dirX] == 0) {
          queue.add(new int[]{dirY, dirX});
          visited[dirY][dirX] = true;
          tomatoMap[dirY][dirX] = tomatoMap[y][x] + 1;
          maxDay = tomatoMap[dirY][dirX];
          zeroCount--;
        }
      }
    }
  }
}
