package easy;

import java.util.Stack;

public class SymmetricTree {
    public static boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
    }

    private static boolean compare(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode==null && rightNode==null) {
            return true;
        }
        if (leftNode==null || rightNode==null || leftNode.val!=rightNode.val) {
            return false;
        }
        return compare(leftNode.left, rightNode.right) && compare(leftNode.right, rightNode.left);
    }

    public static boolean isSymmetric_iterative(TreeNode root) {
        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();
        leftStack.push(root.left);
        rightStack.push(root.right);
        while (!leftStack.isEmpty() && !rightStack.isEmpty()) {
            TreeNode left = leftStack.pop();
            TreeNode right = rightStack.pop();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null || left.val != right.val) {
                return false;
            }

            // left first
            leftStack.push(left.left);
            leftStack.push(left.right);
            // right first
            rightStack.push(right.right);
            rightStack.push(right.left);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3), new TreeNode(4)),
                new TreeNode(2,
                        new TreeNode(4), new TreeNode(3)));
        System.out.println(SymmetricTree.isSymmetric(root1));

        TreeNode root2 = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(3)),
                new TreeNode(2, null, new TreeNode(3)));
        System.out.println(SymmetricTree.isSymmetric(root2));
    }
}
