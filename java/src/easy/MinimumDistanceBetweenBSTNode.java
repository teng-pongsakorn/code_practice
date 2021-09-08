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
public class MinimumDistanceBetweenBSTNode {
    Integer prev = null;
    int minDist = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        if (root.left != null) minDiffInBST(root.left);
        if (prev != null) {
            minDist = Math.min(minDist, root.val - prev);
        }
        System.out.print(prev + " ");
        prev = root.val;
        if (root.right != null) {
            minDiffInBST(root.right);
        }
        return minDist;
    }
    public int minDiffInBST_v1(TreeNode root) {
        int minDist = Integer.MAX_VALUE;
        Integer prev = null;
        TreeNode guide;
        while (root != null) {
            guide = root.left;
            if (guide == null) {
                if (prev != null) {
                    minDist = root.val - prev < minDist ? root.val - prev : minDist;
                }
                prev = root.val;
                System.out.println(root.val);
                root = root.right;
            } else {
                while (guide.right != null && guide.right != root) {
                    guide = guide.right;
                }
                if (guide.right == null) {
                    guide.right = root;
                    root = root.left;
                } else {
                    guide.right = null;
                    if (prev != null) {
                        minDist = root.val - prev < minDist ? root.val - prev : minDist;
                    }
                    prev = root.val;
                    root = root.right;
                }
            }
        }

        return minDist;
    }
}
