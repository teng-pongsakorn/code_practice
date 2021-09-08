package easy;

import java.util.HashSet;
import java.util.Set;

public class LowestLeastCommonOfBinarySearchTree {
    public static TreeNode lowestCommonAncestor_iterative(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }
    public static TreeNode lowestCommonAncestor_recursive(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor_recursive(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor_recursive(root.right, p, q);
        }
        return root;
    }
    public static TreeNode lowestCommonAncestorv(TreeNode root, TreeNode p, TreeNode q) {
        Set<Integer> target = new HashSet<>();
        target.add(p.val);
        target.add(q.val);

        TreeNode result = search(root, target);
        return result;
    }

    private static TreeNode search(TreeNode root, Set<Integer> target) {
        if (root == null) return null;
        TreeNode resultLeft = search(root.left, target);
        TreeNode resultRight = search(root.right, target);
        if (target.isEmpty()) {
            if (resultLeft != null && resultRight!=null) {
                return root;
            }
        } else if (target.remove(root.val)) {
            return root;
        }
        return resultLeft != null ? resultLeft : resultRight;
    }

    public static void main(String[] args) {

    }
}
