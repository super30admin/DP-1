"""
Time Complexity : O(2^n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Time Limit exceed
Any problem you faced while coding this : No
"""
class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        return self.helper(nums, 0, 0)
    
    def helper(self, nums: List[int], index: int, amount: int):
        # Base case
        if index >= len(nums):
            return amount
        # Logic
        # Don't rob case
        case1 = self.helper(nums, index + 1, amount)
        
        # Rob house case
        case2 = self.helper(nums, index + 2, amount + nums[index])
        
        return max(case1, case2)