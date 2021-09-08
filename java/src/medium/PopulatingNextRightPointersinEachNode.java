package medium;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect_v2(Node root) {
        Node leftMostVertical = root;
        // vertical loop
        while (leftMostVertical != null && leftMostVertical.left != null) {
            // horizontal loop
            Node horizontalNode = leftMostVertical;
            System.out.print("Parent: " + horizontalNode.val + " ->");
            while (horizontalNode != null) {
                System.out.println(" " + horizontalNode.left.val + ", " + horizontalNode.right.val);
                horizontalNode.left.next = horizontalNode.right;
                horizontalNode.right.next = horizontalNode.next == null ? null : horizontalNode.next.left;
                horizontalNode = horizontalNode.next;
            }
            leftMostVertical = leftMostVertical.left;
        }
        return root;
    }

    public Node connect(Node root) {
        if (root != null) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                Node prev = null;
                while (size > 0) {
                    if (prev != null) {
                        prev.next = queue.peek();
                    }
                    prev = queue.poll();
                    size--;
                    if (prev.left != null) queue.add(prev.left);
                    if (prev.right != null) queue.add(prev.right);
                }
                prev.next = null;   // right most node
            }
        }
        return root;
    }
}
