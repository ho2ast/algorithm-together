package baekjoon.graph_and_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * <p> 이차원 배열의 미로가 주어질 경우 최종 목적지까지 최소 이동 칸 수를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/2178"/>Baekjoon_2178 미로 탐색</a>
 */
public class Level9 {
  static int[][] maze;
  static boolean[][] visited;
  static int count = 1;
  static int[] axisX = {0, 0, -1, 1};
  static int[] axisY = {-1, 1, 0, 0};
  static int row;
  static int column;

  /**
   * <p>미로를 2차원 배열에 저장한다. 동시에 방문 여부를 확인 할 수 있는 같은 크기의 2차원 배열을 생성한다.
   * <p>상, 하, 좌, 우를 확인 할 수 있는 배열을 생성해 준다.
   * <p>그 후 bfs를 이용하여 해당 칸에서 이동할 수 있는 좌표를 Queue에 넣어준다.
   * <p>이동시 방문여부를 true로 변경해주고 기존 미로 배열에 몇번째 방문인지 값을 저장한다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    row = Integer.parseInt(st.nextToken());
    column = Integer.parseInt(st.nextToken());

    maze = new int[row][column];
    visited = new boolean[row][column];

    for (int i = 0; i < row; i++) {
      String spot = br.readLine();
      for (int j = 0; j < column; j++) {
        maze[i][j] = spot.charAt(j) - 48;
      }
    }

    bfs(0, 0);

    br.close();
    System.out.println(maze[row - 1][column - 1]);
  }

  private static void bfs(int y, int x) {
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{y, x});

    while (!queue.isEmpty()) {
      int[] spot = queue.poll();
      visited[spot[0]][spot[1]] = true;

      for (int i = 0; i < 4; i++) {
        int nextX = axisX[i] + spot[1];
        int nextY = axisY[i] + spot[0];

        if (nextX > -1 && nextX < column && nextY > -1 && nextY < row && maze[nextY][nextX] == 1 && !visited[nextY][nextX]) {
          queue.offer(new int[]{nextY, nextX});
          maze[nextY][nextX] = maze[spot[0]][spot[1]] + 1;
        }
      }
    }
  }
}
