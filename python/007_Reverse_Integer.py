class Solution:
    def reverse(self, x):
        # https://leetcode.com/problems/reverse-integer/
        flag = True if x < 0 else False
        if flag:
            x = -x
        x = str(x)[::-1]

        if flag:
            x = "-" + x

        value = 2 ** 31
        x = int(x)
        if -value <= x < value:
            return x
        return 0
    
