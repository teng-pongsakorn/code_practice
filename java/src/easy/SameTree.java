package easy;

import java.util.Stack;

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{p, q});
        while (!stack.isEmpty()) {
            TreeNode[] nodes = stack.pop();
            if (nodes[0] != null && nodes[1] != null && nodes[0].val == nodes[1].val) {
                // continue checking
                stack.push(new TreeNode[] {nodes[0].left, nodes[1].left});
                stack.push(new TreeNode[] {nodes[0].right, nodes[1].right});
            } else if (nodes[0] != null || nodes[1] != null) {
                return false;
            }
        }
        return true;
    }

    public boolean isSameTree_v1(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null && q != null) {
            return false;
        }
        if (q == null && p != null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

//class TreeNode {
//    int val;
// TreeNode left;
// TreeNode right;
//      TreeNode() {}
//      TreeNode(int val) { this.val = val; }
//      TreeNode(int val, TreeNode left, TreeNode right) {
//          this.val = val;
//          this.left = left;
//          this.right = right;
//      }
//  }

