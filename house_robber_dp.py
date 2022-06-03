# Time Complexity : O(n) where is n is number of houses
# Space Complexity : O(n) where is n is number of houses
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 0: return 0
        if len(nums) < 2: return nums[0]
        dp = [0 for _ in range(len(nums))]
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        for i in range(2, len(nums)):
            dp[i] = max(dp[i-1], dp[i-2] + nums[i])
            
        
        return dp[len(dp)-1]