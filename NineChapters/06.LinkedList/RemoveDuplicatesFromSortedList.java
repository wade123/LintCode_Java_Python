class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class RemoveDuplicatesFromSortedList {
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) { 
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList test = new RemoveDuplicatesFromSortedList();
        ListNode head = new ListNode(1);
        ListNode one = new ListNode(2);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        head.next = one; one.next = two; two.next = three;
        ListNode p = one;
        test.deleteDuplicates(p);
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
