class Solution:
    # def searchInsert(self, nums, target):
    #     """
    #     :type nums: List[int]
    #     :type target: int
    #     :rtype: int
    #     """
    #     min, pos = 0, 0
    #     max = len(nums) - 1
    #     while min <= max:
    #         # binary search
    #         pos = (max + min) / 2
    #         if nums[pos] == target:
    #             return pos
    #         elif nums[pos] > target:
    #             max = pos - 1
    #         else:
    #             min = pos + 1
    #     if min > pos:
    #         # this means that target is great than pos, and target
    #         # is not in nums
    #         return pos + 1
    #     return pos

    def searchInsert(self, nums, target):
        l, r = int(0), len(nums) - 1
        while l < r:
            mid = int((l + r) / 2)
            if nums[mid] < target:
                l = mid + 1
            else:
                r = mid
        if nums[l] < target:
            return l + 1
        return l 

    
    
if __name__ == '__main__':
    # begin
    s = Solution()
    print (s.searchInsert([1,3,5,6],5))    
    
