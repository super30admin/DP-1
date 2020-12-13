# Approach:  We will use dynamic prgramming with memoization to solve this question
# What we will do is take an array to store some results. A value at index 1 will represent the maximum cash a robber can rob if only one house is present on that street. Same logic goes for all the values at consecutive indices.
# Logic to populate an index i with any value we need to calulcate max of(value if there were only i-2 houses + money in current house, value if there are only i-1 houses)

# Time Complexity: O(n) where n= length of the nums array
# Space Complexity: O(n) where n= length of the nums array

class Solution:
    def rob(self, nums: List[int]) -> int:
        
        n = len(nums)
        
        # base conditions
        if n == 0:
            return 0
        if n == 1:
            return nums[0]
        if n == 2:
            return max(nums[0],nums[1])
    
        dp = [0] * n
        dp[0] = nums[0]
        dp[1] = max(nums[0],nums[1])

        for i in range(2,n):
            dp[i] = max( dp[i-2] + nums[i], dp[i-1])
            
        return dp[-1]
        