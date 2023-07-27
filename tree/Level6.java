package tree;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * <p> 이진 검색트리의 전위 순회 결과가 주어질 때, 해당 트리의 후위 순회 결과를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/5639"/>Baekjoon_5639 이진 검색 트리</a>
 */
public class Level6 {
  static ArrayList<Integer> elementList = new ArrayList<>();
  /**
   * <p>전위 순회의 첫번째 값이 루트 노드의 값이 된다.
   * <p>이진 검색 트리는 좌측 서브 트리의 모든 노드 값이 루트 값보다 작고,
   * <p>우측 서브 트리의 모든 노드 값은 루트 값보다 크다.
   * <p>따라서 루트 값보다 커지는 부분을 찾아 좌측, 우측 서브 트리를 나누고
   * <p>해당 서브트리에서 위의 과정을 반복한다.
   * <p>그 후 만들어진 트리로 후위 순회하며 출력한다.
   * <p>Node class를 만들고 해당 노드 클래스를 필드로 하는 BinarySearchTree를 만들어준다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int index = 0;

    while (true) {
      String element = br.readLine();
      if (element == null || element.equals("")) {
        break;
      }
      elementList.add(Integer.parseInt(element));
    }

    getPostOrder(0, elementList.size() - 1);
  }

  static void getPostOrder(int start, int end) {
    if (start > end) {
      return;
    }

    int point = start + 1;
    while (point <= end && elementList.get(point) < elementList.get(start)) {
      point++;
    }

    getPostOrder(start + 1, point - 1);
    getPostOrder(point, end);

    System.out.println(elementList.get(start));
  }
}
