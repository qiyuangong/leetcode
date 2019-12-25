package hhl.util;

import model.ListNode;

import java.util.LinkedList;
import java.util.List;

public class Utils {
    /**
     * 构造一个新的 ListNode 链表
     * @param len
     * @return
     */
    public static ListNode doMakeListNode(int len) {
        len++;
        List<ListNode> lists = new LinkedList<>();
        for (int i = 1; i <= len; i++) {
            lists.add(new ListNode(i));
        }
        for (int i = 0; i < len; i++) {
            if (i+1 == len-1) {
                lists.get(i + 1).next = null;
                  break;
            }
            lists.get(i).next = lists.get(i + 1);
        }
        return   lists.get(0);
    }
}
