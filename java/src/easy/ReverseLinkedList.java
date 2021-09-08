package easy;

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
public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
    public static ListNode reverseList_v2(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextCurrent = current.next;
            current.next = prev;
            prev = current;
            current = nextCurrent;
        }
        return prev;
    }
    public static ListNode reverseList_v1(ListNode head) {
        ListNode result = null;
        while (head != null) {
            result = new ListNode(head.val, result);
            head = head.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode case1 = Util.createLinkedList(new int[] {1,2,3,4,5});
        Util.printListNode(case1);
        Util.printListNode(ReverseLinkedList.reverseList(case1));

        case1 = Util.createLinkedList(new int[] {1});
        Util.printListNode(case1);
        Util.printListNode(ReverseLinkedList.reverseList(case1));

    }
}
