/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class ReverseLinkedListTwo {
    /**
     * @param ListNode head is the head of the linked list 
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        if (head == null || m == n) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        for (int i = 0; i < m - 1; i++) {
            p = p.next;
        }
        ListNode q = p.next;
        for (int i = 0; i < n - m; i++) {
            ListNode temp = q.next;
            q.next = q.next.next;
            temp.next = p.next;
            p.next = temp;
        }
        return dummy.next;
    }
}
