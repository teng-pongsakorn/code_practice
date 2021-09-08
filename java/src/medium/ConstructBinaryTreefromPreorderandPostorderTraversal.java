package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public
 */
public class ConstructBinaryTreefromPreorderandPostorderTraversal {
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

    int preIndex = 0;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        Map<Integer, Integer> postIndexMap = new HashMap<>();
        for (int i=0; i<postorder.length; i++) {
            postIndexMap.put(postorder[i], i);
        }
        return build_basic(preorder, 0, preorder.length-1, postorder, 0, postorder.length-1);
    }

    private TreeNode build_basic(int[] preorder, int s1, int e1, int[] postorder, int s2, int e2) {
        if (s1 > e1) return null;
        TreeNode node = new TreeNode(preorder[s1]);
        int i=0;
        while (postorder[s2+i] != preorder[s1+1]) {
            i++;
        }
        int next = s1+1;
        node.left = build_basic(preorder, next, next+i, postorder, s2, s2+i);
        node.right = build_basic(preorder, next+i+1, e1, postorder, s2+i+1, e2-1);
        return node;
    }


//    private TreeNode build(int[] preorder, int lo, int hi, Map<Integer, Integer> postIndexMap) {
//        if (lo > hi) return null;
//        TreeNode node = new TreeNode(preorder[preIndex++]);
//        System.out.println("build node: " + node.val + " lo=" + lo + ", hi=" + hi);
//        node.left = build(preorder, lo, postIndexMap.get(preorder[preIndex]) - 1, postIndexMap);
//        node.right = build(preorder, postIndexMap.get(preorder[preIndex]) + 1, hi, postIndexMap);
//        return node;
//    }
}
