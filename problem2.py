# Time Complexity :O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode :yes

from ast import List

class Solution:
    def rob(self, nums: List[int]) -> int:
        self.dp = [None] * len(nums) 
        result = self.helper(nums, 0)
        return result
    
    def helper(self, nums, idx):
        #base case
        if idx >= len(nums):
            return 0
        
        if self.dp[idx] is not None:
            return self.dp[idx]  # Access self.dp instead of dp

        #logic
        #if rob
        case1 = nums[idx] + self.helper(nums, idx+2)

        #if not rob
        case2 = self.helper(nums, idx+1)

        self.dp[idx] = max(case1, case2)
        return self.dp[idx]
