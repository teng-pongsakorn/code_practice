package easy;

import java.util.PriorityQueue;

public class KthLargest {

//    class Node {
//        int val;
//        Node left;
//        Node right;
//
//        public Node(int val) {
//            this.val = val;
//        }
//    }
//
//    Node root;
//    int k;
//    int size;
//
//    public KthLargest(int k, int[] nums) {
//        this.root = null;
//        this.k = k;
//        this.size = 0;
//        for (int num: nums) {
//            add(num);
//        }
//    }
//
//    public int add(int num) {
//        // insert num to the tree
//        Node prev = null;
//        Node current = this.root;
//        while (current != null) {
//            prev = current;
//            if (num < current.val) {
//                current = current.left;
//            } else {
//                current = current.right;
//            }
//        }
//        if (prev == null) {
//            this.root = new Node(num);
//        } else if (num < prev.val) {
//            prev.left = new Node(num);
//        } else {
//            prev.right = new Node(num);
//        }
//        this.size++;
//        // get k-th number
//        return getKthNum();
//    }
//
//    private int getKthNum() {
//        if (this.k < this.size / 2) {
//            return getKthNumFromLeft(this.size - this.k + 1);
//        } else {
//            return getKthNumFromRight(this.k);
//        }
//    }
//
//    private int getKthNumFromRight(int k) {
//        Stack<Node> stack = new Stack<>();
//        Node current = this.root;
//        int count = 0;
//        int result = -1;
//        while (current != null || !stack.isEmpty()) {
//            while (current != null) {
//                stack.add(current);
//                current = current.right;
//            }
//            current = stack.pop();
//            result = current.val;
//            count++;
//            if (count == k) return result;
//            current = current.left;
//        }
//        return result;
//    }
//
//    private int getKthNumFromLeft(int k) {
//        Stack<Node> stack = new Stack<>();
//        Node current = this.root;
//        int count = 0;
//        int result = -1;
//        while (current != null || !stack.isEmpty()) {
//            while (current != null) {
//                stack.add(current);
//                current = current.left;
//            }
//            current = stack.pop();
//            result = current.val;
//            count++;
//            if (count == k) return result;
//            current = current.right;
//        }
//        return result;
//    }
    PriorityQueue<Integer> queue;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.queue = new PriorityQueue<>(k);
        for (int num: nums) {
            add(num);
        }
    }

    public int add(int num) {
        if (queue.size() < k) {
            queue.offer(num);
        } else if (queue.peek() < num){
            queue.poll();
            queue.offer(num);
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 8, 2};
        int k = 3;
        KthLargest obj = new KthLargest(k, nums);
        System.out.println(obj.add(3));; // 4;
        System.out.println(obj.add(5));; // 5
        System.out.println(obj.add(10));; // 5
        System.out.println(obj.add(9));; // 8
        System.out.println(obj.add(4));; // 8

    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */