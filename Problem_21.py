# Time Complexity : O(n) where n is the length of the list nums
# Space Complexity :O(n) auxiliary space needed for the 1D DP table 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def rob(self, nums: List[int]) -> int:
        dp = [None for _ in range(len(nums)+1)] # Initialize a DP array
        
        n = len(dp)
        # The decision we make at each step is whether to select the current element and skip the next one or skip the current element and go to next one
        # So, dp[i] should be max of dp[i+1] (when we skip the current element) and nums[i]+dp[i+2] (where we choose the current element, add nums[i] to our value and then skip i+1 and go to i+2 where the best value at i+2 is given by dp[i+2])
        # SInce we require values of i+1 and/or i+2 in the DP table, we start from the last and finally get our answer at dp[0]
        dp[n-1] = 0 # Initialize last element in DP array as 0
        dp[n-2] = nums[n-2] # Initialize the next to last element in DP array as the nums value at that index
        for i in range(n-3,-1,-1):
            # Iterate backwards through n-3 to index 0 (including index 0) 
            dp[i] = max(dp[i+1],nums[i]+dp[i+2])
        return dp[0] # Return ans
        
        