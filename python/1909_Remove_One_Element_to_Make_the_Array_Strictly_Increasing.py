class Solution:
    def canBeIncreasing(self, nums: List[int]) -> bool:
        # bruteforcing the whole idxes.
        canBe = [0] * len(nums)

        # choosing the idx that will be removed.
        for bannedIdx in range(len(nums)):
            Flag = 1

            # if the bannedIdx is 0 than the startIdx will be 2.
            # when bannedIdx is 0, idx 2 is the first element that has a previous element. 
            # In other cases, idx 1 is the one.
            for i in range(1 if bannedIdx != 0 else 2, len(nums)):
                # if i is bannedIdx than just skip it.
                if i == bannedIdx:
                    continue

                # if the previous element is banned.
                # compare [i] with [i - 2]
                if i - 1 == bannedIdx:
                    if nums[i] <= nums[i - 2]:
                        Flag = 0
                        break
                    continue

                # compare [i] with [i - 1]
                if nums[i] <= nums[i - 1]:
                    Flag = 0
                    break

            # end of loop we will get Flag that has a 0 or 1 value.
            canBe[bannedIdx] = Flag

        if sum(canBe) > 0:
            return True
        return False
                
