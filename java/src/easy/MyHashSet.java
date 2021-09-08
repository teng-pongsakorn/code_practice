package easy;

class MyHashSet {

    class ListNode {
        int key;
        ListNode next;

        public ListNode(int key) {
            this.key = key;
        }
    }
    /** Initialize your data structure here. */
    final int SIZE = 10000;
    ListNode[] listNodes;

    public MyHashSet() {
        listNodes = new ListNode[SIZE];
    }

    public void add(int key) {
        ListNode preNode = getPreNode(key);
        if (preNode.next == null) {
            preNode.next = new ListNode(key);
        }
    }

    public void remove(int key) {
        ListNode preNode = getPreNode(key);
        if (preNode.next != null) {
            preNode.next = preNode.next.next;
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        ListNode preNode = getPreNode(key);
        return preNode.next != null;
    }

    private ListNode getPreNode(int key) {
        int address = key % SIZE;
        if (listNodes[address] != null) {
            ListNode current = listNodes[address];
            while (current.next != null && current.next.key != key) {
                current = current.next;
            }
            return current;
        }
        listNodes[address] = new ListNode(-1); // dummy node
        return listNodes[address];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */