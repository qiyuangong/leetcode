// Remove Duplicates from Sorted List
// 递归版，时间复杂度O(n)，空间复杂度O(1)
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(head.val + 1); // 值只要跟head不同即可
        dummy.next = head;

        recur(dummy, head);
        return dummy.next;
    }
    private static void recur(ListNode prev, ListNode cur) {
        if (cur == null) return;

        if (prev.val == cur.val) { // 删除head
            prev.next = cur.next;
            recur(prev, prev.next);
        } else {
            recur(prev.next, cur.next);
        }
    }
};