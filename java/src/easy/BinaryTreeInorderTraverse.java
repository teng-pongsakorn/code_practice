package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

public class BinaryTreeInorderTraverse {

    public static List<Integer> inorderTraversal_v2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }
        return result;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        addItem(result, root);
        return result;
    }

    private static void addItem(List<Integer> result, TreeNode node) {
        if (node.left != null) {
            addItem(result, node.left);
        }
        result.add(node.val);
        if (node.right != null) {
            addItem(result, node.right);
        }
    }

    public static void main(String[] args) {

    }
}
