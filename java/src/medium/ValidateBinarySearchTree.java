package medium;
/**
 * Definition for a binary tree node.
 * public
 */
public class ValidateBinarySearchTree {
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValidBST(root.left, root.val) && isValidBST(root.val, root.right);
    }

    public boolean isValidBST(int lowerBound, TreeNode root) {
        if (root == null) return true;
        return root.val > lowerBound && isValidBST(lowerBound, root.left, root.val) && isValidBST(root.val, root.right);
    }

    public boolean isValidBST(TreeNode root, int upperBound) {
        if (root == null) return true;
        return root.val < upperBound && isValidBST(root.left, root.val) && isValidBST(root.val, root.right, upperBound);
    }

    public boolean isValidBST(int lowerBound, TreeNode root, int upperBound) {
        if (root == null) return true;
        return lowerBound < root.val && root.val < upperBound && isValidBST(lowerBound, root.left, root.val) && isValidBST(root.val, root.right, upperBound);
    }
}
