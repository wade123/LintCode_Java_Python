class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class RemoveDuplicatesFromSortedListTwo {
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of the linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        ListNode q = dummy;
        while (p.next != null) {
            q = p.next;
            if (q.next != null && q.val == q.next.val) {
                while (q.next != null && q.val == q.next.val) {
                    q = q.next;
                }
                p.next = q.next;
            } else {
                p = p.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedListTwo test = new RemoveDuplicatesFromSortedListTwo();
        ListNode head = new ListNode(1);
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        head.next = one; //one.next = two; two.next = three;
        ListNode p = test.deleteDuplicates(head);
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}