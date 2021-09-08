package medium;


public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public class TreeNode {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int s1, int e1, int[] inorder, int s2, int e2) {
        if (s1 > e1) return null;
        TreeNode node = new TreeNode(preorder[s1]);
        int i = 0;
        while (inorder[s2 + i] != node.val) {
            i++;
        }
        node.right = build(preorder, s1+1+i, e1, inorder, s2+i+1, e2);
        node.left = build(preorder, s1+1, s1+i, inorder, s2, s2+i-1);
        return node;
    }
}
