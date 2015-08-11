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
public class MergeKSortedLists {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
// using minHeap, i.e. PriorityQueue in Java, need to write a comparator.
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.size(),
            new Comparator<ListNode>() {
                @Override
                public int compare(ListNode a, ListNode b) {
                    return a.val - b.val;
                }
            });
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            p.next = new ListNode(node.val);
            p = p.next;
            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }
        return dummy.next;
    }

// divide and conquer
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        while (lists.size() > 1) {
            List<ListNode> cur = new ArrayList<>();
            int i = 0;
            for (i = 0; i < lists.size() - 1; i += 2) {
                cur.add(mergeTwoLists(lists.get(i), lists.get(i + 1)));
            }
            if (i == lists.size() - 1) {
                cur.add(lists.get(i));
            }
            lists = cur;
        }
        return lists.get(0);
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