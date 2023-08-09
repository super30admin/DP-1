# Time Complexity : O(N) as it is single pass
# Space Complexity : O(N) for the array, it can also be done with 2 variables to make space O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : I got stuck at the starting range of the for loop

class Solution:
    def rob(self, nums) -> int:
        if len(nums) == 0 or nums is None:
            return 0
        
        dp = [0 for i in range(len(nums) + 1)]
        
    
        dp[-2] = nums[-1]  # if only one house to rob
        
        # as last one is set to 0 if no houses left to rob, 
        # and last - 1 is set to last of nums as only one house to rob
        for i in range(len(dp) - 3, -1, -1):
            
            dp[i] = max(dp[i+1], nums[i] + dp[i+2])  # max(dp[current + 1], nums[current] + (dp[current + 2]))
        
        return dp[0]
            