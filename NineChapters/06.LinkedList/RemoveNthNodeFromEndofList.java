class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class RemoveNthNodeFromEndofList {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode p = head;
        int length = 0;
        while (p != null) {
            p = p.next;
            length++;
        }
        int r = 0;
        if (n == length) {
            r = 1;
        } else {
            r = length - n % length + 1;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        p = dummy;
        while (r > 1) {
            p = p.next;
            r--;
        }
        p.next = p.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndofList test = new RemoveNthNodeFromEndofList();
        ListNode head = new ListNode(1);
        ListNode one = new ListNode(2);
        head.next = one;
        System.out.println(test.removeNthFromEnd(head, 2));
    }
}