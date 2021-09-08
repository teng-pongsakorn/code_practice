package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NaryTreePostorderTraverse {
    public List<Integer> postorderIterative(Node root) {
        List<Integer> result = new ArrayList<>();
        Stack<Node> firstStack = new Stack<>();
        Stack<Node> secondStack = new Stack<>();
        firstStack.push(root);
        while (!firstStack.isEmpty()) {
            Node node = firstStack.pop();
            if (node != null) {
                secondStack.push(node);
                for (Node child: node.children) {
                    firstStack.push(child);
                }
            }
        }
        while (!secondStack.isEmpty()) {
            result.add(secondStack.pop().val);
        }
        return result;
    }

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }

    private void traverse(Node node, List<Integer> result) {
        if (node == null) return;
        for (Node child: node.children) {
            traverse(child, result);
        }
        result.add(node.val);
    }
}
