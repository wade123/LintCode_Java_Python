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
public class MergeTwoSortedLists {
    /**
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = l1;
        ListNode q = l2;
        ListNode r = dummy;
        while (p != null && q != null) {
            if (p.val < q.val) {
                r.next = new ListNode(p.val);
                p = p.next;
            } else {
                r.next = new ListNode(q.val);
                q = q.next;
            }
            r = r.next;
        }
        while (p != null) {
            r.next = new ListNode(p.val);
            p = p.next;
            r = r.next;
        }
        while (q != null) {
            r.next = new ListNode(q.val);
            q = q.next;
            r = r.next;
        }
        return dummy.next;
    }
}