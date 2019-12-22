// Add Two Numbers
// 跟Add Binary 很类似
// 时间复杂度O(m+n)，空间复杂度O(1)
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1); // 头节点
        int carry = 0;
        ListNode prev = dummy;
        for (ListNode pa = l1, pb = l2;
             pa != null || pb != null;
             pa = pa == null ? null : pa.next,
             pb = pb == null ? null : pb.next,
             prev = prev.next) {
            final int ai = pa == null ? 0 : pa.val;
            final int bi = pb == null ? 0 : pb.val;
            final int value = (ai + bi + carry) % 10;
            carry = (ai + bi + carry) / 10;
            prev.next = new ListNode(value); // 尾插法
        }
        if (carry > 0)
            prev.next = new ListNode(carry);
        return dummy.next;
    }
};