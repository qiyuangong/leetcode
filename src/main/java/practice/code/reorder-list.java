// Reorder List
// 时间复杂度O(n)，空间复杂度O(1)
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null; // cut at middle

        slow = reverse(slow);

        // merge two lists
        ListNode curr = head;
        while (curr.next != null) {
            ListNode tmp = curr.next;
            curr.next = slow;
            slow = slow.next;
            curr.next.next = tmp;
            curr = tmp;
        }
        curr.next = slow;
    }

    ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = head;
        for (ListNode curr = head.next, next = curr.next; curr != null;
            prev = curr, curr = next, next = next != null ? next.next : null) {
                curr.next = prev;
        }
        head.next = null;
        return prev;
    }
}