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
public class PalindromeLinkedList {
    public static boolean isPalindrome(ListNode head) {
        ListNode reverse = null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null && fast.next!=null) {
            fast = fast.next.next;

            ListNode tmp = reverse;
            reverse = slow;
            slow = slow.next;
            reverse.next = tmp;
        }
        if (fast != null) {
            slow = slow.next;
        }
//        Util.printListNode(reverse);
//        Util.printListNode(slow);
        while (reverse != null && reverse.val==slow.val) {
            reverse = reverse.next;
            slow = slow.next;
        }
        return reverse == null;
    }

    public static boolean isPalindrome_v1(ListNode head) {
        // make a reverse list
        ListNode reverse = reverseList(head);
        // loop and compare one by one
        while (head != null && reverse != null) {
            if (head.val != reverse.val) {
                return false;
            }
            head = head.next;
            reverse = reverse.next;
        }
        return head == reverse;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode result = null;
        while (head != null) {
            result = new ListNode(head.val, result);
            head = head.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode list = Util.createLinkedList(new int[]{1,2,2,1});
        System.out.println(PalindromeLinkedList.isPalindrome(list));

        list = Util.createLinkedList(new int[]{1,2});
        System.out.println(PalindromeLinkedList.isPalindrome(list));
    }
}
