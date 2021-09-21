package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public
 */
class Solution {

}
public class UniqueBinarySearchTreesII {
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }

    private List<TreeNode> generate(int start, int end) {
        if (start > end) {
            List<TreeNode> result = new ArrayList<>();
            result.add(null);
            return result;
        }
        if (start == end) {
            return Arrays.asList(new TreeNode(start));
        }
        List<TreeNode> result = new ArrayList<>();
        for (int i=start; i<=end; i++) {
            for (TreeNode left: generate(start, i-1)) {
                for (TreeNode right: generate(i+1, end)) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    result.add(node);
                }
            }
        }
        return result;
    }
}
