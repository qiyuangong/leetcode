// Reverse Linked List
// Time Complexity: O(n), Space Complexity: O(n)
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode tail = head.next;
        head.next = null;
        ListNode newHead = reverseList(tail);
        tail.next = head;
        
        return newHead;
    }
}