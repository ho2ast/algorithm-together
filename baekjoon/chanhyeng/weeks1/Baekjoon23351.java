package baekjoon.chanhyeng.weeks1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * <p> 첫 캣닢이 죽는 날짜를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/23351"/>Baekjoon_23351 물 주기</a>
 */
public class Baekjoon23351 {
  /**
   * <p> 모든 화분은 처음 수분은 동일하므로 연속된 화분만큼 0번째 화분부터 순서대로 물을 주면된다.
   * <p> while문을 돌며 0으로 할당 된 result에 1을 더해준다.
   * <p> 그 다음 물을 줄 첫번째 화분의 인덱스는 방금 물을 준 화분의 index % N (줘야할 화분의 수)이다.
   * <p> 그 후 반복문을 통해 모든 값에서 1씩 빼준 후 0인 값이 있는 지 확인하고 0일 경우 리턴.
   * <p> 0이 아니면 index에 연속된 화분의 수를 더해 준다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int result = 0;
    int index = 0;

    boolean flag = true;

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());

    int[] vase = new int[N];

    Arrays.fill(vase, K);

    while (flag) {
      result++;
      int startIndex = index % N;

      for (int i = startIndex; i < startIndex + A; i++) {
        vase[i] += B;
      }

      for (int i = 0; i < N; i++) {
        vase[i] -= 1;
        if (vase[i] == 0) {
          flag = false;
        }
      }
      index += A;
    }

    bw.write(String.valueOf(result));
    bw.flush();
    bw.close();
    br.close();
  }
}
