package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NaryTreePreorderTraverse {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }

    private void traverse(Node node, List<Integer> result) {
        if (node != null) {
            result.add(node.val);
            for (Node child: node.children) {
                traverse(child, result);
            }
        }
    }

    public List<Integer> preorderIterative(Node root) {
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        while (root != null) {
            result.add(root.val);
            for (int j=root.children.size()-1; j>=0; j--) {
                stack.push(root.children.get(j));
            }
            root = stack.isEmpty() ? null : stack.pop();
        }
        return result;
    }
}
