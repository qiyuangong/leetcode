class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        # remeainders[0] = 0 is for when x == 0
        remainders = dict()
        remainders[0] = 0
        pre_sum = 0

        for idx, item in enumerate(nums):
            pre_sum += item
            remaind = pre_sum % k

            # remainder doesnt exist then it has to be init
            # if it exists, then check the prev one has the same remainder
            if remaind not in remainders:
                remainders[remaind] = idx + 1
            elif remainders[remaind] < idx:
                return True

        return False
    
