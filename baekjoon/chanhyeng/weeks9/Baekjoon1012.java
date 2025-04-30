package baekjoon.chanhyeng.weeks9;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * <p> 배추밭에 배추흰지렁이가 몇 마리 필요한지 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/1012"/>Baekjoon_1012 유기농 배추</a>
 */
public class Baekjoon1012 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    int n = Integer.parseInt(br.readLine());

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int r = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      int j = Integer.parseInt(st.nextToken());


    }

//    bw.write(String.valueOf());
    bw.flush();
    bw.close();
    br.close();
  }

  static int bfs(int r, int c, int j, BufferedReader br) {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    Queue<Pos> q = new ArrayDeque<>();
    boolean[][] visited = new boolean[r][c];

    return 0;
  }

  static class Pos {
    int r, c;
    int cnt;

    public Pos(int r, int c, int cnt) {
      this.r = r;
      this.c = c;
      this.cnt = cnt;
    }
  }
}
