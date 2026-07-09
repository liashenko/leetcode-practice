/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
        for (ListNode node : lists) {
            pq.offer(node);
        }
        ListNode merged = new ListNode();
        ListNode curr = merged;
        while (!pq.isEmpty()) {
            curr.next = pq.poll();
            if (curr.next.next != null)
                pq.offer(curr.next.next);
            curr = curr.next;
        }
        return merged.next;
    }
}
