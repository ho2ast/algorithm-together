package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <p> 이진 트리가 주어질 때 중위순회, 전위순회, 후위순회 값을 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/1991"/>Baekjoon_1991 트리 순회</a>
 */
public class Level4 {
  static StringBuilder sb = new StringBuilder();
  static Node tree = new Node();

  /**
   * <p>트리의 노드로 정의한 {@link Node}로 트리를 생성 해준다.
   * <p>해당 트리의 순회 결과를 리턴해주도록 한다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());
    Node rootNode;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      String parent = st.nextToken();
      String leftChild = st.nextToken();
      String rightChild = st.nextToken();

      createTree(parent, leftChild, rightChild);
    }

    tree.preOrder(tree);
    sb.append("\n");
    tree.inOrder(tree);
    sb.append("\n");
    tree.postOrder(tree);

    System.out.println(sb);
  }

  static <T> void createTree(String parent, String left, String right) {
    if (tree.data == null) {
      tree = new Node();
      tree.data = parent;
      if (!left.equals(".")) {
        Node leftNode = new Node(left);
        tree.makeLeftChild(leftNode);
      }
      if (!right.equals(".")) {
        Node rightNode = new Node(right);
        tree.makeRightChild(rightNode);
      }
    } else {
      searchTree(tree, parent, left, right);
    }
  }

  static void searchTree(Node node, String parent, String left, String right) {
    if (node == null) {
      return;
    } else if (parent.equals(node.data)) {
      if (!left.equals(".")) {
        Node leftNode = new Node(left);
        node.makeLeftChild(leftNode);
      }
      if (!right.equals(".")) {
        Node rightNode = new Node(right);
        node.makeRightChild(rightNode);
      }
    } else {
      searchTree(node.leftChild, parent, left, right);
      searchTree(node.rightChild, parent, left, right);
    }
  }

  static class Node {
    Object data;
    Node leftChild;
    Node rightChild;

    public Node() {
    }

    public Node(Object data) {
      this.data = data;
    }

    public void makeLeftChild(Node leftChild) {
      this.leftChild = leftChild;
    }

    public void makeRightChild(Node rightChild) {
      this.rightChild = rightChild;
    }

    public void preOrder(Node node) {
      if (node != null) {
        sb.append(node.data);
        preOrder(node.leftChild);
        preOrder(node.rightChild);
      }
    }

    public void inOrder(Node node) {
      if (node != null) {
        inOrder(node.leftChild);
        sb.append(node.data);
        inOrder(node.rightChild);
      }
    }

    public void postOrder(Node node) {
      if (node != null) {
        postOrder(node.leftChild);
        postOrder(node.rightChild);
        sb.append(node.data);
      }
    }
  }
}
