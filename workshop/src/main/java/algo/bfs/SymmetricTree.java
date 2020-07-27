package algo.bfs;

import algo.Tree.model.TreeNode;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * <p>For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 * <p>1 / \ 2 2 / \ / \ 3 4 4 3
 *
 * <p>But the following [1,2,2,null,3,null,3] is not:
 *
 * <p>1 / \ 2 2 \ \ 3 3
 */
public class SymmetricTree {

  boolean isSymmetric(TreeNode node) {
    if (Objects.isNull(node)) return true;
    return isMirror(node.left, node.right);
  }

  boolean isMirror(TreeNode left, TreeNode right) {
    if (left == null || right == null) {
      return left == null && right == null;
    }
    return left.val == right.val
        && isMirror(left.left, right.right)
        && isMirror(left.right, right.left);
  }

  boolean isSymmetricIterative(TreeNode node) {
    if (Objects.isNull(node)) return true;
    return isMirrorIterative(node.left, node.right);
  }

  private boolean isMirrorIterative(TreeNode left, TreeNode right) {

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(left);
    queue.add(right);

    while (!queue.isEmpty()) {
      TreeNode first = queue.poll();
      TreeNode second = queue.poll();
      if (first == null && second == null) continue;
      if (first == null || second == null) return false;
      if (first.val != second.val) return false;

      queue.add(first.left);
      queue.add(second.right);
      queue.add(first.right);
      queue.add(second.left);
    }

    return true;
  }
}
