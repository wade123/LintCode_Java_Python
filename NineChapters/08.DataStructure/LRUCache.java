class DoubleLinkedListNode {
    int val;
    int key;
    DoubleLinkedListNode pre;
    DoubleLinkedListNode next;
    DoubleLinkedListNode(int key, int val) {
        this.key = key;
        this.val = val;
        this.pre = null;
        this.next = null;
    }
}

public class Solution {
    private Map<Integer, DoubleLinkedListNode> map;
    private int capacity;
    DoubleLinkedListNode head;
    DoubleLinkedListNode tail;

    // @param capacity, an integer
    public Solution(int capacity) {
        this.map = new HashMap<>(capacity);
        this.capacity = capacity;
        this.head = null;
        this.tail = null;
    }

    // @return an integer
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            DoubleLinkedListNode node = map.get(key);
            removeNode(node);
            setHead(node);
            return node.val;
        }
        
    }

    private void removeNode(DoubleLinkedListNode node) {
        if (node.pre == null) {
            this.head = node.next;
        } else {
            node.pre.next = node.next;
        }
        if (node.next == null) {
            this.tail = node.pre;
        } else {
            node.next.pre = node.pre;
        }
    }

    private void setHead(DoubleLinkedListNode node) {
        node.next = this.head;
        node.pre = null;
        if (this.head != null) {
            this.head.pre = node;
        }
        this.head = node;
        if (this.tail == null) {
            this.tail = node;
        }
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            DoubleLinkedListNode node = map.get(key);
            removeNode(node);
            setHead(node);
            node.val = value;
        } else {
            DoubleLinkedListNode newNode = new DoubleLinkedListNode(key, value);
            if (map.size() < capacity) {
                setHead(newNode);
            } else {
                map.remove(tail.key);
                removeNode(tail);
                setHead(newNode);
            }
            map.put(key, newNode);
        }
    }
}
