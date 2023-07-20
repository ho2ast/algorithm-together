package graph_and_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * <p> 체스의 나이트가 현재 칸에서 가고자 하는 칸까지 최소한의 횟수를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/7562"/>Baekjoon_7562 나이트의 이동</a>
 */
public class Level11 {
  static int boardSize;
  static int[][] chessBoard;
  static boolean[][] visited;
  static int[] destination;

  static int[] axisX = {-1, +1, -1, +1, -2, -2, +2, +2};
  static int[] axisY = {-2, -2, +2, +2, +1, -1, +1, -1};

  /**
   * <p>나이트가 현재위치에서 이동할 수 있는 곳을 접점으로 보고 순회 하는 BFS를 구현 하여 해결한다.
   * <p>주어진 체스판의 크기 만큼의 2차원 boolean 배열을 생성한다. 목적지 좌표에 true를 입력한다.
   * <p>현재 좌표에서 이동할 수 있는 좌표를 구한 후 올바른 좌표일 때 이동하고 이동한 곳을 현재위치로 하여
   * <p>새로운 위치로 이동하는 식으로 하여 이동한 곳이 목적지 칸일 때 까지 순회한다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;
    int testCase = Integer.parseInt(br.readLine());

    for (int i = 0; i < testCase; i++) {
      boardSize = Integer.parseInt(br.readLine());
      chessBoard = new int[boardSize][boardSize];
      visited = new boolean[boardSize][boardSize];
      st = new StringTokenizer(br.readLine());
      int[] currentSpot = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
      st = new StringTokenizer(br.readLine());
      destination = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

      sb.append(bfs(currentSpot[0], currentSpot[1])).append("\n");
    }
    br.close();

    System.out.println(sb);
  }

  private static int bfs(int y, int x) {
    int count = 0;
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{y, x});
    visited[y][x] = true;
    chessBoard[y][x] = count;

    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int currentX = current[1];
      int currentY = current[0];

      if (currentY == destination[0] && currentX == destination[1]) {
        return chessBoard[currentY][currentX];
      }

      for (int i = 0; i < 8; i++) {
        int dirX = currentX + axisX[i];
        int dirY = currentY + axisY[i];

        if (dirX > -1 && dirX < boardSize && dirY > -1 && dirY < boardSize && !visited[dirY][dirX]) {
          visited[dirY][dirX] = true;
          chessBoard[dirY][dirX] = chessBoard[currentY][currentX] + 1;
          queue.add(new int[]{dirY, dirX});
        }
      }
    }

    return -1;
  }
}
