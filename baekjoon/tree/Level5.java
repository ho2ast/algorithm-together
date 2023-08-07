package baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <p> 트리의 중위순회(in-order)와 후위순회(post-oreder)가 주어질 때 전위순회(pre-order)를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/2263"/>Baekjoon_2263 트리의 순회</a>
 */
public class Level5 {
  static int[] inOrder;
  static int[] postOrder;
  static int[] inOrderValuePosition;
  static StringBuilder sb = new StringBuilder();
  /**
   * <p>후위순회와 중위순회를 통해 규칙을 찾을 수 있다.
   * <p>후위순회의 가장 마지막은 root값이 된다.
   * <p>그리고 중위순회의 그 루트값이 있는 인덱스를 기준으로 좌측은 좌측 서브트리, 우측은 우측 서브트리가 된다.
   * <p>그리고 중위순회의 루트값이 있는 인덱스를 후위순회의 인덱스로 잡아서 나누면 그 좌측은 좌측 서브트리, 우측은 우측 서브트리가 된다.
   * <p>그렇게 나눈 서브트리의 마지막 값은 그 서브트리의 루트값이 된다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int n = Integer.parseInt(br.readLine());

    inOrder = new int[n];
    postOrder = new int[n];
    inOrderValuePosition = new int[n + 1];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      inOrder[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      postOrder[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < n; i++) {
      inOrderValuePosition[inOrder[i]] = i;
    }

    makePreOrder(0, n - 1, 0, n - 1);

    System.out.println(sb);
  }

  static void makePreOrder(int inOrderStart, int inOrderEnd, int postOrderStart, int postOrderEnd) {
    if (inOrderStart > inOrderEnd || postOrderStart > postOrderEnd) {
      return;
    }
    int root = postOrder[postOrderEnd];

    int rootIndex = inOrderValuePosition[root];
    int leftLength = rootIndex - inOrderStart;

    sb.append(root).append(" ");

    makePreOrder(inOrderStart, rootIndex - 1, postOrderStart, postOrderStart + leftLength - 1);
    makePreOrder(rootIndex + 1, inOrderEnd, postOrderStart + leftLength, postOrderEnd - 1);
  }
}
