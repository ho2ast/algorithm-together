package graph_and_traversal;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.StringTokenizer;

/**
 * <p> 이차원 배열에 집의 배치도가 주어질 때 단지 수와 단지에 속하는 집의 수를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/2667"/>Baekjoon_2667 단지번호 붙이</a>
 */
public class Level7 {
  static boolean[][] map;
  static boolean[][] visitedMap;
  static int[] axisX = {0, 0, -1, 1};
  static int[] axisY = {-1, 1, 0, 0};
  static int homeCount, complexCount = 0;
  static int N;


  /**
   * <p> 이차원 배열로 집의 위치를 입력받는다.
   * <p> 반복문을 돌며 집이 있을 경우 해당 좌표를 전달하여 dfs를 통해 상하 좌우에 집이 있는지 탐색한다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    ArrayList<Integer> totalCount = new ArrayList<>();
    N = Integer.parseInt(br.readLine());
    map = new boolean[N][N];
    visitedMap = new boolean[N][N];

    for (int i = 0; i < N; i++) {
      String line = br.readLine();

      for (int j = 0; j < line.length(); j++) {
        map[i][j] = String.valueOf(line.charAt(j)).equals("1");
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (map[i][j] && !visitedMap[i][j]) {
          homeCount = 0;
          complexCount++;
          dfs(i, j);
          totalCount.add(homeCount);
        }
      }
    }

    totalCount.sort(Comparator.comparingInt(o -> o));
    bw.write(String.valueOf(complexCount));
    bw.newLine();
    for (int home : totalCount) {
      bw.write(String.valueOf(home));
      bw.newLine();
    }

    bw.flush();
    bw.close();
    br.close();
  }

  private static void dfs(int x, int y) {
    homeCount++;
    visitedMap[x][y] = true;

    for (int i = 0; i < 4; i++) {
      int dirX = axisX[i] + x;
      int dirY = axisY[i] + y;

      if (checkRange(dirX, dirY) && map[dirX][dirY] && !visitedMap[dirX][dirY]) {
        dfs(dirX, dirY);
      }
    }
  }

  private static boolean checkRange(int dirX, int dirY) {
    return dirX > -1 && dirY > -1 && dirX < N && dirY < N;
  }
}
