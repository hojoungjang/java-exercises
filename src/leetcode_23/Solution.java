package leetcode_23;

import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Comparator;

class Solution {

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode node1, ListNode node2) {
                return node1.val - node2.val;
            }
        });
        ListNode[] ptrs = Arrays.copyOf(lists, lists.length);
        
        for (int i=0; i < ptrs.length; i++) {
            if (ptrs[i] != null) {
                pq.add(ptrs[i]);
                ptrs[i] = ptrs[i].next;
            }
        }
        
        ListNode sortedHead = new ListNode(0);
        ListNode sortedPtr = sortedHead;

        while (!pq.isEmpty()) {
            ListNode nextOrderNode = pq.poll();
            sortedPtr.next = nextOrderNode;
            sortedPtr = sortedPtr.next;
            if (nextOrderNode.next != null) {
                pq.add(nextOrderNode.next);
            }
        }
        return sortedHead.next;
    }
}
