package easy;

public class RemoveDuplicatesFromSortedList {
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

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode result = new ListNode(999);
        ListNode tail = result;
        while (head != null) {
            if (head.val != tail.val) {
                tail.next = head;
                tail = tail.next;
            } else {
                tail.next = null;
            }
            head = head.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1, new ListNode(1, new ListNode(2, new
                ListNode(2, new ListNode(3, new ListNode(3))))));

        System.out.println(a);
        System.out.println(RemoveDuplicatesFromSortedList.deleteDuplicates(a));
    }
}
