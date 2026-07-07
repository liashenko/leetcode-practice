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
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next; // 2
            curr.next = prev; // 1 -> 0 -> null
            prev = curr; // 1 -> 0 -> null
            curr = next; // 1
        }
        return prev;
    }
}
