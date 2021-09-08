package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PathSum {

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        return find(root, 0, targetSum);
    }

    private static boolean find(TreeNode root, int sum, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return (sum + root.val) == targetSum;
        return find(root.left, sum+root.val, targetSum) || find(root.right, sum+root.val, targetSum);
    }

    public static void main(String[] args) {
//        List<Integer> values = new ArrayList<>();
//        values.add(1);
//        values.add(2);
//        values.add(3);
//        values.add(-1);
//        values.add(-1);
//        values.add(4);
//        values.add(5);
//        TreeNode root = Util.createTreeNode(values);
//        System.out.println(root.val + ":" + root.right.val + ":" + root.left.val);
//        TreeNode left = root.left;
//        TreeNode right = root.right;
//        System.out.println(left.val + ":" + left.left + ":" + left.right);
//        System.out.println(right.val + ":" + right.right.val + ":" + right.left.val);

//        root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22, result = true
        List<Integer> values = new ArrayList<>(Arrays.asList(5,4,8,11,-1,13,4,7,2,-1,-1,-1,1));
        TreeNode root1 = Util.createTreeNode(values);
        System.out.println(PathSum.hasPathSum(root1, 22));

        // root = [1,2,3], targetSum = 5, output = false
        values = new ArrayList<>(Arrays.asList(1, 2, 3));
        TreeNode root2 = Util.createTreeNode(values);
        System.out.println(PathSum.hasPathSum(root2, 5));

        // root = [1,2], targetSum = 0, output = false
        values = new ArrayList<>(Arrays.asList(1,2));
        root2 = Util.createTreeNode(values);
        System.out.println(PathSum.hasPathSum(root2, 0));
    }
}
