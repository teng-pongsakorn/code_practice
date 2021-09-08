package medium;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNodeII {

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
    }

    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;
            while (size > 0) {
                Node current = queue.poll();
                if (prev != null) {
                    prev.next = current;
                }
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
                prev = current;
                size--;
            }
        }
        return root;
    }

    public Node connect_recursive(Node root) {
        if (root == null) return root;
        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                root.left.next = findNext(root);
            }
        }
        if (root.right != null) {
            root.right.next = findNext(root);
        }

        connect_recursive(root.right);
        connect_recursive(root.left);
        return root;
    }

    private Node findNext(Node root) {
        while (root.next != null) {
            root = root.next;
            if (root.left != null) return root.left;
            if (root.right != null) return root.right;
        }
        return null;
    }
}
