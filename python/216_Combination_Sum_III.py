import itertools as it

class Solution(object):
    def combinationSum3(self, k, n):
        """
        :type k: int
        :type n: int
        :rtype: List[List[int]]
        """
        return list(it.ifilter(lambda x: sum(x) == n, list(it.combinations(range(1, 10), k))))
