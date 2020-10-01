class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        if N==1:
            return 1
        d1={}
        d2={}
        for i, j in trust:
            if j in d1:
                d1[j]+=1
            else:
                d1[j]=1
            if i in d2:
                d2[i]+=1
            else:
                d2[i]=1
        for i,j in d1.items():
            if j==N-1:
                if i not in d2:
                    return i
        return -1
                    
