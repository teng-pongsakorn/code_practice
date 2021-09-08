package easy;

import java.util.ArrayList;
import java.util.List;
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
public class BinaryTreePaths {
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(root, sb, result);
        return result;
    }

    private static void helper(TreeNode node, StringBuilder builder, List<String> result) {
        if (node == null) {
            return;
        }
        int len = builder.length();
        builder.append(node.val);
        // found path
        if (node.left == null && node.right == null) {
            result.add(builder.toString());
        }
        // keep searching
        else {
            builder.append("->");
            helper(node.left, builder, result);
            helper(node.right, builder, result);
        }
        // clear search in this call
        builder.setLength(len);
    }

    public static List<String> binaryTreePaths_v2(TreeNode root) {
        List<String> result = new ArrayList<>();
        Stack<TreeNode> stackNode = new Stack<>();
        Stack<String> stackStr = new Stack<>();
        stackNode.push(root);
        stackStr.push(root.val+"");
        while (!stackNode.isEmpty()) {
            TreeNode node = stackNode.pop();
            String path = stackStr.pop();
            if (node.left == null && node.right == null) {
                result.add(path);
            }
            if (node.left != null) {
                stackNode.push(node.left);
                stackStr.push(path + "->" + node.left.val);
            }
            if (node.right != null) {
                stackNode.push(node.right);
                stackStr.push(path + "->" + node.right.val);
            }
        }
        return result;
    }

    public static List<String> binaryTreePaths_recursive(TreeNode root) {
        List<String> result = new ArrayList<>();
        search(root, "", result);
        return result;
    }

    private static void search(TreeNode node, String path, List<String> result) {
        String newPath = path.length()==0 ? node.val+"" : path + "->" + node.val;
        StringBuilder builder = new StringBuilder();
        if (node.left==null && node.right==null) {
            result.add(newPath);
            return;
        }
        if (node.left != null) {
            search(node.left, newPath, result);
        }
        if (node.right != null) {
            search(node.right, newPath, result);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(5));
        System.out.println(BinaryTreePaths.binaryTreePaths(root));

        System.out.println(BinaryTreePaths.binaryTreePaths(new TreeNode(1)));
    }
}
