package easy;

import java.util.LinkedList;
import java.util.Queue;

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
public class CousinsinBinaryTree {
    public boolean isCousins_v2(TreeNode root, int x, int y) {
        Integer[] xResult = findLevelWithParent(null, root, x, 0);
        Integer[] yResult = findLevelWithParent(null, root, y, 0);
        return xResult[0] != yResult[0] && xResult[1] == yResult[1];
    }

    private Integer[] findLevelWithParent(TreeNode parent, TreeNode node, int target, int depth) {
        if (node == null) return null;
        if (node.val == target) return new Integer[] {parent==null ? null: parent.val , depth};
        Integer[] leftResult = findLevelWithParent(parent, parent.left, target, depth+1);
        Integer[] rightResult = findLevelWithParent(parent, parent.right, target, depth+1);
        return  leftResult == null ? rightResult : leftResult;
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int numNodetoCheck = queue.size();
            boolean foundX = false;
            boolean foundY = false;
            TreeNode parentX = null;
            TreeNode parentY = null;
            System.out.print("Nodes In Level:");
            while (numNodetoCheck > 0) {
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");
                if (node.left != null) {
                    queue.add(node.left);
                    if (node.left.val == x) {
                        foundX = true;
                        parentX = node;
                    } else if (node.left.val == y) {
                        foundY = true;
                        parentY = node;
                    }
                }
                if (node.right != null) {
                    queue.add(node.right);
                    if (node.right.val == x) {
                        foundX = true;
                        parentX = node;
                    } else if (node.right.val == y) {
                        foundY = true;
                        parentY = node;
                    }
                }
                numNodetoCheck--;
            }
            System.out.println("");
            if (foundX & foundY) {
                return parentX.val != parentY.val;
            } else if (foundX || foundY) {
                return false;
            }
        }
        System.out.println("=".repeat(40));
        return false;
    }
}
