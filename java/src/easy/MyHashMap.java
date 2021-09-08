package easy;
public class MyHashMap {

    class ListNode {
        int key;
        int value;
        ListNode next;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    ListNode[] listNodes;
    private final int SIZE = 10000;
    /** Initialize your data structure here. */
    public MyHashMap() {
        listNodes = new ListNode[SIZE];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        ListNode prev = findListNode(key);
        if (prev.next == null) {
            prev.next = new ListNode(key, value);
        } else {
            prev.next.value = value;
        }
    }

    private ListNode findListNode(int key) {
        int address = getAddress(key);
        if (listNodes[address] == null) {
            listNodes[address] = new ListNode(-1, -1);  // dummy node
            return listNodes[address];
        }
        ListNode prev = listNodes[address];
        while (prev.next != null && prev.next.key != key) {
            prev = prev.next;
        }
        return prev;
    }

    private int getAddress(int key) {
        return key % SIZE;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        ListNode prev = findListNode(key);
        if (prev.next == null) {
            return -1;
        }
        return prev.next.value;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        ListNode prev = findListNode(key);
        if (prev.next != null) {
            prev.next = prev.next.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */