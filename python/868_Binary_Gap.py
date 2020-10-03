class Solution:
    def binaryGap(self, n: int) -> int:
        current= 1
        last1 = -1
        out = 0
        while n > 0:
            if n%2 == 1:
                if last1 >= 1:
                    out = max(out, current - last1)
                last1 = current
            current += 1
            n = n//2
        return(out)
        
