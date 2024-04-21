package baekjoon.chanhyeng;

import java.io.*;
import java.util.StringTokenizer;

/**
 * <p> 고장난 다이오드 시계의 시간이 주어질때 가능한 가장 빠른 시간을 출력하세.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/2082"/>Baekjoon_2082 시계</a>
 */
public class Bakejoon2082 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    char[][] digits = {
        "####.##.##.####".toCharArray(),
        "..#..#..#..#..#".toCharArray(),
        "###..#####..###".toCharArray(),
        "###..####..####".toCharArray(),
        "#.##.####..#..#".toCharArray(),
        "####..###..####".toCharArray(),
        "####..####.####".toCharArray(),
        "###..#..#..#..#".toCharArray(),
        "####.#####.####".toCharArray(),
        "####.####..####".toCharArray()};

    String[] input = new String[4];

    for (int i = 0; i < 5; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String temp1 = st.nextToken();
      String temp2 = st.nextToken();
      String temp3 = st.nextToken();
      String temp4 = st.nextToken();

      input[0] += temp1;
      input[1] += temp2;
      input[2] += temp3;
      input[3] += temp4;
    }
  }
}
