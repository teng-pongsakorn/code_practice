package medium;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class ConstructBinarySearchTreefromPreorderTraversal {
    int i = 0;
    public TreeNode bstFromPreorder_v2(int[] preorder) {
        return build_v2(preorder, Integer.MAX_VALUE);
    }

    private TreeNode build_v2(int[] preorder, int bound) {
        if (i == preorder.length || preorder[i] > bound) return null;
        TreeNode root = new TreeNode(preorder[i++]);
        root.left = build_v2(preorder, root.val);
        root.right = build_v2(preorder, bound);
        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, 0, preorder.length-1);
    }

    private TreeNode build(int[] preorder, int start, int end) {
        if (start > end) return null;
        int firstNextLower = end + 1;
        for (int i=start+1; i<=end; i++) {
            if (preorder[i] < preorder[start]) {
                firstNextLower = i;
                break;
            }
        }
        int firstNextGreater = end + 1;
        for (int i=start+1; i<=end; i++) {
            if (preorder[i] > preorder[start]) {
                firstNextGreater = i;
                break;
            }
        }
        TreeNode result = new TreeNode(preorder[start]);
        result.left = build(preorder, firstNextLower, firstNextGreater-1);
        result.right = build(preorder, firstNextGreater, end);
        return result;
    }
}
