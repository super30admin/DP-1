#Time complexity: O(n)
#Space complexity: O(1)

class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0
        
        if len(nums) == 1:
            return nums[0]
        
        prev_0 = nums[0]
        prev_1 = max(prev_0, nums[1])
        
        for i in range(2, len(nums)):
            prev_0, prev_1 = prev_1, max(prev_0+ nums[i], prev_1)
            
        return prev_1
