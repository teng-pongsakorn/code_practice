package easy;

import java.util.HashSet;
import java.util.Set;
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
public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        Stack<TreeNode[]> stack = new Stack<>();
        stack.add(new TreeNode[]{root1, root2});
        while (!stack.isEmpty()) {
            TreeNode[] currentPair = stack.pop();
            if (currentPair[0] == null || currentPair[1] == null) {
                continue;
            }
            currentPair[0].val += currentPair[1].val;
            // process left branch
            if (currentPair[0].left == null) {
                currentPair[0].left = currentPair[1].left;
            } else {
                stack.push(new TreeNode[]{currentPair[0].left, currentPair[1].left});
            }
            // process right branch
            if (currentPair[0].right == null) {
                currentPair[0].right = currentPair[1].right;
            } else {
                stack.push(new TreeNode[]{currentPair[0].right, currentPair[1].right});
            }
        }
        return root1;
    }
    public TreeNode mergeTrees_recursive2(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        root1.val += root2.val;
        root1.left = mergeTrees_recursive2(root1.left, root2.left);
        root1.right = mergeTrees_recursive2(root1.right, root2.right);
        return root1;
    }
    public TreeNode mergeTrees_myIterative(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root1);
        stack2.push(root2);
        Set<TreeNode> visited = new HashSet<>();
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            TreeNode top1 = stack1.peek();
            TreeNode top2 = stack2.peek();
            // 1) traverse
            if (top1.left != null & !visited.contains(top1.left)) {
                if (top2.left == null) {
                    visited.add(top1.left);
                } else {
                    stack1.add(top1.left);
                    stack2.add(top2.left);
                }
            } else if (top1.right != null & !visited.contains(top1.right)) {
                if (top2.right == null) {
                    visited.add(top1.right);
                } else {
                    stack1.add(top1.right);
                    stack2.add(top2.right);
                }
            } else if (top1.left == null && top2.left != null) {
                top1.left = top2.left;
                visited.add(top1.left);
            } else if (top1.right == null && top2.right != null) {
                top1.right = top2.right;
                visited.add(top1.right);
            } else {
                TreeNode node1 = stack1.pop();
                TreeNode node2 = stack2.pop();
                node1.val += node2.val;;
                visited.add(node1);
            }
        }
        return root1;
    }
    public TreeNode mergeTrees_recursive(TreeNode root1, TreeNode root2) {
        TreeNode newRoot;
        if (root1 == null && root2 == null) {
            return null;
        } else if (root1 == null) {
            newRoot = root2;
        } else if (root2 == null) {
            newRoot = root1;
        } else {
            newRoot = new TreeNode(root1.val + root2.val);
            newRoot.left  = mergeTrees(root1.left, root2.left);
            newRoot.right = mergeTrees(root1.right, root2.right);
        }

        return newRoot;
    }
    public TreeNode mergeTrees_v1(TreeNode root1, TreeNode root2) {
        TreeNode newRoot;
        if (root1 == null && root2 == null) {
            return null;
        } else if (root1 == null) {
            newRoot = new TreeNode(root2.val);
            newRoot.left  = mergeTrees(null, root2.left);
            newRoot.right = mergeTrees(null, root2.right);
        } else if (root2 == null) {
            newRoot = new TreeNode(root1.val);
            newRoot.left  = mergeTrees(root1.left, null);
            newRoot.right = mergeTrees(root1.right, null);
        } else {
            newRoot = new TreeNode(root1.val + root2.val);
            newRoot.left  = mergeTrees(root1.left, root2.left);
            newRoot.right = mergeTrees(root1.right, root2.right);
        }

        return newRoot;
    }
}
