// Remove Rotate List
// 时间复杂度O(n)，空间复杂度O(1)
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;

        int len = 1;
        ListNode p = head;
        while (p.next != null) { // 求长度
            len++;
            p = p.next;
        }
        k = len - k % len;

        p.next = head; // 首尾相连
        for(int step = 0; step < k; step++) {
            p = p.next;  //接着往后跑
        }
        head = p.next; // 新的首节点
        p.next = null; // 断开环
        return head;
    }
};