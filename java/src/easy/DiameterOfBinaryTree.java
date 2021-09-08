package easy;

import java.util.HashMap;
import java.util.Map;
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
public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, Integer> nodeDepth = new HashMap<>();
        stack.push(root);
        int longestPath = 0;
        while (!stack.isEmpty()) {
            TreeNode top = stack.peek();
            if (top.left != null && !nodeDepth.containsKey(top.left)) {
                stack.push(top.left);
            } else if (top.right != null && !nodeDepth.containsKey(top.right)) {
                stack.push(top.right);
            } else {
                TreeNode node = stack.pop();
                int leftDepth = nodeDepth.getOrDefault(node.left, 0);
                int rightDepth = nodeDepth.getOrDefault(node.right, 0);
                longestPath = leftDepth+rightDepth > longestPath ? leftDepth+rightDepth : longestPath;
                nodeDepth.put(node, Math.max(rightDepth, leftDepth)+1);
            }
        }
        return longestPath;
    }
    public int diameterOfBinaryTree_recursive(TreeNode root) {
        int[] longest = new int[1];
        helper(root, longest);
        return longest[0];
    }

    private int helper(TreeNode node, int[] longest) {
        if (node == null) return 0;
        int rightLength = helper(node.right, longest);
        int leftLength = helper(node.left, longest);
        int combineLength = rightLength + leftLength;
        if (combineLength > longest[0]) {
            longest[0] = combineLength;
        }
        return rightLength > leftLength ? rightLength+1 : leftLength+1;
    }

    public static void main(String[] args) {
        DiameterOfBinaryTree solution = new DiameterOfBinaryTree();
        TreeNode root = new TreeNode(1,
                                    new TreeNode(2,
                                            new TreeNode(4),
                                            new TreeNode(5)),
                                    new TreeNode(3));
        System.out.println(solution.diameterOfBinaryTree(root));  // expect 3
    }
}
