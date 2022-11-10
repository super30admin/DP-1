class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0
        
        zero = 0
        first = nums[0]
        
        for i in range(1, len(nums)):
            temp = zero
            zero = max(zero, first)
            first = temp + nums[i]
            
        return max(zero, first)
