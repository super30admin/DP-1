#Tume complexity: O(n): where n: # of houses
#Space complexity: O(n)
#Worked on leetcode
#This algorithm uses dynamic programming, by first calculating the optimal value when
# a house is not chosen, versus when a house is chosen, for each house iteratively.
# It then takes the maximum value of when all houses are covered, and we decide whether
# or not to choose it.

class Solution:
    def rob(self, nums: List[int]) -> int:

        if len(nums) == 0:
            return 0

        dp = [[0 for _ in range(2)] for _ in range(len(nums))]

        dp[0][1] = nums[0]
        for i in range(1, len(nums)):
            dp[i][0] = max(dp[i - 1][:])
            dp[i][1] = dp[i - 1][0] + nums[i]

        return max(dp[len(nums) - 1])



