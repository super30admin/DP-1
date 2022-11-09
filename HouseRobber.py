#Time Complexity: O(n)
#Space Complexity: O(n)
#Successfully ran on leetcode

class Solution:
    def rob(self, nums: list(int)) -> int:
        dp = []
        dp.append(0)
        dp.append(nums[0])
        for i in range(2,len(nums)+1):
            dp.append(max(dp[i-2]+nums[i-1],dp[i-1]))
        return dp[len(nums)]