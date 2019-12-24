package linkedlist;

import model.ListNode;

import java.util.HashSet;
import java.util.Set;

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

    /**
     * @return
     * @Author s·D·bs
     * @Description //快慢指针
     * @Date 2019年12月24日23:04:19
     * @Param
     */

    public boolean hasCycle(ListNode head) {
        //1-直接循环直到下一个节点为null

        if (head == null || head.next == null) {
            return false;
        }
        while (head.next != null) {
            head = head.next;
        }
        return true;
    }

    /**
     * @return
     * @Author s·D·bs
     * @Description //ListNode 中是否含有环
     * @Date 2019年12月24日22:45:24
     * @Param
     */
    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        //使用快慢指针和前一个指针
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public boolean hasCycle3(ListNode head) {
        //2-使用set装节点判断是否存在set中
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }

    public boolean hasCycle4(ListNode head) {
        //4 使用快慢指针和前一个指针
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
