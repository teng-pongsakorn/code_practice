package easy;

import java.util.HashSet;
import java.util.Set;
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
public class TwoSumBST {
    public static boolean findTarget(TreeNode root, int k) {
        Set<Integer> visited = new HashSet<>();
        return find(root, k, visited);
    }

    private static boolean find(TreeNode root, int k, Set<Integer> visited) {
        if (root == null) {
            return false;
        }
        if (visited.contains(k - root.val)) {
            return true;
        }
        visited.add(root.val);
        return find(root.left, k, visited) || find(root.right, k, visited);
    }

    public static boolean findTarget_v1(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            if (search(root, node, k-node.val)) {
                return true;
            }
        }
        return false;
    }

    private static boolean search(TreeNode root, TreeNode node, int target) {
        while (root != null) {
            if (root.val < target) {
                root = root.right;
            } else if (root.val > target) {
                root = root.left;
            } else if (root.equals(node)) {
                root = root.left;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        Input: root = [5,3,6,2,4,null,7], k = 9
//        Output: true
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        System.out.println(TwoSumBST.findTarget(root, 9) == true);

//        Input: root = [5,3,6,2,4,null,7], k = 28
//        Output: false
        System.out.println(TwoSumBST.findTarget(root, 28) == false);

//        Input: root = [2,1,3], k = 4
//        Output: true
        root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println(TwoSumBST.findTarget(root, 4) == true);
        System.out.println(TwoSumBST.findTarget(root, 1) == false);
        System.out.println(TwoSumBST.findTarget(root, 3) == true);
    }
}
