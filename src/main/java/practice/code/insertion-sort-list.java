// Insertion Sort List
// 时间复杂度O(n^2)，空间复杂度O(1)
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        //dummy.next = head;

        for (ListNode cur = head; cur != null;) {
            ListNode pos = findInsertPos(dummy, cur.val);
            ListNode tmp = cur.next;
            cur.next = pos.next;
            pos.next = cur;
            cur = tmp;
        }
        return dummy.next;
    }

    ListNode findInsertPos(ListNode head, int x) {
        ListNode pre = null;
        for (ListNode cur = head; cur != null && cur.val <= x;
             pre = cur, cur = cur.next)
            ;
        return pre;
    }
}