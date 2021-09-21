package easy;
/**
 * Definition for a binary tree node.
 * public
 */
public class SubtreeofAnotherTree {

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

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) return subRoot == root;
        if (root.val == subRoot.val && allEqaul(root, subRoot)) {
            return true;
        } else {
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
    }

    private boolean allEqaul(TreeNode t1, TreeNode t2) {
        if (t1==null || t2==null) {
            return t1 == t2;
        }
        if (t1.val != t2.val) return false;
        return allEqaul(t1.left, t2.left) && allEqaul(t1.right, t2.right);
    }

    public static void main(String[] args) {
//[3,4,5,1,2]
//[4,1,2]
//[3,4,5,1,2,null,null,null,null,0]
//[4,1,2]
//[1,1]
//[1]
//[3,4,5,1,null,2]
//[3,1,2]
        System.out.println(null == null);
    }
}
