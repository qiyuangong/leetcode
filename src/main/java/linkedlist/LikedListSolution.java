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
     * @Description
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

    /**
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        //需要成双成对

        ListNode one = head;
        ListNode two = head.next;
        while (head != null) {
            ListNode temp = two;
            two = one;
            one.next = temp;
            head = head.next;
        }
        return head;
    }
}
