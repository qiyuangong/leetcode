// Merge Two Sorted Lists
// 时间复杂度O(min(m,n))，空间复杂度O(1)
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        for (; l1 != null && l2 != null; p = p.next) {
            if (l1.val > l2.val) { p.next = l2; l2 = l2.next; }
            else { p.next = l1; l1 = l1.next; }
        }
        p.next = l1 != null ? l1 : l2;
        return dummy.next;
    }
}