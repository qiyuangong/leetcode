package linkedlist;

import model.ListNode;

/**
 * Liked
 */
public class LikedListSolution {

    /**
     * @return
     * @Author s·D·bs
     * @Description //reverse List
     * @Date 2019-12-24 18:00
     * @Param
     */
    public static ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {//这里应该是cur!=null
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}
