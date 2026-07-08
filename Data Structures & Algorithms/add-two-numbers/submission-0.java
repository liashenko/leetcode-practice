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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode curr = res;
        int remainder = 0;
        while (l1 != null || l2 != null) {
            int l1val = l1 == null ? 0 : l1.val;
            int l2val = l2 == null ? 0 : l2.val;
            int sum = l1val + l2val + remainder;
            remainder = sum/10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (remainder > 0) {
            curr.next = new ListNode(1);
        }
        return res.next;
    }
}
