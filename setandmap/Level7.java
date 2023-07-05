package setandmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * <p> 두 집합의 대칭 차집합 원소의 개수를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/1269"/>Baekjoon_1269 대칭 차집합</a>
 */
public class Level7 {
  /**
   * <p> 원소의 개수 최대 수인 100,000,000 + 1개의 배열을 생성한다.
   * <p> A집합의 원소를 index로 하여 값을 +1 해준다. (boolean 배열로 true로 변경해주어도 된다.)
   * <p> B집합의 원소를 index로 하여 검색했을 떄 1일 경우 count++;를 해준다.
   * <p> 이후 A집합의 사이즈와 B집합의 사이즈를 더한 후 교집합 원소의 개수인 count에 2를 곱한 값을 빼주면 된다.
   * <p> 양 집합에 공통으로 있는 값을 빼줘야 하므로 2를 곱해준 값을 빼주는 것이다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int[] arr = new int[100000001];
    int count = 0;

    st = new StringTokenizer(br.readLine());
    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < A; i++) {
      arr[Integer.parseInt(st.nextToken())]++;
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < B; i++) {
      if (arr[Integer.parseInt(st.nextToken())] == 1) count++;
    }

    // 두 집합 원소의 수 합에서 교집합 원소의 수 * 2를 빼준다.
    System.out.println(A + B - (count * 2));
  }
}
