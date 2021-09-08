package easy;

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
public class MinimumAbsoluteDiffInBST {
    public int getMinimumDifference(TreeNode root) {
        Integer prev = null;
        int min = Integer.MAX_VALUE;
        TreeNode current = root;
        TreeNode guide;
        while (current != null) {
            guide = current.left;
            if (guide == null) {
                System.out.print(current.val + " ");
                if (prev == null) {
                    prev = current.val;
                } else {
                    int diff = Math.abs(current.val - prev);
                    min = Math.min(min, diff);
                    prev = current.val;
                }
                current = current.right;
            } else {
                while (guide.right != null && guide.right != current) {
                    guide = guide.right;
                }
                if (guide.right == null) {
                    guide.right = current;
                    current = current.left;
                } else {
                    System.out.print(current.val + " ");
                    if (prev == null) {
                        prev = current.val;
                    } else {
                        int diff = Math.abs(current.val - prev);
                        min = Math.min(min, diff);
                        prev = current.val;
                    }
                    current = current.right;
                    guide.right = null;
                }
            }
        }
        System.out.println(" ");
        return min;
    }
}
