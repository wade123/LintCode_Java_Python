class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Rehashing {
    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        int capacity = 2 * hashTable.length;
        ListNode[] rehashedTable = new ListNode[capacity];
        for (ListNode head : hashTable) {
            while (head != null) {
                int hashValue = hashcode(head.val, capacity);
                if (rehashedTable[hashValue] == null) {
                    rehashedTable[hashValue] = new ListNode(head.val);
                } else {
                    ListNode node = rehashedTable[hashValue];
                    while (node.next != null) {
                        node = node.next;
                    }
                    node.next = new ListNode(head.val);
                }
                head = head.next;
            }
        }
        return rehashedTable;
    }

    private int hashcode(int key, int capacity) {
        return (key % capacity + capacity) % capacity;
    }

    public static void main(String[] args) {
        Rehashing test = new Rehashing();
        ListNode[] hashTable = new ListNode[4];
        hashTable[1] = new ListNode(21);
        hashTable[1].next = new ListNode(9);
        hashTable[2] = new ListNode(14);
        ListNode[] result = test.rehashing(hashTable);
        for (ListNode node : result) {
            while (node != null) {
                System.out.print(node.val + ",");
                node = node.next;
            }
            System.out.println("-------------------------");
        }
    }
}