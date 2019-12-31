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
    public static ListNode reverseList(ListNode head) {
        ListNode cur = head;//当前节点指针
        ListNode prev = null;//前一个节点指针
        //每次循环都把当前节点指向前一个节点，把前节点和当前节点后移
        while (cur != null) {
            ListNode temp = cur.next;//用于后移
            //当前节点指向前一个节点并且后移
            cur.next = prev;
            //前节点后移
            prev = cur;
            //进行下一次循环
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
        Set<ListNode> set = new HashSet<ListNode>();
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
        ListNode p = head;
        while (p != null && p.next != null) {
            int temp = p.val;
            p.val = p.next.val;
            p.next.val = temp;
            p = p.next.next;
        }
        return head;
    }

    /**
     * 给定一个链表，返回循环开始的节点。如果没有循环，则返回null。
     * 为了表示给定链表中的循环，我们使用一个整数pos来表示尾部连接到的链表中的位置（0索引）。如果pos为-1，则链接列表中没有循环。
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        //4 使用快慢指针和前一个指针
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
