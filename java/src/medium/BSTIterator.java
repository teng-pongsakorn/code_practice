package medium;

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
public class BSTIterator {

    TreeNode root;

    public BSTIterator(TreeNode root) {
        this.root = root;
    }

    public int next() {
//        TreeNode tourist = this.root;
        TreeNode guide;
        while (root != null) {
            guide = root.left;
            //
            if (guide == null) {
                int result = root.val;
                root = root.right;
                return result;
            } else {
                while (guide.right != null && root != guide.right) {
                    guide = guide.right;
                }
                if (guide.right == null) {
                    // create bridge
                    guide.right = root;
                    root = root.left;
                } else {
                    // destroy bridge
                    guide.right = null;
                    int result = root.val;
                    root = root.right;
                    return result;
                }
            }
        }
        return -1;
    }

    public boolean hasNext() {
        return root != null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(9,
                                new TreeNode(5,
                                        new TreeNode(3,
                                                null,
                                                new TreeNode(4)),
                                        new TreeNode(7,
                                                new TreeNode(6),
                                                null)),
                                new TreeNode(11,
                                        new TreeNode(10),
                                        null)
        );

        BSTIterator bstIterator = new BSTIterator(root);
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());

    }

    private void traverse() {
        TreeNode tourist = this.root;
        TreeNode guide;
        while (tourist != null) {
            guide = tourist.left;
            //
            if (guide == null) {
                System.out.print(tourist.val + " -> ");
                tourist = tourist.right;
            } else {
//                System.out.println("tourist: " + tourist.val + ", guide: " + guide.val);
                // to the right most node
                while (guide.right != null && tourist != guide.right) {
//                    System.out.println("guide: " +guide.val);
                    guide = guide.right;
                }
                if (guide.right == null) {
                    // create bridge
                    guide.right = tourist;
                    tourist = tourist.left;
                } else {
                    // destroy bridge
                    guide.right = null;
                    System.out.print(tourist.val + " -> ");
                    tourist = tourist.right;
                }
            }
        }
    }
}
//public class BSTIterator {
//
//    Stack<TreeNode> stack;
//
//     public BSTIterator(TreeNode root) {
//         stack = new Stack<>();
//         pushAllLeft(root);
//    }
//
//    private void pushAllLeft(TreeNode node) {
//         while (node != null) {
//             stack.push(node);
//             node = node.left;
//         }
//    }
//
//    public int next() {
//        TreeNode current = stack.pop();
//        pushAllLeft(current.right);
//        return current.val;
//    }
//
//    public boolean hasNext() {
//        return !stack.isEmpty();
//    }
//}
//public class BSTIterator {
//
//    private Queue<TreeNode> queue;
//
//    public BSTIterator(TreeNode root) {
//        queue = new LinkedList<>();
//        traverse(root, queue);
//    }
//
//    private void traverse(TreeNode root, Queue<TreeNode> queue) {
//        if (root == null) return;
//        traverse(root.left, queue);
//        queue.add(root);
//        traverse(root.right, queue);
//    }
//
//    public int next() {
//        return queue.poll().val;
//    }
//
//    public boolean hasNext() {
//        return !queue.isEmpty();
//    }
//}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

