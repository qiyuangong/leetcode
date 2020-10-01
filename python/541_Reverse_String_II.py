class Solution:
    def reverseStr(self, s, k):
        N = len(s)
        ans = ""
        position = 0
        while position < N:
            nx = s[position : position + k]
            ans = ans + nx[::-1] + s[position + k : position + 2 * k]
            position += 2 * k
        return ans

        

s1 = Solution()
s="abcdefg"
k=2
print(s1.reverseStr(s,k))
