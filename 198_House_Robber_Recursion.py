class Solution:
    def robRecursion(self, nums, i):
        if i < 0:
            return 0
        if i < 1:
            return nums[0]
        return max(nums[i]+self.robRecursion(nums, i-2) , self.robRecursion(nums, i-1))
        
    def rob(self, nums: List[int]) -> int:
        if not nums:return 0
        if len(nums) == 1:return nums[0]
        return self.robRecursion(nums, len(nums)-1)