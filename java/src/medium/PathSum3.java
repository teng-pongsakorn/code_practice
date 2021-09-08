package medium;

import java.util.*;

public class PathSum3 {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        return countPath(root, 0, targetSum, preSum, 0);
    }

    private int countPath(TreeNode root, int currSum, int targetSum, Map<Integer, Integer> preSum, int level) {
        if (root == null) return 0;
        currSum += root.val;
        // currSum - preSum = targetSum ::::> preSum = currSum - targetSum
        int count = preSum.getOrDefault(currSum - targetSum, 0);
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);

        System.out.println("    ".repeat(level) + "node:" + root.val + " : currSum="+ currSum + " : preSum=" + preSum);

        count += countPath(root.left, currSum, targetSum, preSum, level+1);
        count += countPath(root.right, currSum, targetSum, preSum, level+1);
        preSum.put(currSum, preSum.get(currSum)-1);
        return count;
    }


    public int pathSum_v3(TreeNode root, int targetSum) {
        if (root == null) return 0;
        return pathSumFrom(root, targetSum) + pathSum_v3(root.left, targetSum) + pathSum_v3(root.right, targetSum);
    }
    private int pathSumFrom(TreeNode node, int targetSum) {
        if (node == null) return 0;
        return ((node.val == targetSum) ? 1 : 0) + pathSumFrom(node.left, targetSum-node.val) + pathSumFrom(node.right, targetSum-node.val);
    }

    public int pathSum_v2(TreeNode root, int targetSum) {
        return search(root, targetSum, Arrays.asList());
    }

    private int search(TreeNode node, int targetSum, List<Integer> sumList) {
        if (node == null) return 0;
        int count = targetSum == node.val ? 1 : 0;
        List<Integer> nextSumList = new ArrayList<>();
        nextSumList.add(node.val);
        for (int sum: sumList) {
            count += (node.val + sum == targetSum) ? 1 : 0;
            nextSumList.add(node.val + sum);
        }
        count += search(node.left, targetSum, nextSumList);
        count += search(node.right, targetSum, nextSumList);
        return count;
    }

    public int pathSum_v1(TreeNode root, int targetSum) {
        return helper(root, targetSum, new ArrayList<Integer>());
    }

    private int helper(TreeNode node, int targetSum, List<Integer> currentSum) {
        if (node == null) {
            return 0;
        }
        int count = 0;
        if (node.val == targetSum) count++;
        if (node.left != null) {
            List<Integer> newCurrentSum = new ArrayList<>();
            if (node.val + node.left.val == targetSum) count++;
            newCurrentSum.add(node.val + node.left.val);
            for (int sum: currentSum) {
                if (node.left.val+sum == targetSum) count++;
                newCurrentSum.add(node.left.val + sum);
            }
            count += helper(node.left, targetSum, newCurrentSum);
        }
        if (node.right != null) {
            List<Integer> newCurrentSum = new ArrayList<>();
            if (node.val + node.right.val == targetSum) count++;
            newCurrentSum.add(node.val + node.right.val);
            for (int sum: currentSum) {
                if (node.right.val+sum == targetSum) count++;
                newCurrentSum.add(node.right.val + sum);
            }
            count += helper(node.right, targetSum, newCurrentSum);
        }
        return count;
    }

    public static void main(String[] args) {
        PathSum3 solution = new PathSum3();
        TreeNode root = new TreeNode(10,
                                        new TreeNode(5,
                                                new TreeNode(3,
                                                        new TreeNode(3),
                                                        new TreeNode(2)),
                                                new TreeNode(2,
                                                        null,
                                                        new TreeNode(1))),
                                        new TreeNode(-3,
                                                null ,
                                                new TreeNode(11))
        );
        System.out.println(solution.pathSum(root, 8));

        root = new TreeNode(1,
                            null,
                                new TreeNode(2,
                                        null ,
                                        new TreeNode(3,
                                                null,
                                                new TreeNode(4,
                                                        null,
                                                        new TreeNode(5)))));
        System.out.println(solution.pathSum(root, 3));

        //
        System.out.println(solution.pathSum(new TreeNode(1), 0));
    }

}
