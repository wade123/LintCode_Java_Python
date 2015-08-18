/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class RotateList {
    /**
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int length = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            length++;
        }
        int remainder = k % length;
        if (remainder == 0) {
            return head;
        }
        p = head;
        for (int i = 1; i < length - remainder; i++) {
            p = p.next;
        }
        ListNode newHead = p.next;
        p.next = null;
        p = newHead;
        while (p.next != null) {
            p = p.next;
        }
        p.next = head;
        return newHead;
    }
}
