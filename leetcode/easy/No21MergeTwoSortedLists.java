package leetcode.easy;

/**
 * <p> 두 개의 sorted linked list가 주어질 때 두 리스트를 병합하세요.
 * <p> 문제 바로가기: <a href="https://leetcode.com/problems/merge-two-sorted-lists/" />21. Merge Two Sorted Lists</a>
 */
public class No21MergeTwoSortedLists {

  public static void main(String[] args) {
    ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
    ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

//    ListNode listNode = new ListNode(1);
//    ListNode listNod = listNode;
//    System.out.println("listNod = " + listNod);
    System.out.println(mergeTwoLists(list1, list2));
  }


  public static class ListNode {
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

  /**
   * <p>싱글리 링크드 리스트가 두 개다.
   * <p>기본적인 개념은 하나의 loop를 돌며 두 리스트의 값을 비교하여 같거나 작은 값부터 새로운 리스트에 추가하는것이다.
   * <p>우선, 새로운 병합된 값을 담을 dummy node 를 생성한다.
   * <p>그 후, 현재 노드의 위치를 알려주는 curr 변수를 생성한다.
   * <p>두 리스트 모두 null을 가르키지 않을 떄 까지 while 문을 돌며 각 리스트의 값을 비교해준다.
   * <p>list1의 값이 큰 경우 curr.next 에 list2를 대입해주고 list2는 list2.next로 대입한다.
   * <p>그 후 현재 노드를 다음 노드로 옮겨준다. 반대의 경우 반대로 작업을 해준다.
   * <p>현재의 노드가 null을 가르킬 경우 while을 빠져 나오고 남은 list를 curr.next로 넣어준다.
   * <p>dummy.next노드를 반환해준다.
   */
  public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;

    while (list1 != null && list2 != null) {
      if (list1.val <= list2.val) {
        curr.next = list1;
        list1 = list1.next;
      } else {
        curr.next = list2;
        list2 = list2.next;
      }

      curr = curr.next;
    }
    curr.next = list1 != null ? list1 : list2;
    return dummy.next;

//    if (list1 != null && list2 != null) {
//      if (list1.val < list2.val) {
//        list1.next = mergeTwoLists(list1.next, list2);
//        return list1;
//      } else {
//        list2.next = mergeTwoLists(list1, list2.next);
//        return list2;
//      }
//    }
//    if (list1 == null)
//      return list2;
//    return list1;
  }
}
