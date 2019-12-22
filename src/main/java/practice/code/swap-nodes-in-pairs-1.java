// Swap Nodes in Pairs
// 时间复杂度O(n)，空间复杂度O(1)
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        for(ListNode prev = dummy, cur = prev.next, next = cur.next;
                next != null;
                prev = cur, cur = cur.next, next = cur != null ? cur.next: null) {
            prev.next = next;
            cur.next = next.next;
            next.next = cur;
        }
        return dummy.next;
    }
}