// Remove Duplicates from Sorted List II
// 递归版，时间复杂度O(n)，空间复杂度O(1)
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head ==null || head.next == null) return head;

        ListNode p = head.next;
        if (head.val == p.val) {
            while (p != null && head.val == p.val) {
                p = p.next;
            }
            return deleteDuplicates(p);
        } else {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }
};