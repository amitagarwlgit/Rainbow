package algo.Tree.model;

public class TreeNode {

  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode(int x) {
    val = x;
  }

  public TreeNode(int val, TreeNode left, TreeNode right) {
    this.left = left;
    this.right = right;
    this.val = val;
  }
}
