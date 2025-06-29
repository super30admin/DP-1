# Time Complexity: O(n)
# Space Complexity: O(n)
# Were you able to run the code on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution:
    def rob(self, nums: List[int]) -> int:
        
        if not nums:
            return 0

        n = len(nums)
        if n == 1:
            return nums[0]

        # Start with DP approach, chech whether to rob the first house or not based on the max amount robbed so far
        dp = [0] * n
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])

        # Track the maximum amount that can be robbed up to each house
        for i in range(2, n):
            dp[i] = max(dp[i-1], dp[i-2] + nums[i])

        return dp[-1]
    
