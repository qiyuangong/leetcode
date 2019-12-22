
// Swap Nodes in Pairs
// 时间复杂度O(n)，空间复杂度O(1)
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode p = head;

        while (p != null && p.next != null) {
            int tmp = p.val;
            p.val = p.next.val;
            p.next.val = tmp;

            p = p.next.next;
        }

        return head;
    }
}