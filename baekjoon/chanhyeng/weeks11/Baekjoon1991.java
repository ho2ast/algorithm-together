package baekjoon.chanhyeng.weeks11;

import java.io.*;
import java.util.StringTokenizer;

/**
 * <p> 이진 트리가 주어질 때 전위, 중위, 후위 순회 결과를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/1991"/>Baekjoon_1991 트리순회</a>
 */
public class Baekjoon1991 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    Node node = new Node();
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      node = createTree(node, st.nextToken(), st.nextToken(), st.nextToken());
    }

    node.preOder(node);
    System.out.println();
    node.inOrder(node);
    System.out.println();
    node.postOrder(node);

    br.close();
  }

  static Node createTree(Node node, String parent, String left, String right) {
    if (node.value == null) {
      node.value = parent;
      if (!left.equals(".")) {
        node.setLeft(new Node(left));
      }
      if (!right.equals(".")) {
        node.setRight(new Node(right));
      }
      return node;
    } else {
      return searchTree(node, parent, left, right);
    }
  }

  private static Node searchTree(Node node, String parent, String left, String right) {
    if (node != null) {
      if (node.value.equals(parent)) {
        node.value = parent;
        if (!left.equals(".")) {
          node.setLeft(new Node(left));
        }
        if (!right.equals(".")) {
          node.setRight(new Node(right));
        }
        return node;
      } else {
        searchTree(node.left, parent, left, right);
        searchTree(node.right, parent, left, right);
        return node;
      }
    }
    return null;
  }


  static class Node {
    String value = null;
    Node left;
    Node right;

    public Node() {
    }

    public Node(String value) {
      this.value = value;
    }

    public void setLeft(Node left) {
      this.left = left;
    }

    public void setRight(Node right) {
      this.right = right;
    }

    public void preOder(Node node) {
      if (node != null) {
        System.out.print(node.value);
        preOder(node.left);
        preOder(node.right);
      }
    }

    public void inOrder(Node node) {
      if (node != null) {
        inOrder(node.left);
        System.out.print(node.value);
        inOrder(node.right);
      }
    }

    public void postOrder(Node node) {
      if (node != null) {
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value);
      }
    }
  }
}
