package easy;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        };
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i < size; i++) {
                TreeNode node = q.poll();
                // leaf node
                if (node.left==null && node.right==null) {
                    return depth;
                };
                if (node.left == null) {
                    q.offer(node.right);
                }
                if (node.right == null) {
                    q.offer(node.left);
                }
            }
            // to next level
            depth++;
        }
        return depth;
    }

    public static int minDepth_dfs(TreeNode root) {
        if (root == null) return 0;
        return minDepth(root, 1);
    }

    public static int minDepth(TreeNode node, int depth) {
//        System.out.println(" ".repeat(depth) + depth + " ----");
        if (node == null) return Integer.MAX_VALUE;
        if (node.left == null && node.right == null) return depth;
        return Math.min(minDepth(node.left, depth+1), minDepth(node.right, depth+1));
    }

    public static void main(String[] args) {
        TreeNode depth2 = new TreeNode(0, new TreeNode(1), new TreeNode(2, null, new TreeNode(2)));
        System.out.println(MinimumDepthOfBinaryTree.minDepth(depth2));
    }
}
