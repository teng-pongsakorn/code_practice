package easy;

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
public class BinaryTreeTilt {
    public int findTilt(TreeNode root) {
        int[] tiltResult = tilt(root);
        return tiltResult[0];
    }

    private int[] tilt(TreeNode node) {
        if (node == null) return new int[]{0,0};
        int[] leftResult = tilt(node.left);
        int[] rightResult = tilt(node.right);
        int nodeTilt = Math.abs(leftResult[1] - rightResult[1]);
        return new int[] {nodeTilt+leftResult[0]+rightResult[0], node.val+rightResult[1]+leftResult[1]};
    }
}
