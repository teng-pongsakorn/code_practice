package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class IntersectionOfTwoLinkedLists {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        return a;
    }

    public static ListNode getIntersectionNode_v1(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<>();
        while (headA != null || headB != null) {
            if (headA != null) {
                if (visited.contains(headA)) {
                    return headA;
                }
                visited.add(headA);
                headA = headA.next;
            }
            if (headB != null) {
                if (visited.contains(headB)) {
                    return headB;
                }
                visited.add(headB);
                headB = headB.next;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        first.next = new ListNode(3);
        ListNode third = new ListNode(4);
        first.next.next = third;
        second.next = third;
        third.next = new ListNode(12);

        System.out.println(IntersectionOfTwoLinkedLists.getIntersectionNode(first, second).equals(third));
    }
}
