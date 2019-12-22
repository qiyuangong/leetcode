// Reverse Linked List
// Time Complexity: O(n), Space Complexity: O(1)
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode tail = null;
        ListNode p = head;
        ListNode q = p.next;

        while (q != null) {
            ListNode old = q.next;
            p.next = tail;
            q.next = p;

            tail = p;
            p = q;
            q = old;
        }
        return p;
    }
}