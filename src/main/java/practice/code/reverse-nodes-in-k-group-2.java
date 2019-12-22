// Reverse Nodes in k-Group
// 迭代版，时间复杂度O(n)，空间复杂度O(1)
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        for(ListNode prev = dummy, end = head; end != null; end = prev.next) {
            for (int i = 1; i < k && end != null; i++)
                end = end.next;
            if (end  == null) break;  // 不足 k 个

            prev = reverse(prev, prev.next, end);
        }

        return dummy.next;
    }

    // prev 是 first 前一个元素, [begin, end] 闭区间，保证三者都不为 null
    // 返回反转后的倒数第1个元素
    ListNode reverse(ListNode prev, ListNode begin, ListNode end) {
        ListNode end_next = end.next;
        for (ListNode p = begin, cur = p.next, next = cur.next;
                cur != end_next;
                p = cur, cur = next, next = next != null ? next.next : null) {
            cur.next = p;
        }
        begin.next = end_next;
        prev.next = end;
        return begin;
    }
};