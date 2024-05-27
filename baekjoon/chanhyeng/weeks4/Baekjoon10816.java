package baekjoon.chanhyeng.weeks4;

import java.io.*;
import java.util.*;

/**
 * <p> 상근이가 가지고 있는 카드중 주어진 카드가 몇개 인지 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/10816"/>Baekjoon_10816 숫자 카드 2</a>
 */
public class Baekjoon10816 {
  /**
   * <p> 우선 완전 탐색으로 접근해보자.
   * <p> 상근이가 가진 숫자카드를 배열로 받아서 저장한다.
   * <p> 그리고 주어진 숫자를 상근이가 가진 카드의 배열을 돌면서 해당 카드가 몇개인지 카운트한 후 저장한다.
   * <p> 이렇게 할 경우 시간복잡도는 N*M 이므로 최악의 경우 50만 * 50만으로 1초의 시간제한을 초과하게 된다.
   * <p> 일단 시도... 시간초과.
   * <p> 다음 방법은 상근이 카드를 리스트에 저장한다.
   * <p> 그 후 주어진 카드를 contains로 찾아서 있으면 map에 해당 숫자를 키로 카운트를 밸류로 저장하고, 상근이 카드 리스트에서 하나를 제거한다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    Map<Integer, Integer> resultMap = new HashMap<>();
    StringTokenizer st;

    int n = Integer.parseInt(br.readLine());
    int[] nArr = new int[n];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      nArr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(nArr);

    int m = Integer.parseInt(br.readLine());
    int[] mArr = new int[m];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      int s = 0;
      int e = n - 1;
      int mid = (s + 2) / 2;
    }

    bw.flush();
    bw.close();
    br.close();
  }
}