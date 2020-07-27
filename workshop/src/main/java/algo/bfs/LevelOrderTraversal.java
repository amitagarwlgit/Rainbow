package algo.bfs;

import algo.Tree.model.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

  public List<List<Integer>> levelOrder(TreeNode root) {

    List<List<Integer>> result = new ArrayList<>();
    Queue<TreeNode> nextLevel = new LinkedList<>();
    nextLevel.add(root);
    while (!nextLevel.isEmpty()) {
      List<Integer> currentLevelNodes = new ArrayList<>();
      for (TreeNode node : nextLevel) {
        if (node == null) continue;
        currentLevelNodes.add(node.val);
      }
      if (!currentLevelNodes.isEmpty()) result.add(currentLevelNodes);
      nextLevel = findNextLevel(nextLevel);
    }
    return result;
  }

  Queue<TreeNode> findNextLevel(Queue<TreeNode> queue) {
    Queue<TreeNode> nextLevel = new LinkedList<>();
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (node == null) continue;
      nextLevel.add(node.left);
      nextLevel.add(node.right);
    }
    return nextLevel;
  }
}
