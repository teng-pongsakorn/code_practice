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
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carryOver = 0;
        ListNode result = new ListNode(0);
        ListNode current = result;
        while (carryOver!=0 || l1!=null || l2!=null) {
            int val1 = l1==null ? 0 : l1.val;
            int val2 = l2==null ? 0 : l2.val;
            l1 = l1==null ? null : l1.next;
            l2 = l2==null ? null : l2.next;
            carryOver = carryOver + val1 + val2;
            current.next = new ListNode(carryOver%10);
            current = current.next;
            carryOver /= 10;
        }
        return result.next;
    }
}
