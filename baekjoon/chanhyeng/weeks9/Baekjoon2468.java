package baekjoon.chanhyeng.weeks9;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon2468 {

  static int[] dr = {-1, 1, 0, 0};
  static int[] dc = {0, 0, -1, 1};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    int n = Integer.parseInt(br.readLine());
    int[][] map = new int[n][n];
    int minHeight = Integer.MAX_VALUE;
    int maxHeight = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {

      }
    }

//    bw.write(String.valueOf());
    for (int i = 0; i < n; i++) {}
    bw.flush();
    bw.close();
    br.close();
  }

  static class Pos {
    int r;
    int c;

    public Pos(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }
}
