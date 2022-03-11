'''
Given an integer n, return a string with n characters such that each character in such string occurs an odd number of times.
The returned string must contain only lowercase English letters. If there are multiples valid strings, return any of them.  
 Input: n = 4
Output: "pppz"
'''
class Solution:
    def generateTheString(self, n: int) -> str:
        if n%2==0:
            return "a" * (n-1) + "b"
        else:
            return "a" * n
