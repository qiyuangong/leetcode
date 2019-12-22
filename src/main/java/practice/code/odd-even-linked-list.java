// Odd Even Linked List
// Time Complexity: O(n), Space Complexity: O(1)
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        final ListNode oddDummy = new ListNode(0);
        final ListNode evenDummy = new ListNode(0);
        ListNode odd = oddDummy;
        ListNode even = evenDummy;

        int index = 1;
        while (head != null) {
            if (index  % 2 == 1) {
                odd.next = head;
                odd = odd.next;
            } else {
                even.next = head;
                even = even.next;
            }

            ListNode tmp = head.next;
            head.next = null;
            head = tmp;
            ++index;
        }

        odd.next = evenDummy.next;
        return oddDummy.next;
    }
}