// Remove Nth Node From End of List
// 时间复杂度O(n)，空间复杂度O(1)
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy, q = dummy;

        for (int i = 0; i < n; i++)  // q先走n步
            q = q.next;

        while(q.next != null) { // 一起走
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return dummy.next;
    }
}