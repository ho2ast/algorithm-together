package baekjoon.chanhyeng.weeks3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * <p> 조건이 주어질 때 먹을 수 있는 초밥의 최대 가짓수를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/15961"/>Baekjoon_15961 회전 초밥</a>
 */
public class Baekjoon15961 {
  /**
   * <p> 완전 탐색 방법으로 생각해보자.
   * <p> 주어진 접시수 n 사이즈의 배열을 만든다.
   * <p> 0부터 n까지 초밥 번호를 넣는다.
   * <p> 0번부터 시작하는 loop를 돈다. 이중 loop이용하여 시작 인덱스부터 연속해서 먹을 접시 k만큼의 초밥번호를 set에 저장한다.
   * <p> 가져올 인덱스는 i % n 으로 한다.
   * <p> set의 사이즈를 구해 최대값으로 저장한다.
   * <p> 시간복잡도는 n 300만 * k 3,000으로 1초의 제한을 벗어난다.
   * <p> 그럼 다른 방법으로 해결해보자
   * <p> 미리 k 만큼 리스트를 만들어 둔다. 리스트를 만들때 값이 있는지 확인하고 없는 경우에만 넣어준다.
   * <p> c가 포함되면 +1을 해준다.
   * <p> 그다음 시작인덱스를 0으로 둔 후 while을 돌며 첫번째 값을 제거해주고, 그다음값을 저장해준다. sushiArr[(s++ + k) % n]
   * <p> 마찬가지로 해당 값이 리스트에 없을 경우에만 추가해준다.
   * <p> 그 후 중복제거 후 최대값 비교를 해준 후 max값을 교체해준다.
   * <p> 이런 방식으로 s인덱스가 n보다 작을 때 까지 반복해준다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int d = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    int maxKind = Integer.MIN_VALUE;

    int[] sushiArr = new int[n];

    for (int i = 0; i < n; i++) {
      sushiArr[i] = Integer.parseInt(br.readLine());
    }

//    for (int i = 0; i < n; i++) {
//      Set<Integer> set = new HashSet<>();
//      set.add(c);
//      for (int j = i; j < i + k; j++) {
//        set.add(sushiArr[j % n]);
//      }
//      maxKind = Math.max(maxKind, set.size());
//    }

    List<Integer> set = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      int tempValue = sushiArr[i];
      if (set.contains(tempValue)) {
        set.remove((Object) tempValue);
      }
      set.add(tempValue);
    }
    maxKind = Math.max(maxKind, set.contains(c) ? set.size() : set.size() + 1);

    int s = 0;
    while (s < n) {
      int tempValue = sushiArr[(s++ + k) % n];
      if (!set.contains(tempValue)) {
        set.remove((Object) tempValue);
      }
      set.add(tempValue);

      maxKind = Math.max(maxKind, set.contains(c) ? set.size() : set.size() + 1);
    }

    bw.write(String.valueOf(maxKind));
    bw.flush();
    bw.close();
    br.close();
  }
}
