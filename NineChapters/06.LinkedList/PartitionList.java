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
public class PartitionList {
    /**
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode 
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null && p.next.val < x) {
            p = p.next;
        }
        ListNode q = p.next;
        while (q != null && q.next != null) {
            if (q.next.val >= x) {
                q = q.next;
            } else {
                ListNode temp = q.next;
                q.next = q.next.next;
                temp.next = p.next;
                p.next = temp;
                p = p.next;
            }
        }
        return dummy.next;
    }
}