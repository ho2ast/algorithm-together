package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p> 이진 트리의 root가 주어질 떄 해당 트리가 대칭 트리인지 판별하세요.
 * <p> 문제 바로가기: <a href="https://leetcode.com/problems/symmetric-tree/" />101. Symmetric Tree</a>
 */
public class No101SymmetricTree {

  public static boolean isSymmetric(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();

    if (root == null) {
      return false;
    }

    queue.offer(root.left);
    queue.offer(root.right);

    while (!queue.isEmpty()) {
      TreeNode node1 = queue.poll();
      TreeNode node2 = queue.poll();

      if (node1 == null && node2 == null){
        continue;
      }
      if (node1 == null && node2 != null) {
        return false;
      }
      if (node1 != null && node2 == null) {
        return false;
      }

      if (node1.val != node2.val) {
        return false;
      }

      queue.offer(node1.left);
      queue.offer(node2.right);
      queue.offer(node1.right);
      queue.offer(node2.left);
    }

    return true;
  }
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
