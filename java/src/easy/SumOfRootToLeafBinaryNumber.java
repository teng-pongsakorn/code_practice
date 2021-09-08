package easy;

import java.util.Stack;

public class SumOfRootToLeafBinaryNumber {

    public static int sumRootToLeaf(TreeNode root) {
        int totalSum = 0;
        int currentSum = 0;
        int steps = 0;
        TreeNode predecessor;
        while (root != null) {
            if (root.left != null) {
                predecessor = root.left;
                steps = 1;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                    steps++;
                }
                if (predecessor.right == null) {
                    // make bridge
                    currentSum = currentSum * 2 + root.val;
                    predecessor.right = root;
                    root = root.left;
                } else {
                    // destroy bridge
                    if (predecessor.left == null) {
                        totalSum += currentSum;
                    }
                    for (int i=0; i < steps; i++) {
                        currentSum /= 2;
                    }
                    predecessor.right = null;
                    root =root.right;
                }
            } else {
                currentSum = 2 * currentSum + root.val;
                // leaf node
                if (root.right == null) {
                    totalSum += currentSum;
                }
                root = root.right;
            }
        }
        return totalSum;
    }

    public static int sumRootToLeaf_v2_iterative(TreeNode root) {
        class Pair {
            private TreeNode key;
            private int val;

            public Pair(TreeNode node, int val) {
                this.key = node;
                this.val = val;
            }

            public TreeNode getKey() {
                return key;
            }

            public int getVal() {
                return val;
            }
        }
        Stack<Pair> stack = new Stack<>();
        int total = 0;
        stack.push(new Pair(root, 0));
        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            TreeNode node = pair.getKey();
            int sum = pair.getVal();
            if (node != null) {
                sum = (2 * sum) + node.val;
                // leaf node
                if (node.left == null && node.right == null) {
                    total += sum;
                } else {
                    stack.push(new Pair(node.left, sum));
                    stack.push(new Pair(node.right, sum));
                }
            }
        }
        return total;
    }

    public static int sumRootToLeaf_v1_recursive(TreeNode root) {
        return sumRootToLeaf(0, root);
    }

    public static int sumRootToLeaf(int sum, TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return sum * 2 + node.val;
        }
        int nextSum = 2 * sum + node.val;
        return sumRootToLeaf(nextSum, node.left) + sumRootToLeaf(nextSum, node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(0, new TreeNode(0), new TreeNode(1)),
                new TreeNode(1, new TreeNode(0), new TreeNode(1)));
        System.out.println(SumOfRootToLeafBinaryNumber.sumRootToLeaf(root));
    }
}
