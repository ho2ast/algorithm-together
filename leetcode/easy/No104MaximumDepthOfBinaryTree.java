package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p> 이진 트리의 최대 깊이를 구하세요.
 * <p> 문제 바로가기: <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/" />104. Maximum Depth of Binary Tree</a>
 */
public class No104MaximumDepthOfBinaryTree {

  public static void main(String[] args) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(new TreeNode(1).left);
    queue.offer(new TreeNode(1).right);
    System.out.println(queue);
  }


  /**
   * <p> 자식 노드가 더 이상 없을 때 까지 bfs 순회를 한다.
   * <p> 자식들을 Queue에 넣어주면서 depth를 더해준다.
   */
  public int maxDepth(TreeNode root) {
    int maxDepth = 0;
    if (root == null) {
      return maxDepth;
    }



    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root.left);
    queue.offer(root.right);

    while (!queue.isEmpty()) {
      maxDepth++;
      TreeNode node1 = queue.poll();
      TreeNode node2 = queue.poll();

      if (node1 != null) {
        queue.offer(node1.left);
        queue.offer(node1.right);
      }

      if (node2 != null) {
        queue.offer(node2.left);
        queue.offer(node2.right);
      }
    }

    return maxDepth;
  }

  public static class TreeNode {
    int val;
    No104MaximumDepthOfBinaryTree.TreeNode left;
    No104MaximumDepthOfBinaryTree.TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, No104MaximumDepthOfBinaryTree.TreeNode left, No104MaximumDepthOfBinaryTree.TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
