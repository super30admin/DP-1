# Time Complexity : O(n) Length of num array
# Space Complexity : O(n) Length of num array

from typing import List
class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        
        # Base case
        if n == 0:
            return 0
        elif n == 1:
            return nums[0]
        
        # Initialize dp array with the first two values
        dp = [0] * n
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        
        # Calculate the maximum sum by considering the previous two values
        for i in range(2, n):
            dp[i] = max(dp[i-1], dp[i-2] + nums[i])
        
        # Return the maximum sum
        return dp[n-1]
