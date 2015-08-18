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
public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
     * using constant space complexity.
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode rightHead = slow.next;
        slow.next = null;
        ListNode leftSorted = sortList(head);
        ListNode rightSorted = sortList(rightHead);
        return mergeTwoLists(leftSorted, rightSorted);
    }

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