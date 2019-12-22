// Remove Duplicates from Sorted List
// 迭代版，时间复杂度O(n)，空间复杂度O(1)
class Solution {
public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        for (ListNode prev = head, cur = head.next; cur != null; cur = prev.next) {
            if (prev.val == cur.val) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
        }
        return head;
    }
};