"""

Time Complexity : O(2^n) where n is number of houses.
Space Complexity : O(n)
    
"""

class Solution:
    def helper(self, nums, index, max_rob):
        
        if index >= len(nums):
            return max_rob
        
        case1 = self.helper(nums, index + 2, max_rob + nums[index])
        case2 = self.helper(nums, index + 1, max_rob)
        
        return max(case1, case2)
        
    def rob(self, nums: List[int]) -> int:
        if not nums or len(nums) == 0:
            return 0 
        
        return self.helper(nums, 0, 0)
    