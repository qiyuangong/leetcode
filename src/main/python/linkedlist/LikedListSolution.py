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
        fast, slow = head,head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if slow is fast:
                return True
        return False
