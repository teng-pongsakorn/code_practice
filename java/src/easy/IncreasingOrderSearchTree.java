package easy;

import java.util.Stack;

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
public class IncreasingOrderSearchTree {
    public TreeNode increasingBST_v2(TreeNode root) {
        TreeNode result = reconstruct(root, null);
        return result;
    }

    private TreeNode reconstruct(TreeNode root, TreeNode tail) {
        if (root == null) return tail;
        TreeNode result = reconstruct(root.left, root);
        root.left = null;
        root.right = reconstruct(root.right, tail);
        return result;
    }

    public TreeNode increasingBST(TreeNode root) {
        TreeNode result = new TreeNode(0);
        TreeNode head = result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null && !stack.isEmpty()) {
            while (current != null) {
                stack.add(current);
                current = current.left;
            }
            current = stack.pop();
            head.right = current;
            head = head.right;

            current = current.right;
        }
        return result.right;
    }


}
