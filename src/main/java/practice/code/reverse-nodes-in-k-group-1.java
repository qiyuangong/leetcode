
// Reverse Nodes in k-Group
// 递归版，时间复杂度O(n)，空间复杂度O(1)
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2)
            return head;

        ListNode next_group = head;
        for (int i = 0; i < k; ++i) {
            if (next_group != null)
                next_group = next_group.next;
            else
                return head;
        }
        // next_group is the head of next group
        // new_next_group is the new head of next group after reversion
        ListNode new_next_group = reverseKGroup(next_group, k);
        ListNode prev = null, cur = head;
        while (cur != next_group) {
            ListNode next = cur.next;
            cur.next = prev != null ? prev : new_next_group;
            prev = cur;
            cur = next;
        }
        return prev; // prev will be the new head of this group
    }
}