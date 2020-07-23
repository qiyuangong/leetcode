'''
Given head which is a reference node to a singly-linked list. 
The value of each node in the linked list is either 0 or 1. 
The linked list holds the binary representation of a number.
Return the decimal value of the number in the linked list.
Example 1:
Input: head = [1,0,1]
Output: 5
Explanation: (101) in base 2 = (5) in base 10
Example 2:
Input: head = [0]
Output: 0
Example 3:
Input: head = [1]
Output: 1
Example 4:
Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
Output: 18880
Example 5:
Input: head = [0,0]
Output: 0
Constraints:
The Linked List is not empty.
Number of nodes will not exceed 30.
Each node's value is either 0 or 1.
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getDecimalValue(self, head: ListNode) -> int:
        binary_numbers_list=[]
        binary_numbers_list.append(head.val)
        while(head.next!=None):
            head=head.next
            binary_numbers_list.append(head.val)
        answer=0
        power=0
        for digit in range(len(binary_numbers_list)-1,-1,-1):
            if(binary_numbers_list[digit]>0):
                answer+=((2**power)*binary_numbers_list[digit])
            power+=1
        return answer
