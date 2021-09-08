package easy;

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
public class FineModeInBinarySearchTree {

    List<Integer> modes = new ArrayList<>();
//    int modeCount = 0;
    int currMode = 0;
    int currFreq = 0;
    Integer currNum = null;

    public int[] findMode(TreeNode root) {
        // morris traverse inorder
        TreeNode tourist = root;
        TreeNode guide;
        while (tourist != null) {
            guide = tourist.left;
            if (guide == null) {
                updateModeResult(tourist.val);
                tourist = tourist.right;
            } else {
                while (guide.right != null && guide.right != tourist) {
                    guide = guide.right;
                }
                if (guide.right == null) {
                    guide.right = tourist;
                    tourist = tourist.left;
                } else {
                    guide.right = null;
                    updateModeResult(tourist.val);
                    tourist = tourist.right;
                }
            }
        }
        updateModeResult(currNum+1);

        // to array
        int[] result = new int[modes.size()];
        for (int i=0; i<result.length; i++) {
            result[i] = modes.get(i);
        }
        return result;
    }

    private void updateModeResult(int newNum) {
        if (currNum == null || currNum != newNum) {
            if (currFreq > currMode) {
                modes.clear();
                modes.add(currNum);
                currMode = currFreq;
            } else if (currFreq == currMode) {
                modes.add(currNum);
            }
            currNum = newNum;
            currFreq = 1;
        } else if (currNum == newNum) {
            currFreq++;
        }
    }

    public int[] findMode_v1(TreeNode root) {
        Map<Integer, Integer> numCount = new HashMap<>();
        int modeVal = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            Integer prevCount = numCount.put(node.val, numCount.getOrDefault(node.val, 0) + 1);
            prevCount = prevCount == null ? 1 : prevCount + 1;
            modeVal = prevCount > modeVal ? prevCount : modeVal;
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        List<Integer> modes = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry: numCount.entrySet()) {
            if (entry.getValue() == modeVal) {
                modes.add(entry.getKey());
            }
        }
        int[] result = new int[modes.size()];
        int i=0;
        for (int num: modes) {
            result[i++] = num;
        }
        return result;
    }

    public static void main(String[] args) {
        FineModeInBinarySearchTree solution = new FineModeInBinarySearchTree();
        TreeNode root = new TreeNode(1,
                            null,
                                new TreeNode(2,
                                        null,
                                        new TreeNode(2)));
        System.out.println(Arrays.toString(solution.findMode(root)));

        root = new TreeNode(5,
                        new TreeNode(3,
                                new TreeNode(2),
                                new TreeNode(4)),
                        new TreeNode(7,
                                new TreeNode(6),
                                new TreeNode(8))
        );
        solution.reset();
        System.out.println(Arrays.toString(solution.findMode(root)));

        solution.reset();
        System.out.println(Arrays.toString(solution.findMode(new TreeNode(0))));
    }

    private void reset() {
        modes = new ArrayList<>();
        currMode = 0;
        currFreq = 0;
        currNum = null;
    }
}
