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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prevGroupTail = dummy;
        while (true) {
            boolean kLeft = true;
            ListNode curr = prevGroupTail;
            for (int i = 0; i < k; ++i) {
                curr = curr.next;
                if (curr == null) {
                    kLeft = false;
                    break;
                }
            }
            if (!kLeft) {
                break;
            }
            ListNode nextGroupHead = curr.next;
            // reverse
            curr = prevGroupTail.next; 
            ListNode prev = nextGroupHead; 
            for (int i = 0; i < k; ++i) {
                ListNode next = curr.next; 
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            ListNode next = prevGroupTail.next;
            prevGroupTail.next = prev;
            prevGroupTail = next;
        }
        return dummy.next;
    }
}
