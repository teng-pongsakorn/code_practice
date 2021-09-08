package medium;

import java.util.*;

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
public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, targetSum, 0, result, new ArrayList<>());
        return result;
    }

    private void helper(TreeNode node, int targetSum, int currentSum, List<List<Integer>> result, List<Integer> list) {
        if (node == null) return;
        int size = list.size();
        list.add(node.val);
        currentSum += node.val;
        if (node.left == null && node.right == null) {
            if (currentSum == targetSum) {
                result.add(new ArrayList<>(list));
            }
        } else {
            helper(node.left, targetSum, currentSum, result, list);
            helper(node.right, targetSum, currentSum, result, list);
        }
        list.remove(size);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                                        new TreeNode(4,
                                                new TreeNode(11,
                                                        new TreeNode(7),
                                                        new TreeNode(2)),
                                                null),
                                        new TreeNode(8,
                                                new TreeNode(13),
                                                new TreeNode(4,
                                                        new TreeNode(5),
                                                        new TreeNode(1))));
        PathSum2 solution = new PathSum2();
//        System.out.println(solution.pathSum(root, 22));

        root = new TreeNode(-2, null, new TreeNode(-3));
        System.out.println(solution.pathSum(root, -5));
    }
}
