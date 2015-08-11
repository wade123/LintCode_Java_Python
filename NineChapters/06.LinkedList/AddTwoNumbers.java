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
public class AddTwoNumbers {
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode p = l1;
        ListNode q = l2;
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode r = dummy;
        while (p != null && q != null) {
            int sum = (p.val + q.val + carry) % 10;
            carry = (p.val + q.val + carry) / 10;
            r.next = new ListNode(sum);
            p = p.next;
            q = q.next;
            r = r.next;
        }
        while (p != null) {
            int sum = (p.val + carry) % 10;
            carry = (p.val + carry) / 10;
            r.next = new ListNode(sum);
            p = p.next;
            r = r.next;
        }
        while (q != null) {
            int sum = (q.val + carry) % 10;
            carry = (q.val + carry) / 10;
            r.next = new ListNode(sum);
            q = q.next;
            r = r.next;
        }
        if (carry != 0) {
            r.next = new ListNode(carry);
        }
        return dummy.next;
    }
}