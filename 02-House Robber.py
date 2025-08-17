# Problem 2 - House Robber (https://leetcode.com/problems/house-robber/)
class Solution:
    def rob(self, nums: List[int]) -> int:
    # Approach 1 : Recursive Solution
    #     if nums == None or len(nums) == 0:
    #         return 0
    #     return self.recurse(nums, 0, 0)
    
    # def recurse(self, nums: List[int], amountRobbed : int, index : int) -> int:
    #     # base
    #     if index >= len(nums):
    #         return amountRobbed

    #     # logic
    #     case0 = self.recurse(nums, amountRobbed, index + 1)
    #     case1 = self.recurse(nums, amountRobbed + nums[index], index + 2)

    #     return max(case0, case1)
    # Approach 2 : Dynamic Programming
        if nums == None or len(nums) == 0:
            return 0
        n = len(nums)
        dp = [[0 for i in range(2)] for j in range(n)]
        dp[0][1] = nums[0]
        for i in range(1,n):
            dp[i][0] = max(dp[i-1][0], dp[i-1][1])
            dp[i][1] = dp[i-1][0] + nums[i]
        return max(dp[n-1][0], dp[n-1][1])        