# Problem2 (https://leetcode.com/problems/house-robber/)
class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 0 or nums == None:
            return 0
        if n < 2:
            return nums[0]
        dp = [0] * n
        dp[0] = nums[0]
        dp[1] = max(nums[0], 0 + nums[1])
        for i in range(2,n):
            dp[i] = max(dp[i-1], dp[i-2] + nums[i])
        return dp[-1]

#time and space complexity O(n)