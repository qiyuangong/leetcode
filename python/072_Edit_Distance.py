class Solution(object):
    # https://discuss.leetcode.com/topic/17639/20ms-detailed-explained-c-solutions-o-n-space/2
    # def minDistance(self, word1, word2):
    #     """
    #     :type word1: str
    #     :type word2: str
    #     :rtype: int
    #     """
    #     ls_1, ls_2 = len(word1), len(word2)
    #     dp = [[0] * (ls_2 + 1) for _ in range(ls_1 + 1)]
    #     for i in range(1, ls_1 + 1):
    #         dp[i][0] = i
    #     for j in range(1, ls_2 + 1):
    #         dp[0][j] = j
    #     for i in range(1, ls_1 + 1):
    #         for j in range(1, ls_2 + 1):
    #             if word1[i - 1] == word2[j - 1]:
    #                 dp[i][j] = dp[i - 1][j - 1]
    #             else:
    #                 dp[i][j] = min(dp[i - 1][j - 1] + 1,
    #                                dp[i][j - 1] + 1,
    #                                dp[i - 1][j] + 1)
    #     return dp[ls_1][ls_2]

    def minDistance(self, word1, word2):
        ls_1, ls_2 = len(word1), len(word2)
        dp = list(range(ls_1 + 1))
        for j in range(1, ls_2 + 1):
            pre = dp[0]
            dp[0] = j
            for i in range(1, ls_1 + 1):
                temp = dp[i]
                if word1[i - 1] == word2[j - 1]:
                    dp[i] = pre
                else:
                    dp[i] = min(pre + 1, dp[i] + 1, dp[i - 1] + 1)
                pre = temp
        return dp[ls_1]
    

    if __name__ == '__main__':
    # begin
    s = Solution()
    print (s.minDistance("horse","ros"))        
    print (s.minDistance("intention","execution"))        
