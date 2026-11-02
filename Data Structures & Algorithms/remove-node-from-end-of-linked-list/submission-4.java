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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return rec(head, new ListNode(n));
    }

    public ListNode rec(ListNode head, ListNode n) {
        if (head == null) {
            return null;
        }

        head.next = rec(head.next, n);
        n.val--;

        if (n.val == 0) {
            return head.next;
        }

        return head;
    }
}
