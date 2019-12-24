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
    nodelist = []

