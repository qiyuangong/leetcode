// Sort List
// 归并排序，时间复杂度O(nlogn)，空间复杂度O(1)
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)return head;

        final ListNode middle = findMiddle(head);
        final ListNode head2 = middle.next;
        middle.next = null; // 断开

        final ListNode l1 = sortList(head);  // 前半段排序
        final ListNode l2 = sortList(head2);  // 后半段排序
        return mergeTwoLists(l1, l2);
    }

    // Merge Two Sorted Lists
    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        for (ListNode p = dummy; l1 != null || l2 != null; p = p.next) {
            int val1 = l1 == null ? Integer.MAX_VALUE : l1.val;
            int val2 = l2 == null ? Integer.MAX_VALUE : l2.val;
            if (val1 <= val2) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
        }
        return dummy.next;
    }
    // 快慢指针找到中间节点
    private static ListNode findMiddle(ListNode head) {
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}