package baekjoon.chanhyeng.weeks1;

import java.io.*;
import java.util.StringTokenizer;

/**
 * <p> 두 명이 둔 바둑판 상태가 주어질 때 구사과가 승리 할 수 있는지 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/16955"/>Baekjoon_16955 오목, 이길 수 있을까?</a>
 */
public class Baekjoon16955 {
  /**
   * <p> 상하좌우 대각선 방향으로 배열을 생성한다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    int[] xAxis = {1, 1, -1, 1};
    int[] yAxis = {1, 1, -1, 1};

    String[][] omok = new String[10][10];

    for (int i = 0; i < 9; i++) {
      String s = br.readLine();
      st = new StringTokenizer(s);
      for (int j = 0; j < 9; j++) {
        omok[i][j] = st.nextToken();
      }
    }

    System.out.println("a");
  }
}
