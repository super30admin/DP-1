# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class Solution:
    def rob(self, nums: List[int]) -> int:
        
        dp = [0] * (len(nums) + 1)
        
        n = len(nums) 
        
        # base cases
        dp[n] = 0
        dp[n-1] = nums[n-1] 
        
        for i in range(n-2, -1, -1):
            
            # get max from the previous house or second previous house plus current house
            dp[i] = max(dp[i+1], dp[i+2] + nums[i]) # recurrence relation
            
        return dp[0]