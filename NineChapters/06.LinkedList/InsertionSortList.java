/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class InsertionSortList {
    /**
     * @param head: The first node of linked list.
     * @return: The head of linked list.
     */
// insertion sort according to its definition
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = head;
        ListNode q = head.next;
        while (p.next != null) {
            q = p.next;
            ListNode temp = dummy;
            while (temp.next != q && q.val > temp.next.val) {
                temp = temp.next;
            }
            if (temp.next == q) {
                p = p.next;
            } else {
                p.next = p.next.next;
                q.next = temp.next;
                temp.next = q;
            }
        }
        return dummy.next;
    }

// optimized insertion sort
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = head;
        while (p != null && p.next != null) {
            if (p.val <= p.next.val) {
                p = p.next;
            } else {
                ListNode pre = dummy;
                ListNode temp = p.next;
                while (temp.val > pre.next.val) {
                    pre = pre.next;
                }
                p.next = p.next.next;
                temp.next = pre.next;
                pre.next = temp;
            }
        }
        return dummy.next;
    }
}
