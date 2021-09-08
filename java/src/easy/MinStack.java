package easy;

public class MinStack {
    private Node head;
    class Node {
        int val;
        int min;
        Node next;
        public Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    public MinStack() {
        head = null;
    }

    public void push(int val) {
        if (head == null) {
            head = new Node(val, val);
        } else {
            head = new Node(val, Math.min(val, head.min), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    public static void main(String[] args) {

        MinStack obj = new MinStack();
        obj.push(2147483646);
        obj.push(2147483646);
        obj.push(2147483647);
        System.out.println(obj.top());    // 2147483647
        obj.pop();;
        System.out.println(obj.getMin());    // 2147483646
        obj.pop();
        System.out.println(obj.getMin());    // 2147483646
        obj.pop();
        obj.push(2147483647);
        System.out.println(obj.top());    // 2147483647
        System.out.println(obj.getMin()); // 2147483647

    }
}


