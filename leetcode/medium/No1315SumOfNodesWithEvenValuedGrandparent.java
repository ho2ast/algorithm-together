package leetcode.medium;

/**
 * <p> 이진트리가 주어질 때 노드의 값이 짝수일 경우 손자노드들의 합을 구하여라.
 * <p> 문제 바로가기:  <a href="https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/description/"/>1315. Sum of Nodes with Even-Valued Grandparent</a>
 */
public class No1315SumOfNodesWithEvenValuedGrandparent {

  static int result = 0;

  public static int sumEvenGrandparent(TreeNode root) {

    findGrandChildren(root);
    return result;
  }

  public static void findGrandChildren(TreeNode root) {
    if (root == null) {
      return;
    }

    if (root.val % 2 == 0) {

      if (root.left.left != null) {
        result += root.left.left.val;
      }

      if (root.left.right != null) {
        result += root.left.right.val;
      }

      if (root.right.left != null) {
        result += root.right.left.val;
      }

      if (root.right.right != null) {
        result += root.right.right.val;
      }
    }

    findGrandChildren(root.left);
    findGrandChildren(root.right);
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
