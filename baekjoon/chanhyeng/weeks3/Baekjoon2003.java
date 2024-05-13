package baekjoon.chanhyeng.weeks3;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon2003 {
  /**
   * <p>범위로 봐야한다.. 영역으로 봐야함
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[] arr = new int[n];


    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int s = 0, e = 0, result = 0, sum = 0;

    while (true) {
      if (sum > m) {
        sum -= arr[s++];
      } else if (e == n) {
        break;
      } else {
        sum += arr[e++];
      }

      if (sum == m) {
        result++;
      }
    }

    bw.write(String.valueOf(result));
    bw.flush();
    bw.close();
    br.close();
  }
}
