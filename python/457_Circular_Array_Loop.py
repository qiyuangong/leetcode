class Solution:
    def circularArrayLoop(self, nums: List[int]) -> bool:
        for i in range(len(nums)):
            if nums[i] == 0:
                continue
            
            # if slow and fast pointers collide, then there exists a loop
            slow = i
            fast = self.index(nums, slow)
            while nums[slow] * nums[fast] > 0 and nums[slow] * nums[self.index(nums, fast)] > 0:
                if slow == fast and fast != self.index(nums, fast):
                    return True
                elif slow == fast and fast == self.index(nums, fast):
                    break
                slow = self.index(nums, slow)
                fast = self.index(nums, self.index(nums, fast))
                
            # set path to all 0s since it doesn't work
            runner = i
            value = nums[runner]
            while nums[runner] * value > 0:
                temp = self.index(nums, runner)
                nums[runner] = 0
                runner = temp
        return False
            
    def index(self, nums, index):
        length = len(nums)
        return (index + nums[index] + length) % length
