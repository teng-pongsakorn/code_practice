package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraverse {
    public List<Integer> postorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                root = root.left;
            } else {
                result.add(root.val);
                root = stack.pop();
            }
        }
        return result;
    }
    public List<Integer> postorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }

    private void traverse(TreeNode node, List<Integer> result) {
        if (node == null) return;
        traverse(node.left, result);
        traverse(node.right, result);
        result.add(node.val);
    }
}
