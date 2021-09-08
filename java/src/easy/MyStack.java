package easy;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    private Queue<Integer> q1;
    private Integer top;
    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        Queue<Integer> tmpQ = new LinkedList<>();
        tmpQ.add(x);
        tmpQ.addAll(q1);
        q1 = tmpQ;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q1.poll();
    }

    /** Get the top element. */
    public int top() {
        return q1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return this.q1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop()==4);
        System.out.println(stack.top()==3);
        System.out.println(stack.empty()==false);
        stack.pop();
        System.out.println(stack.empty()==true);
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
