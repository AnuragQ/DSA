package java.heap;

import java.util.PriorityQueue;

public class MergeKsortedLL {
    public class ListNode {
        int val;
        ListNode next;     

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((x, y) -> x.val - y.val);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.add(lists[i]);
            }
        }
        ListNode ans = new ListNode(0), temp = ans;

        while (!pq.isEmpty()) {

            ListNode minNode = pq.remove();
            temp.next = minNode;
            temp = temp.next;
            minNode = minNode.next;
            if (minNode != null) {
                pq.add(minNode);
            }

        }
        return ans.next;

    }
}