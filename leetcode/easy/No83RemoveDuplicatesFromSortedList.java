package leetcode.easy;

/**
 * <p> 정렬된 LinkedList가 주어질 때 중복 된 원소를 모두 제거하세요.
 * <p> 문제 바로가기: <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list/" />83. Remove Duplicates from Sorted List</a>
 */
public class No83RemoveDuplicatesFromSortedList {

  /**
   * <p>정렬된 LinkedList이므로 다음 노드의 값이 같은 경우 연결을 끊어준 후 그 다음 노드로 next를 연결해준 후 다음 노드로 넘어간다.
   * <p>1. next노드가 있을 경우 현재 node의 value와 next node의 value를 비교한다.
   * <p>2. 값이 같을 경우 현재 node의 next값을 next의 next로 연결 해준다.
   * <p>2. 값이 다를 경우 다음 node로 넘어간다.
   */
  public static ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode currentNode = head;

    while (currentNode.next != null) {
      if (currentNode.val == currentNode.next.val) {
        if (currentNode.next.next == null) {
          currentNode.next = null;
          break;
        } else {
          currentNode.next = currentNode.next.next;
        }
      } else {
        currentNode = currentNode.next;
      }

    }
    return head;
  }
}


class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}
