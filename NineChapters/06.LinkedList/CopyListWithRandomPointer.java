/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class CopyListWithRandomPointer {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
// O(n) space: using HashMap
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode headCopy = new RandomListNode(head.label);
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        map.put(head, headCopy);
        RandomListNode p = head;
        while (p.next != null) {
            RandomListNode node = new RandomListNode(p.next.label);
            map.put(p.next, node);
            map.get(p).next = node;
            p = p.next;
        }
        for (RandomListNode node : map.keySet()) {
            if (node.random != null) {
                map.get(node).random = map.get(node.random);
            }
        }
        return headCopy;
    }

// O(1) space
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode p = head;
        while (p != null) {
            RandomListNode node = new RandomListNode(p.label);
            node.next = p.next;
            p.next = node;
            p = p.next.next;
        }
        p = head;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        RandomListNode headCopy = head.next;
        p = head;
        while (p != null) {
            RandomListNode temp = p.next;
            p.next = p.next.next;
            if (temp.next != null) {
                temp.next = temp.next.next;
            }
            p = p.next;
            temp = temp.next;
        }
        return headCopy;
    }
}