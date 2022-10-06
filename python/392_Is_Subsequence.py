class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        for a in s:
            if a in t:
                for b in range(0, len(t)):
                    if a==t[b]:
                        t=t[b+1:]
                        break
            else:
                return(False)
        return(True)
