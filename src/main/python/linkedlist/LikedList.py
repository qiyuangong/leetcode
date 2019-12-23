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
