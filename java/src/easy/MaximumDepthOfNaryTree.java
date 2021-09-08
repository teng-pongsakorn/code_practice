package easy;

import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class MaximumDepthOfNaryTree {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        return findMaxDepth(root, 1);
    }

    private int findMaxDepth(Node parent, int depth) {
        if (parent.children.size() == 0) return depth;
        int max = Integer.MIN_VALUE;
        for (Node child: parent.children) {
            int childDepth = findMaxDepth(child, depth+1);
            if (childDepth > max) {
                max = childDepth;
            }
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
