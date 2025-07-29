# Did this code successfully run on Leetcode: YES
# Any problem you faced while coding this: NO

# Recurssion approach
# Time Complexity: O(2^n+m)
# Space Complexity: O(n)

class Solution:
    def rob(self, nums: list[int]) -> int:
        
        if nums == None or len(nums) == 0:
            return -1
        return self.recurse(nums, 0, 0)

    def recurse(self, nums: list[int], index, robbed) -> int:

        # base condition:
        if len(nums) <= 2:
            return nums(0)
        if index >= len(nums):
            return robbed

        # logic:
        case0 = self.recurse(nums, index + 1, robbed)
        case1 = self.recurse(nums, index + 2, robbed + nums[index])
        
        return max(case0,case1)

# Tabulation Approach
# Time Complexity: O(n)
# Space Complexity: O(n)

class Solution:
    def rob(self, nums: list[int]) -> int:

        if nums == None or len(nums) == 0:
            return -1

        n= len(nums)

        dp = [[0] * 2 for i in range(n)]
        dp[0][1] = nums[0]

        for i in range(1,n):
            dp[i][0] = max(dp[i-1][0],dp[i-1][1])
            dp[i][1] = dp[i-1][0] + nums[i]

        return max(dp[n-1][0],dp[n-1][1])