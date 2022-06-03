'''
Time Complexity : O(n) where n is the number of houses
Space Complexity: O(1) 
Run on LeetCode : YES
Problems: Coming up with a solution that has constant space complexity.
'''
class Solution:
    def rob(self, nums: list[int]) -> int:
        dp = [0] * 3
        dp[1] = nums[0]
        for i in range(1 , len(nums)):
            dp[2] = max(dp[0] + nums[i], dp[1])
            dp[0] = dp[1]
            dp[1] = dp[2]
        if dp[2] != 0:
            return dp[2]
        return dp[1]