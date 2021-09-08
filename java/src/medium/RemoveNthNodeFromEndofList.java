package medium;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        ListNode tail = head;
        for (int i=0; i<n; i++) {
            head = head.next;
        }
        while (head.next != null) {
            head = head.next;
            tail = tail.next;
        }
        tail.next = tail.next.next;
        return dummy.next;
    }
}
