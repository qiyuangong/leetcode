#2420_Find_All_Good_Indices.py
class Solution:
    def goodIndices(self, nums: List[int], k: int) -> List[int]:
        # posi : count the increasing idxes
        # nega : count the decreasing idxes
        posi, nega = [0], [0]

        for i in range(1, len(nums)):
            diff = nums[i] - nums[i - 1]

            posi.append(posi[i - 1])
            nega.append(nega[i - 1])

            # if diff show positive or negative
            # then the value will updated
            if diff > 0:
                posi[i] += 1
            elif diff < 0:
                nega[i] += 1

        # ans : count the idxes that
        # before k element is non increasing
        # after k element is non decreasing
        ans = []
        for i in range(k, len(nums) - k):
            if i + k >= len(nums):
                break

            # check the condition with
            # for after, nega[i + 1], nega[i + k] is the two to check
            # for brfore, posi[i - 1], posi[i - k] is the two to check
            if nega[i + k] - nega[i + 1] > 0:
                continue
            if posi[i - 1] - posi[i - k] > 0:
                continue

            ans.append(i)
        return ans