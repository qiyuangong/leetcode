// Palindrome Linked List
// Time Complexity: O(n), Space Complexity: O(1)
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;

        final ListNode middle = findMiddle(head);
        middle.next = reverse(middle.next);

        ListNode p1 = head;
        ListNode p2 = middle.next;
        while (p1 != null && p2 != null && p1.val == p2.val) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2 == null;

    }
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

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }

        return prev;
    }
}