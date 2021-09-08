package easy;

import java.util.List;

public class Util {

    public static TreeNode createTreeNode(List<Integer> values) {
        return getRoot(values, 0);
    }

    private static TreeNode getRoot(List<Integer> values, int index) {
        if (index >= values.size() || values.get(index)==-1) {
            return null;
        }
        int next1 = (index + 1) * 2;
        int next2 = next1 + 1;
        return new TreeNode(values.get(index), getRoot(values, next1 - 1), getRoot(values, next2 - 1));
    }

    public static ListNode createLinkedList(int[] nums) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int num: nums) {
            current.next = new ListNode(num);
            current = current.next;
        }
        return dummy.next;
    }

    public static void printListNode(ListNode root) {
        System.out.print("[ ");
        while (root != null) {
            System.out.print(root.val + " ");
            root = root.next;
        }
        System.out.println("]");
    }
}
