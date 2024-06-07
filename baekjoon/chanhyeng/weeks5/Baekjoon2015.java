package baekjoon.chanhyeng.weeks5;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * <p> 배열이 주어질 때 누적합의 값이 K가 되는 경우의 수를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/2015"/>Baekjoon_2015 수들의 합 4</a>
 */
public class Baekjoon2015 {
  /**
   * <p> 누적합을 구한 배열 dp를 만든다.
   * <p> 그 후 dp값을 첫번째 부터 비교하면서 dp가 아니 원본 배열의 값까지 확인한 후 k와 일치하는 값을 넣어준다.
   * <p> 이중 for문 실패...
   * <p> dp[i] ~ dp[j] 까지의 부분합을 구하려면 dp[j] - dp [i - 1]을 해야한다.
   * <p> dp[j] - dp [i - 1] = k 가 되는 구간의 수를 구해야 한다.
   * <p> 이 식은 dp[i - 1] = dp[j] - k 로 변경할 수 있다. 즉, 인덱스까지의 누적합 값과 일치해야 하는 K를 뺀값이 이전 누적합 갑에 존재하면 된다.
   * <p> 따라서 누적합 배열을 loop 돌면서 Map에 dp[j] - k 값을 키로, count를 value로 저장해준다.
   * <p> 부분합의 모든 경우의 수가 정답으로 될 수 있는 경우는 n(n + 1) / 2 이므로 40억건 이상이다 따라서 정답은 long로 잡아준다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    long result = 0;

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[] dp = new int[n + 1];
    Map<Integer, Long> dpMap = new HashMap<>();
    dpMap.put(0, 1L);

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; i++) {
      dp[i] = dp[i - 1] + Integer.parseInt(st.nextToken());
      result += dpMap.getOrDefault(dp[i] - k, 0L);
      dpMap.put(dp[i], dpMap.getOrDefault(dp[i], 0L) + 1L);

    }

    bw.write(String.valueOf(result));
    bw.flush();
    bw.close();
    br.close();
  }
}
