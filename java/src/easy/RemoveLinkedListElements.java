package easy;

public class RemoveLinkedListElements {
    public static ListNode removeElements(ListNode head, int val) {
        ListNode result = new ListNode(-1);
        ListNode current = result;
        while (head != null) {
            if (head.val != val) {
                current.next = head;
                current = current.next;
            }
            head = head.next;
        }
        current.next = null;
        return result.next;
    }
    public static void main(String[] args) {
        // [1,2,3,4,5] remove 3 => [1,2,4,5]
        ListNode head = fromArray(new int[]{1,2,3,4,5});
        printListNode(RemoveLinkedListElements.removeElements(head, 3));
        // [] remove 0 => []
        printListNode(RemoveLinkedListElements.removeElements(null, 3));
        // [1,2,3,4,3,5,3] remove 3 => [1,2,4,5]
        printListNode(RemoveLinkedListElements.removeElements(fromArray(new int[]{1,2,3,4,3,5,3}), 3));
    }

    private static void printListNode(ListNode head) {
        System.out.print("[ ");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println("]");
    }

    private static ListNode fromArray(int[] nums) {
        ListNode result = new ListNode(-1);  // dummy node
        ListNode current = result;
        for (int num: nums) {
            current.next = new ListNode(num);
            current = current.next;
        }
        return result.next;
    }
}
