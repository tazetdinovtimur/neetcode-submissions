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
        var i = 0;
        var len = 0;
        var tmpHead = head;

        while (tmpHead != null) {
            len++;
            tmpHead = tmpHead.next;
        }

        if (len == 1) {
            return null;
        }

        if (len - n == 0) {
            return head.next;
        }

        tmpHead = head;

        while (i < len - n - 1 && head != null) {
            i++;
            head = head.next;
        }

        if (head != null && head.next != null) {
            head.next = head.next.next;
        }

        return tmpHead;

        //return rec(head, new ListNode(n));
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
