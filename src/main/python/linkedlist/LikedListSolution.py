class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:

    def reverseList(self, head: ListNode) -> ListNode:
        '''
        reverse linked list
        :param head:
        :return:
        '''

        cur, prev = head, None
        # while cur:
        #     cur_next = cur.next
        #     # 交换位置
        #     cur.next = prev  # cur尾部节点是null
        #     prev = cur
        #     cur = cur_next
        while cur:
            cur.next, prev, cur = prev, cur, cur.next
        return prev

    def hasCycle(self, head: ListNode) -> bool:
        '''
        此种最优
        :param head:
        :return:
        '''
        if head is None or head.next is None:
            return False
        slow = head
        fast = head.next
        while slow != fast:
            if fast is None or fast.next is None:
                return False
            slow = slow.next
            fast = fast.next.next
        return True

    def hasCycle1(self, head: ListNode) -> bool:
        fast, slow = head, head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if slow is fast:
                return True
        return False

    def swapPairs(self, head: ListNode) -> ListNode:
        '''
        给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
        你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
        :param head:
        :return:
        '''
        p = head
        while p and p.next:
            temp = p.val
            p.val = p.next.val
            p.next.val = temp
            p = p.next.next
        return head


if __name__ == '__main__':
    solution = Solution()

    listNode1 = ListNode(1)
    listNode2 = ListNode(2)
    listNode3 = ListNode(3)
    listNode4 = ListNode(4)
    listNode5 = ListNode(5)

    listNode1.next = listNode2
    listNode2.next = listNode3
    listNode3.next = listNode4
    listNode4.next = listNode5
    listNode5.next = None

    node = solution.reverseList(listNode1)

