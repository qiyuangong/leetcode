package linkedlist;

import model.ListNode;

/**
 * Liked
 */
public class LikedListSolution {

    /**
     * @Author s·D·bs
     * @Description //reverse List
     * @Date 2019-12-24 18:00
     * @Param
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while (cur.next != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}
