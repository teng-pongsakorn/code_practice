package hard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
public class SerializeandDeserializeBinaryTree {

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            sb.append(node == null ? "null" : node.val);
            sb.append(",");
            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        sb.setLength(sb.length()-1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<TreeNode> queue = new LinkedList<>();
        for (String s: data.split(",")) {
            try {
                queue.add(new TreeNode(Integer.valueOf(s)));
            } catch (NumberFormatException e) {
                queue.add(null);
            }
        }
        Queue<TreeNode> levelQueue = new LinkedList<>();
        TreeNode root = queue.poll();
        levelQueue.add(root);
        while (!queue.isEmpty()) {
            int size = levelQueue.size();
            while (size > 0) {
                TreeNode current = levelQueue.poll();
                current.left = queue.poll();
                current.right = queue.poll();
                if (current.left != null) levelQueue.add(current.left);
                if (current.right != null) levelQueue.add(current.right);
                size--;
            }
        }
        return root;


//        String[] nodeList = data.split(",");
//        if (nodeList.length == 0) return null;
//        TreeNode root = makeTree(1, nodeList);
//        return root;
    }

    private TreeNode makeTree(int i, String[] nodeList) {
        if (i > nodeList.length) return null;
        try {
            TreeNode node = new TreeNode(Integer.valueOf(nodeList[i-1]));
            node.left = makeTree(2*i, nodeList);
            node.right = makeTree(2*i + 1, nodeList);
            return node;
        } catch (NumberFormatException e) {
            return null;
        }
    }


    public static void main(String[] args) {
        SerializeandDeserializeBinaryTree sol = new SerializeandDeserializeBinaryTree();
        TreeNode root = sol.deserialize("1,2,3,null,null,4,5");
        System.out.println(root.val == 1 && root.left.val==2 && root.right.val==3 && root.right.left.val==4 && root.right.right.val==5);
        System.out.println(Arrays.toString("".split(",")));
    }
}
