package baekjoon.chanhyeng;

import java.io.*;
import java.util.StringTokenizer;

/**
 * <p> 고장난 다이오드 시계의 시간이 주어질때 가능한 가장 빠른 시간을 출력하세.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/2082"/>Baekjoon_2082 시계</a>
 */
public class Baekjoon2082 {
  /**
   * <p> 실제 숫자로 주어진 char를 배열에 저장해둔디.
   * <p> 내 시계의 숫자를 받는데 띄어쓰기로 되어 있으므로 StringTokenizer로 분리하면 3자리씩 첫번째~네번째 숫자의 문자를 얻을 수 있다.
   * <p> 그 후 내 숫자의 값과 실제 숫자의 값을 비교한다. 내 숫자에 불이 켜져 있고 실제 숫자는 꺼져 있는 경우는 절대로 이루어 질 수 없다.
   * <p> 그게 아니라 패스되면 가장 작은 숫자일 것이므로 해당 숫자가 가능한 수 중 가장 작은 숫자가 될 것이다.
   */
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

    String[] input = new String[] {"", "", "", ""};

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

    br.close();

    char[][] myClock = new char[4][15];
    for (int i = 0; i < 4; i++) {
      myClock[i] = input[i].toCharArray();
    }

    int k;
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 10; j++) {
        for (k = 0; k < 15; k++) {
          if (myClock[i][k] == '#' && digits[j][k] == '.') {
            break;
          }
        }

        if (k == 15) {
          bw.write(String.valueOf(j));
          break;
        }
      }
      if (i == 1) {
        bw.write(':');
      }
    }

    bw.flush();
    bw.close();
  }
}
