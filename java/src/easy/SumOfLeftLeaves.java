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
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> nonLeftStack = new Stack<>();
        nonLeftStack.push(root);
        int sum = 0;
        TreeNode node;
        while (!leftStack.isEmpty() || !nonLeftStack.isEmpty()) {
            if (leftStack.size() > 0) {
                node = leftStack.pop();
                if (node.left==null && node.right==null) {
                    sum += node.val;
                }
                if (node.right != null) {
                    nonLeftStack.push(node.right);
                }
                if (node.left != null) {
                    leftStack.push(node.left);
                }
            }
            if (nonLeftStack.size() > 0) {
                node = nonLeftStack.pop();
                if (node.right != null) {
                    nonLeftStack.push(node.right);
                }
                if (node.left != null) {
                    leftStack.push(node.left);
                }
            }
        }
        return sum;
    }

    public int sumOfLeftLeaves_recursive(TreeNode root) {
        if (root == null) return 0;
        int sum = sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        if (root.left != null && root.left.left==null && root.left.right==null) {
            sum += root.left.val;
        }
        return sum;
    }
}
