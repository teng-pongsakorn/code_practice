package easy;

//class ListNode {
//      int val;
//      ListNode next;
//      ListNode(int x) {
//          val = x;
//          next = null;
//      }
//  }

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LinkedListCycle {
    public static boolean hasCycle(ListNode head) {
        ListNode currentNode = head;
        ListNode tempNode;
        while (currentNode != null && currentNode.next != null) {
            if (currentNode.next.equals(head)) return true;
            tempNode = currentNode.next;
            currentNode.next = head;
            currentNode = tempNode;
        }
        return false;
    }
    public static boolean hasCycle_v1(ListNode head) {
        if (head == null) return false;

        Set<ListNode> visited = new HashSet<>();
        Queue<ListNode> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            if (visited.contains(node)) {
                return true;
            }
            visited.add(node);
            if (node.next != null) {
                queue.add(node.next);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode root1 = new ListNode(0);
        root1.next = new ListNode(2);
        root1.next.next = new ListNode(0);
        root1.next.next.next = new ListNode(-3);
        root1.next.next.next.next = root1.next;

        System.out.println(LinkedListCycle.hasCycle(root1));

        root1 = new ListNode(1);
        System.out.println(LinkedListCycle.hasCycle(root1));

        root1 = new ListNode(1);
        root1.next = new ListNode(2);
        root1.next =root1;
        System.out.println(LinkedListCycle.hasCycle(root1));
    }
}
