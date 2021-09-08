package medium;

public class RemoveDuplicatesFromSortedList2 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode node = this;
            while (node.next != null) {
                sb.append(node.val + " ");
                node = node.next;
            }
            sb.append(node.val);
            return sb.toString();
        }
    }

    public static ListNode deleteDuplicates_v2(ListNode head) {
        ListNode sentinel = new ListNode(0, head);
        ListNode prev = sentinel;
        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                prev.next = head.next;
            } else {
                prev = prev.next;
            }
            head = head.next;
        }
        return sentinel.next;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode result = new ListNode(999);
        ListNode tail = result;
        ListNode candidate = null;
        int count = 0;
        while (head != null) {
            if (candidate == null) {
                candidate = head;
                count = 1;
            } else if (candidate.val == head.val){
                count++;
            } else {
                if (count == 1) {
                    tail.next = candidate;
                    tail = tail.next;
                }
                candidate = head;
                count = 1;
            }
            head = head.next;
        }
        if (count == 1) {
            tail.next = candidate;
        } else {
            tail.next = null;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3))))));
        System.out.println(a);
        System.out.println(RemoveDuplicatesFromSortedList2.deleteDuplicates(a));
        System.out.println(RemoveDuplicatesFromSortedList2.deleteDuplicates_v2(a));

        ListNode b = new ListNode(1, new ListNode(2, new ListNode(2)));
        System.out.println(b);
        System.out.println(RemoveDuplicatesFromSortedList2.deleteDuplicates(b));
        System.out.println(RemoveDuplicatesFromSortedList2.deleteDuplicates_v2(b));

        ListNode c = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3, new ListNode(4))))));
        System.out.println(c);
        System.out.println(RemoveDuplicatesFromSortedList2.deleteDuplicates(c));
        System.out.println(RemoveDuplicatesFromSortedList2.deleteDuplicates_v2(c));
    }


}
