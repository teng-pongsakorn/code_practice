package medium;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    private TreeNode build(int[] inorder, int start1, int end1, int[] postorder, int start2, int end2) {
        if (start1 > end1) return null;
        TreeNode node = new TreeNode(postorder[end2]);
        int nodeIdx = 0;
        while (inorder[start1 + nodeIdx] != node.val) {
            nodeIdx++;
        }
        node.right = build(inorder, start1 + nodeIdx + 1, end1, postorder, start2+nodeIdx, end2-1);
        node.left = build(inorder, start1, start1 + nodeIdx-1, postorder, start2, start2+nodeIdx-1);
        return node;
    }
}
