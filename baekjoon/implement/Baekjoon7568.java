package baekjoon.implement;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * <p> 나열된 사람의 덩치 등수를 구해서 그 순서대로 첫 줄에 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/7568"/>덩치</a>
 */
public class Baekjoon7568 {
  /**
   * (몸무게, 키)가 주어진다.
   * 키, 몸무게가 둘 다 커야 상대방 보다 덩치가 크다고 할 수 있다.
   * 둘 중 하나만 크다면 둘은 동급이라고 볼 수 있다.
   * 자신의 몸무게보다 큰 사람의 수를 확인 후 그 수에 +1 하면 자신의 등수를 알 수 있다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    List<Body> bodies = new ArrayList<>();

    int n = Integer.parseInt(br.readLine());
    int[] ranks = new int[n];

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int weight = Integer.parseInt(st.nextToken());
      int height = Integer.parseInt(st.nextToken());

      Body body = new Body(weight, height);
      bodies.add(body);
    }

    for (int i = 0; i < n; i++) {
      makeRank(bodies, ranks, i);
    }

    for(int rank : ranks) {
      bw.write(rank + " ");
    }
    bw.flush();
    bw.close();
    br.close();
  }

  public static void makeRank(List<Body> bodies, int[] ranks, int me) {
    int rank = 0;
    for (int i = 0; i < bodies.size(); i++) {
      if (i != me) {
        if (bodies.get(i).weight > bodies.get(me).weight
            && bodies.get(i).height > bodies.get(me).height) {
          rank++;
        }
      }
    }

    ranks[me] = rank + 1;
  }
}

class Body {
  int weight;
  int height;

  public Body(int weight, int height) {
    this.weight = weight;
    this.height = height;
  }
}
