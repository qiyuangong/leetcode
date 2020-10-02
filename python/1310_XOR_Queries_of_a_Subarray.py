class Solution:
    def xorQueries(self, arr: List[int], queries: List[List[int]]) -> List[int]:
        pref = [0]
        for e in arr:
            pref.append(e ^ pref[-1])
        ans = []
        for [l, r] in queries:
            ans.append(pref[r+1] ^ pref[l])
        return ans
        
