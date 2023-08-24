package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> 이진 트리가 주어질 떄 해당 트리의 중위순회 결과를 출력하세요.
 * <p> 문제 바로가기: <a href="https://leetcode.com/problems/binary-tree-inorder-traversal/" />94. Binary Tree Inorder Traversal</a>
 */
public class No94BinaryTreeInorderTraversal {

  static List<Integer> result = new ArrayList<>();

  static class TreeNode {
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

  public static List<Integer> inorderTraversal(TreeNode root) {
    inorder(root);
    return result;
  }

  public static void inorder(TreeNode root) {
    if (root != null) {
      inorder(root.left);
      result.add(root.val);
      inorder(root.right);
    }
  }
}
