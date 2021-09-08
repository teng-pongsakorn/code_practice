package easy;

public class BalancedBinaryTree {

    public static boolean isBalanced(TreeNode root) {
        return solve(root) != -1;
    }

    private static int solve(TreeNode root) {
        if (root == null) return 0;
//        if (root.left == null && root.right == null) return depth;

        int leftChildDepth = solve(root.left);
        if (leftChildDepth == -1) {
            return -1;
        }
        int rightChildDepth = solve(root.right);
        if (rightChildDepth == -1) {
            return -1;
        }
        return Math.abs(leftChildDepth - rightChildDepth) > 1 ? -1 : Math.max(leftChildDepth, rightChildDepth) + 1;
    }

    static class DepthBalance {
        public int depth;
        public boolean isBalance;
        public DepthBalance(int depth, boolean isBalance) {
            this.depth = depth;
            this.isBalance = isBalance;
        }
    }
    public static boolean isBalanced_v1(TreeNode root) {
        if (root == null) return true;
        DepthBalance leftChild = getDepthBalance(root.left, 1);
        DepthBalance rightChild = getDepthBalance(root.right, 1);
        int depthDiff = Math.abs(leftChild.depth - rightChild.depth);
        return  (depthDiff <= 1) && leftChild.isBalance && rightChild.isBalance;
    }

    private static DepthBalance getDepthBalance(TreeNode node, int parentDepth) {
        if (node == null) return new DepthBalance(parentDepth, true);
        if (node.right == null && node.left == null) return new DepthBalance(parentDepth + 1, true);
        DepthBalance leftChild = getDepthBalance(node.left, 1 + parentDepth);
        DepthBalance rightChild = getDepthBalance(node.right, 1 + parentDepth);
        int depthDiff = Math.abs(leftChild.depth - rightChild.depth);
        boolean isBalance = (depthDiff <= 1) && leftChild.isBalance && rightChild.isBalance;
        return new DepthBalance(Math.max(leftChild.depth, rightChild.depth), isBalance);
    }

    public static void main(String[] args) {
        TreeNode balanceTrue = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(5), new TreeNode(2)));
        System.out.println(BalancedBinaryTree.isBalanced(balanceTrue));

        TreeNode balanceFalse = new TreeNode(3, new TreeNode(2, new TreeNode(2,
                                                                                new TreeNode(4),
                                                                                new TreeNode(8,
                                                                                                new TreeNode(4),
                                                                                                new TreeNode(9))),
                                                                        new TreeNode(20)),
                                                    new TreeNode(4));
        System.out.println(BalancedBinaryTree.isBalanced(balanceFalse));
        System.out.println(BalancedBinaryTree.isBalanced(null));     // expect true
    }
}
