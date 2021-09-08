package easy;

import java.util.Stack;

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
public class MyQueue {

    Stack<Integer> stack;
    Stack<Integer> queue;
    int top;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<>();
        queue = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
//        if (this.stack.isEmpty()) {
//            this.top = x;
//        }
        this.stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
//        Stack<Integer> tmpStack = new Stack<>();
//        while (this.stack.size() > 1) {
//            this.top = this.stack.pop();
//            tmpStack.push(this.top);
//        }
//        int x = this.stack.pop();
//        while (!tmpStack.isEmpty()) {
//            this.stack.push(tmpStack.pop());
//        }
        if (queue.isEmpty()) {
            while (!stack.isEmpty()) {
                queue.push(stack.pop());
            }
        }
        int x = queue.pop();
        return x;
    }

    /** Get the front element. */
    public int peek() {
        if (queue.isEmpty()) {
            while (!stack.isEmpty()) {
                queue.push(stack.pop());
            }
        }
        return queue.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return queue.isEmpty() && stack.isEmpty();
    }


    /// test
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        System.out.println(q.empty() == true);
        q.push(1);
        System.out.println(q.empty() == false);
        System.out.println(q.peek() == 1);
        q.push(3);
        q.push(4);
        System.out.println(q.pop() == 1);
        System.out.println(q.peek() == 3);
        q.pop();
        q.pop();
        System.out.println(q.empty()==true);
    }
}


