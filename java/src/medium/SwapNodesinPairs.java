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
public class SwapNodesinPairs {
    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        swap(dummy);
        return dummy.next;
    }

    private void swap(ListNode node) {
        // base case; no node or only 1 last node
        if (node.next == null || node.next.next == null) return;

        // swap next 2 nodes, then keep swap() for the next 2 nodes until reach base cases
        ListNode first = node.next;
        ListNode second = first.next;   // node -> first -> second -> xxx
        first.next = second.next;       // node -> first -> xxx
        node.next = second;             // node -> second
        second.next = first;            // node -> second -> first -> xxx
        swap(first);
    }
}
