# Memoization
# Time Complexity: O(n)
# Space Complexity: O(n)
from typing import List

class Solution:
    def rob(self, nums: List[int]) -> int:
        memo = {}
        
        def rob_helper(i):
            if i < 0:
                return 0
            if i in memo:
                return memo[i]
            
            rob_current_house = nums[i] + rob_helper(i - 2)
            skip_current_house = rob_helper(i - 1)
            
            memo[i] = max(rob_current_house, skip_current_house)
            return memo[i]
        
        return rob_helper(len(nums) - 1)
# DP
# Time Complexity: O(n)
# Space Complexity: O(n)
from typing import List

class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0
        if len(nums) == 1:
            return nums[0]
        
        dp = [0] * len(nums)
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        
        for i in range(2, len(nums)):
            dp[i] = max(dp[i-1], dp[i-2] + nums[i])
        
        return dp[-1]
# DP 2 - we can further optimize space
# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0
        if len(nums) == 1:
            return nums[0]
        
        prev, curr = nums[0], max(nums[0], nums[1])
        
        for i in range(2, len(nums)):
            prev, curr = curr, max(curr, prev + nums[i])
        
        return curr
