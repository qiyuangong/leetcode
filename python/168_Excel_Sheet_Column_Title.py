class Solution:
    def convertToTitle(self, n: int) -> str:
        res = ""
        while n > 0:
            n -= 1
            res = chr(65 + n % 26) + res
            n //= 26
        return res
