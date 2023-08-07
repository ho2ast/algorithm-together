package baekjoon.graph_and_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * <p> 배추밭의 배추를 심은 위치가 주어질 때 필요한 흰 지렁이의 수를 구하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/1012"/>Baekjoon_1012 유기농 배추</a>
 */
public class Level8 {
  /**
   * <p>배추밭의 크기와 배추가 심긴 곳의 위치로 2차원 배열을 생성한다.
   * <p>반복문을 통해 배추가 있을 경우 해당 배추는 확인하고 흰 지렁이의 수를 카운트한다.
   * <p>그 후 배추의 위치를 기준으로 상하좌우에 배추가 있는지 확인 후 있으면 배추 위치를 등록한다.
   */
  static boolean[][] cabbageMap;
  static boolean[][] visitedMap;
  static int row;
  static int column;
  static int earthwormCount;
  static int[] axisX = {0, 0, -1, 1};
  static int[] axisY = {-1, 1, 0, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    ArrayList<Integer> earthwormArr = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      column = Integer.parseInt(st.nextToken());
      row = Integer.parseInt(st.nextToken());
      int cabbageCount = Integer.parseInt(st.nextToken());
      cabbageMap = new boolean[row][column];
      visitedMap = new boolean[row][column];
      earthwormCount = 0;

      for (int j = 0; j < cabbageCount; j++) {
        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        cabbageMap[x][y] = true;
      }

      for (int y = 0; y < row; y++) {
        for (int x = 0; x < column; x++) {
          if (cabbageMap[y][x] && !visitedMap[y][x]) {
            dfs(y, x);
            earthwormCount++;
          }
        }
      }
      earthwormArr.add(earthwormCount);
    }

    br.close();

    for (int count : earthwormArr) {
      System.out.println(count);
    }
  }

  private static void dfs(int y, int x) {
    visitedMap[y][x] = true;

    for (int i = 0; i < 4; i++) {
      int dirX = axisX[i] + x;
      int dirY = axisY[i] + y;

      if (dirX > -1 && dirY > -1 && dirX < column && dirY < row && cabbageMap[dirY][dirX] && !visitedMap[dirY][dirX]) {
        dfs(dirY, dirX);
      }
    }
  }
}
