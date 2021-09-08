package easy;

public class MaximumDepthOfBinaryTree {
    public static int maxDepth(TreeNode root) {
        return maxDepth(root, 1);
    }

    public static int maxDepth(TreeNode node, int depth) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return depth;
        return Math.max(maxDepth(node.left, depth+1), maxDepth(node.right, depth+1));
    }

    public static void main(String[] args) {
        TreeNode depth2 = new TreeNode(0, new TreeNode(1), new TreeNode(2, null, new TreeNode(2)));
        System.out.println(MaximumDepthOfBinaryTree.maxDepth(depth2));
    }
}
