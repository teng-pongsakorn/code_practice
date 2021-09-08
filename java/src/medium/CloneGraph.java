package medium;

import java.util.*;

public class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph_bfs(Node node) {
        if (node == null) return node;
        Queue<Node> queue = new LinkedList<>();
        Map<Integer, Node> visited = new HashMap<>();
        Node copy = new Node(node.val);
        queue.add(node);
        visited.put(node.val, copy);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Node current = queue.poll() ;
                for (Node neighbor: current.neighbors) {
                    if (!visited.containsKey(neighbor.val)) {
                        visited.put(neighbor.val, new Node(neighbor.val));
                        queue.add(neighbor);
                    }
                    visited.get(current.val).neighbors.add(visited.get(neighbor.val));
                    visited.get(neighbor.val).neighbors.add(visited.get(current.val));
                }
                size--;
            }
        }
        return copy;
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node[] nodes = new Node[101];
        return clone(nodes, node);
    }

    private Node clone(Node[] newNodes, Node target) {
        newNodes[target.val] = new Node(target.val);
        for (Node neighbor: target.neighbors) {
            if (newNodes[neighbor.val] == null) {
                newNodes[target.val].neighbors.add(clone(newNodes, neighbor));
            } else {
                newNodes[target.val].neighbors.add(newNodes[neighbor.val]);
            }
        }
        return newNodes[target.val];
    }
}
