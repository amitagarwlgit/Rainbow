package algo.Tree;

// Given a binary tree, return the inorder traversal of its nodes' values.
//
//        Example:
//
//        Input: [1,null,2,3]
//        1
//         \
//          2
//         /
//        3
//
//        Output: [1,3,2]

import algo.Tree.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> inorder = new ArrayList<>();
    if (root == null) {
      return inorder;
    }

    if (root.left != null) {
      inorder.addAll(inorderTraversal(root.left));
    }

    inorder.add(root.val);

    if (root.right != null) {
      inorder.addAll(inorderTraversal(root.right));
    }
    return inorder;
  }
}
