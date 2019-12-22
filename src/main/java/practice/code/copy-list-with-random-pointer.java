// Copy List with Random Pointer
// 两遍扫描，时间复杂度O(n)，空间复杂度O(1)
class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        for (RandomListNode cur = head; cur != null; ) {
            RandomListNode node = new RandomListNode(cur.label);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }

        for (RandomListNode cur = head; cur != null; ) {
            if (cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }

        // 分拆两个单链表
        RandomListNode dummy = new RandomListNode(-1);
        for (RandomListNode cur = head, new_cur = dummy;
                cur != null; ) {
            new_cur.next = cur.next;
            new_cur = new_cur.next;
            cur.next = cur.next.next;
            cur = cur.next;
        }
        return dummy.next;
    }
};